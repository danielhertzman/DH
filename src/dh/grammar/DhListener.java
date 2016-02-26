// Generated from /Users/School/IdeaProjects/JesperU2Antlr/src/dh/grammar/Dh.g4 by ANTLR 4.5.1
package dh.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DhParser}.
 */
public interface DhListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DhParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(DhParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(DhParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DhParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DhParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(DhParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(DhParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(DhParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(DhParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(DhParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(DhParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(DhParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(DhParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DhParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DhParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(DhParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(DhParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DhParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(DhParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link DhParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(DhParser.AddContext ctx);
}