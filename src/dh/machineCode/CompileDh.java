package dh.machineCode;

import java.io.*;
import java.util.Scanner;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import dh.grammar.*;

public class CompileDh {
    public static void main(String[] args) throws IOException {
        String infnam = "src/programs/blubb.dh";
        String outfnam = "src/programs/blubbBin.hack";
        boolean traceOn = args.length < 3 || "traceOn".equalsIgnoreCase(args[2]);

//        if (args.length > 0) {
//            infnam = args[0];
//        } else {
//            System.out.println("Vilken fil vill du köra?");
//            Scanner scanner = new Scanner(System.in);
//            infnam = scanner.nextLine();
//        }

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(infnam));
        DhLexer lexer = new DhLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DhParser parser = new DhParser(tokens);
        ParseTree tree = parser.code();
        ParseTreeWalker walker = new ParseTreeWalker();
        HackGen out = new HackGen(1024, 2048, 1025);
        walker.walk(new Compiler(infnam, out, traceOn), tree);
        Writer w = new OutputStreamWriter(new FileOutputStream(outfnam), "US-ASCII");
        out.outputCode(w);
        w.close();
    }
}
