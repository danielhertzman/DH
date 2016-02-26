package dh;

import dh.grammar.DhLexer;
import dh.grammar.DhParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RunDh {
    public static void main(String[] args) throws IOException {
        String infnam;
        if (args.length > 0) {
            infnam = args[0];
        } else {
            System.out.println("Vilken fil vill du köra?");
            Scanner scanner = new Scanner(System.in);
            infnam = scanner.nextLine();
        }
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(infnam));
        DhLexer lexer = new DhLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DhParser parser = new DhParser(tokens);
        ParseTree tree = parser.code();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Interpreter(infnam), tree);
    }
}
