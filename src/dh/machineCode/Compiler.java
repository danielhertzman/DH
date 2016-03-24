package dh.machineCode;

import dh.grammar.DhBaseListener;
import dh.grammar.DhParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

/**
 * Created by Daniel Hertzman-Ericson on 2016-03-09.
 */
public class Compiler extends DhBaseListener {
    private final String infnam;
    private final boolean traceOn;
    private final HackGen out;
    private final HashMap<String, Integer> varAddress = new HashMap<String, Integer>();
    //private final Stack<Integer> addressStack = new Stack<Integer>();
    private int loopAddress;
    private int jumpEndInstructionAddr;

    public static final int SCREEN = 16384;

    public Compiler(String infnam, HackGen out, boolean traceOn){
        this.infnam = infnam;
        this.out = out;
        this.traceOn = traceOn;
    }

    private void tracePrint(String message) {
        if (traceOn)
            System.out.println("At operation " + out.currentCodeAddress() + ": " + message);
    }

    private int getVarAddr(Token tok) {

        String name = tok.getText();
        Integer a = varAddress.get(name);

        if (a == null) {
            return 0;
        } else {
            return a;
        }

    }

    private void error(int line, String msg) {
        System.err.println(infnam + ":" + line + ": " + msg);
    }

    @Override
    public void enterCode(DhParser.CodeContext ctx) {
        tracePrint("Initialize SP");
        out.emitInitSP();
    }

    @Override
    public void enterDecl(DhParser.DeclContext ctx) {

        String name = ctx.ID().getText();
        int addr = out.newVarAddr();
        Integer old = varAddress.put(name, addr);

        if (old != null) {
            error(ctx.ID().getSymbol().getLine(), "redefined " + name);
        }

    }

    @Override
    public void exitAssign(DhParser.AssignContext ctx) {

        int a = getVarAddr(ctx.ID().getSymbol());
        tracePrint("Pop from stack and put in "+a);
        out.emitPopStack2D();
        out.emitAInstr(a);
        out.emitCInstr(HackGen.DestM, HackGen.CompD, 0);//Load M[A] with D

    }


    @Override
    public void exitAdd(DhParser.AddContext ctx) {

        ParseTree operator = ctx.getChild(1); // the second token, if it's there, is the operator

        if (operator != null && "+".equals(operator.getText())) { // if it's plus, this is an addition
            // Add the top two numbers on the stack, leaving only the sum.
            tracePrint("Add top two numbers on the stack, leaving the sum");
            out.emitGetTwoOperands();         // Get operands.
            out.emitCInstr(HackGen.DestD, HackGen.DPlusM, 0); // Add them.
            out.emitReplaceTopWithD();        // Replace top of stack with sum.
        } else {
            // No operator we know, so it must be a lone term. Just leave it on the stack.
        }
    }

    @Override
    public void exitPrint(DhParser.PrintContext ctx) {
        out.emitPopStack2D();
        out.emitAInstr(SCREEN);
        out.emitCInstr(HackGen.DestM, HackGen.CompD, 0);
    }

    @Override
    public void enterAtomExpr(DhParser.AtomExprContext ctx) {

        if (ctx.ID() != null) {

            int a = getVarAddr(ctx.ID().getSymbol());
            tracePrint("Push contents of "+a+" on stack");
            out.emitAInstr(a);
            out.emitCInstr(HackGen.DestD, HackGen.CompM, 0);
            out.emitPushD2Stack();

        } else if (ctx.INT() != null) {

            int i = Integer.parseInt(ctx.INT().getText());
            tracePrint("Push "+i+" on stack");
            out.emitAInstr(i);
            out.emitCInstr(HackGen.DestD, HackGen.CompA, 0);
            out.emitPushD2Stack();
        }
    }

    @Override
    public void enterLoop(DhParser.LoopContext ctx) {

        int iAdress = varAddress.get("i");

        loopAddress = out.currentCodeAddress();

        out.emitAInstr(iAdress);
        out.emitCInstr(HackGen.DestD, HackGen.CompM, HackGen.NoJump);
        out.emitPushD2Stack();

        out.emitPopStack2D();
        jumpEndInstructionAddr = out.emitAInstr(0);
        out.emitCInstr(HackGen.DestD, HackGen.DMinus1, HackGen.JLT);

        out.emitAInstr(iAdress);
        out.emitCInstr(HackGen.DestM, HackGen.CompD, HackGen.NoJump);


    }

    @Override
    public void exitLoop(DhParser.LoopContext ctx) {

        out.emitAInstr(loopAddress);
        out.emitCInstr(HackGen.DestNone, HackGen.CompNone, HackGen.JMP);
        int endAddr = out.currentCodeAddress();
        out.reviseAInstr(jumpEndInstructionAddr, endAddr);
    }



}
