package dh;

import dh.grammar.DhBaseListener;
import dh.grammar.DhParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Stack;

public class Interpreter extends DhBaseListener{

    private static class Var { int val; }

    private final String infnam;
    private final HashMap<String, Var> vars = new HashMap<String, Var>();
    private Stack<Integer> stack = new Stack<Integer>();


    public Interpreter(String infnam) {
        this.infnam = infnam;
    }

    private Var getVar(Token tok) {

        String name = tok.getText();
        Var var = vars.get(name);

        if (var == null) {

            error(tok.getLine(), "undefined " + name);
            return new Var();   // avoid null pointer exception

        } else {
            return var;
        }
    }

    private void error(int line, String msg) {
        System.err.println(infnam + ":" + line + ": " + msg);
    }


    @Override
    public void enterStatement(DhParser.StatementContext ctx) { }

    @Override
    public void exitStatement(DhParser.StatementContext ctx) { }

    @Override
    public void enterDecl(DhParser.DeclContext ctx) {

        String name = ctx.ID().getText();

        Var old = vars.put(name, new Var());

        if (old != null) {
            error(ctx.ID().getSymbol().getLine(), "redefined " + name);
        }
    }

    @Override
    public void exitDecl(DhParser.DeclContext ctx) { }

    @Override
    public void enterAssign(DhParser.AssignContext ctx) {

    }

    @Override
    public void exitAssign(DhParser.AssignContext ctx) {

        getVar(ctx.ID().getSymbol()).val = stack.pop();

    }

    @Override
    public void enterLoop(DhParser.LoopContext ctx) {

    }

    @Override
    public void exitLoop(DhParser.LoopContext ctx) {

        ParseTreeWalker walker = new ParseTreeWalker();

        int times = stack.pop();

        for (int i = 0; i < times-1; i++) {
            walker.walk(this, ctx.code());
        }

    }

    @Override
    public void enterPrint(DhParser.PrintContext ctx) { }

    @Override
    public void exitPrint(DhParser.PrintContext ctx) {
        System.out.println(stack.pop());
    }

    @Override
    public void enterExpr(DhParser.ExprContext ctx) { }

    @Override
    public void exitExpr(DhParser.ExprContext ctx) {

    }

    @Override
    public void enterAtomExpr(DhParser.AtomExprContext ctx) {

        if (ctx.ID() != null) {

            stack.push(getVar(ctx.ID().getSymbol()).val);

        } else if (ctx.INT() != null) {

            stack.push(Integer.parseInt(ctx.INT().getText()));
        }
    }

    @Override
    public void exitAtomExpr(DhParser.AtomExprContext ctx) { }

    @Override
    public void enterAdd(DhParser.AddContext ctx) { }

    @Override
    public void exitAdd(DhParser.AddContext ctx) {

        if (ctx.expr() != null) {

            stack.push(stack.pop() + stack.pop());
        }
    }

}
