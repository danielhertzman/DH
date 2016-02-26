// Generated from /Users/School/IdeaProjects/JesperU2Antlr/src/dh/grammar/Dh.g4 by ANTLR 4.5.1
package dh.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DhLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, ID=11, INT=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "ID", "INT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'var'", "'='", "'yolo'", "'times:'", "'endloop'", "'pr'", 
		"'('", "')'", "'+'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "ID", 
		"INT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DhLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dh.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17S\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\6\fD\n\f\r\f\16\fE\3\r\6"+
		"\rI\n\r\r\r\16\rJ\3\16\6\16N\n\16\r\16\16\16O\3\16\3\16\2\2\17\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\3\5\2\13\f"+
		"\17\17\"\"U\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7#\3\2\2"+
		"\2\t%\3\2\2\2\13*\3\2\2\2\r\61\3\2\2\2\179\3\2\2\2\21<\3\2\2\2\23>\3\2"+
		"\2\2\25@\3\2\2\2\27C\3\2\2\2\31H\3\2\2\2\33M\3\2\2\2\35\36\7=\2\2\36\4"+
		"\3\2\2\2\37 \7x\2\2 !\7c\2\2!\"\7t\2\2\"\6\3\2\2\2#$\7?\2\2$\b\3\2\2\2"+
		"%&\7{\2\2&\'\7q\2\2\'(\7n\2\2()\7q\2\2)\n\3\2\2\2*+\7v\2\2+,\7k\2\2,-"+
		"\7o\2\2-.\7g\2\2./\7u\2\2/\60\7<\2\2\60\f\3\2\2\2\61\62\7g\2\2\62\63\7"+
		"p\2\2\63\64\7f\2\2\64\65\7n\2\2\65\66\7q\2\2\66\67\7q\2\2\678\7r\2\28"+
		"\16\3\2\2\29:\7r\2\2:;\7t\2\2;\20\3\2\2\2<=\7*\2\2=\22\3\2\2\2>?\7+\2"+
		"\2?\24\3\2\2\2@A\7-\2\2A\26\3\2\2\2BD\4c|\2CB\3\2\2\2DE\3\2\2\2EC\3\2"+
		"\2\2EF\3\2\2\2F\30\3\2\2\2GI\4\62;\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3"+
		"\2\2\2K\32\3\2\2\2LN\t\2\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2P"+
		"Q\3\2\2\2QR\b\16\2\2R\34\3\2\2\2\6\2EJO\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}