// Generated from com/allogica/allogen/idl/grammar/IDL.g4 by ANTLR 4.7
package com.allogica.allogen.idl.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IDLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OPEN_CURLY=10, CLOSE_CURLY=11, Integerliteral=12, Decimalliteral=13, Hexadecimalliteral=14, 
		Namespace=15, Class=16, Constructor=17, Destructor=18, Static=19, Annotation=20, 
		Identifier=21, False=22, True=23, Stringliteral=24, Floatingliteral=25, 
		WS=26, BlockComment=27, LineComment=28, DocumentationBlock=29, LineDirective=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"OPEN_CURLY", "CLOSE_CURLY", "Integerliteral", "Decimalliteral", "Hexadecimalliteral", 
		"HEXADECIMALDIGIT", "Namespace", "Class", "Constructor", "Destructor", 
		"Static", "Annotation", "Identifier", "False", "True", "Stringliteral", 
		"Schar", "Escapesequence", "Simpleescapesequence", "Floatingliteral", 
		"Fractionalconstant", "Exponentpart", "SIGN", "Digitsequence", "Floatingsuffix", 
		"Identifiernondigit", "NONDIGIT", "DIGIT", "NONZERODIGIT", "WS", "BlockComment", 
		"LineComment", "DocumentationBlock", "LineDirective"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'::'", "'('", "')'", "'<'", "','", "'>'", "';'", "':'", "'='", 
		"'{'", "'}'", null, null, null, "'namespace'", "'class'", "'constructor'", 
		"'destructor'", "'static'", "'@'", null, "'false'", "'true'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "OPEN_CURLY", 
		"CLOSE_CURLY", "Integerliteral", "Decimalliteral", "Hexadecimalliteral", 
		"Namespace", "Class", "Constructor", "Destructor", "Static", "Annotation", 
		"Identifier", "False", "True", "Stringliteral", "Floatingliteral", "WS", 
		"BlockComment", "LineComment", "DocumentationBlock", "LineDirective"
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


	public IDLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u0162\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\rs\n\r\3\16\3\16\5\16w\n\16\3\16"+
		"\7\16z\n\16\f\16\16\16}\13\16\3\17\3\17\3\17\3\17\5\17\u0083\n\17\3\17"+
		"\3\17\5\17\u0087\n\17\3\17\7\17\u008a\n\17\f\17\16\17\u008d\13\17\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\7\27\u00c4\n\27\f\27"+
		"\16\27\u00c7\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\7\32\u00d6\n\32\f\32\16\32\u00d9\13\32\3\32\3\32\3\33\3"+
		"\33\5\33\u00df\n\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u00f9\n\35\3\36\3\36\5\36\u00fd\n\36\3\36\5\36\u0100\n\36\3\36\3"+
		"\36\3\36\5\36\u0105\n\36\5\36\u0107\n\36\3\37\5\37\u010a\n\37\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u0111\n\37\3 \3 \5 \u0115\n \3 \3 \3 \5 \u011a\n"+
		" \3 \5 \u011d\n \3!\3!\3\"\3\"\5\"\u0123\n\"\3\"\7\"\u0126\n\"\f\"\16"+
		"\"\u0129\13\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)"+
		"\7)\u013d\n)\f)\16)\u0140\13)\3)\3)\3)\3)\3)\3*\3*\3*\3*\7*\u014b\n*\f"+
		"*\16*\u014e\13*\3*\3*\3+\3+\3+\3+\3+\7+\u0157\n+\f+\16+\u015a\13+\3,\3"+
		",\7,\u015e\n,\f,\16,\u0161\13,\3\u013e\2-\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\21#\22%\23\'\24)\25+\26"+
		"-\27/\30\61\31\63\32\65\2\67\29\2;\33=\2?\2A\2C\2E\2G\2I\2K\2M\2O\34Q"+
		"\35S\36U\37W \3\2\13\5\2\62;CHch\6\2\f\f\17\17$$^^\4\2--//\6\2HHNNhhn"+
		"n\5\2C\\aac|\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0177"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2;\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2"+
		"\2W\3\2\2\2\3Y\3\2\2\2\5\\\3\2\2\2\7^\3\2\2\2\t`\3\2\2\2\13b\3\2\2\2\r"+
		"d\3\2\2\2\17f\3\2\2\2\21h\3\2\2\2\23j\3\2\2\2\25l\3\2\2\2\27n\3\2\2\2"+
		"\31r\3\2\2\2\33t\3\2\2\2\35\u0082\3\2\2\2\37\u008e\3\2\2\2!\u0090\3\2"+
		"\2\2#\u009a\3\2\2\2%\u00a0\3\2\2\2\'\u00ac\3\2\2\2)\u00b7\3\2\2\2+\u00be"+
		"\3\2\2\2-\u00c0\3\2\2\2/\u00c8\3\2\2\2\61\u00ce\3\2\2\2\63\u00d3\3\2\2"+
		"\2\65\u00de\3\2\2\2\67\u00e0\3\2\2\29\u00f8\3\2\2\2;\u0106\3\2\2\2=\u0110"+
		"\3\2\2\2?\u011c\3\2\2\2A\u011e\3\2\2\2C\u0120\3\2\2\2E\u012a\3\2\2\2G"+
		"\u012c\3\2\2\2I\u012e\3\2\2\2K\u0130\3\2\2\2M\u0132\3\2\2\2O\u0134\3\2"+
		"\2\2Q\u0138\3\2\2\2S\u0146\3\2\2\2U\u0151\3\2\2\2W\u015b\3\2\2\2YZ\7<"+
		"\2\2Z[\7<\2\2[\4\3\2\2\2\\]\7*\2\2]\6\3\2\2\2^_\7+\2\2_\b\3\2\2\2`a\7"+
		">\2\2a\n\3\2\2\2bc\7.\2\2c\f\3\2\2\2de\7@\2\2e\16\3\2\2\2fg\7=\2\2g\20"+
		"\3\2\2\2hi\7<\2\2i\22\3\2\2\2jk\7?\2\2k\24\3\2\2\2lm\7}\2\2m\26\3\2\2"+
		"\2no\7\177\2\2o\30\3\2\2\2ps\5\33\16\2qs\5\35\17\2rp\3\2\2\2rq\3\2\2\2"+
		"s\32\3\2\2\2t{\5M\'\2uw\7)\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xz\5K&\2y"+
		"v\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\34\3\2\2\2}{\3\2\2\2~\177\7\62"+
		"\2\2\177\u0083\7z\2\2\u0080\u0081\7\62\2\2\u0081\u0083\7Z\2\2\u0082~\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008b\5\37\20\2\u0085"+
		"\u0087\7)\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\5\37\20\2\u0089\u0086\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\36\3\2\2\2\u008d\u008b\3\2\2"+
		"\2\u008e\u008f\t\2\2\2\u008f \3\2\2\2\u0090\u0091\7p\2\2\u0091\u0092\7"+
		"c\2\2\u0092\u0093\7o\2\2\u0093\u0094\7g\2\2\u0094\u0095\7u\2\2\u0095\u0096"+
		"\7r\2\2\u0096\u0097\7c\2\2\u0097\u0098\7e\2\2\u0098\u0099\7g\2\2\u0099"+
		"\"\3\2\2\2\u009a\u009b\7e\2\2\u009b\u009c\7n\2\2\u009c\u009d\7c\2\2\u009d"+
		"\u009e\7u\2\2\u009e\u009f\7u\2\2\u009f$\3\2\2\2\u00a0\u00a1\7e\2\2\u00a1"+
		"\u00a2\7q\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7v\2\2"+
		"\u00a5\u00a6\7t\2\2\u00a6\u00a7\7w\2\2\u00a7\u00a8\7e\2\2\u00a8\u00a9"+
		"\7v\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7t\2\2\u00ab&\3\2\2\2\u00ac\u00ad"+
		"\7f\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7v\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7e\2\2\u00b3\u00b4\7v\2\2"+
		"\u00b4\u00b5\7q\2\2\u00b5\u00b6\7t\2\2\u00b6(\3\2\2\2\u00b7\u00b8\7u\2"+
		"\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc"+
		"\7k\2\2\u00bc\u00bd\7e\2\2\u00bd*\3\2\2\2\u00be\u00bf\7B\2\2\u00bf,\3"+
		"\2\2\2\u00c0\u00c5\5G$\2\u00c1\u00c4\5G$\2\u00c2\u00c4\5K&\2\u00c3\u00c1"+
		"\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6.\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7h\2\2\u00c9"+
		"\u00ca\7c\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7g\2\2"+
		"\u00cd\60\3\2\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7"+
		"w\2\2\u00d1\u00d2\7g\2\2\u00d2\62\3\2\2\2\u00d3\u00d7\7$\2\2\u00d4\u00d6"+
		"\5\65\33\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2"+
		"\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db"+
		"\7$\2\2\u00db\64\3\2\2\2\u00dc\u00df\n\3\2\2\u00dd\u00df\5\67\34\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\66\3\2\2\2\u00e0\u00e1\59\35"+
		"\2\u00e18\3\2\2\2\u00e2\u00e3\7^\2\2\u00e3\u00f9\7)\2\2\u00e4\u00e5\7"+
		"^\2\2\u00e5\u00f9\7$\2\2\u00e6\u00e7\7^\2\2\u00e7\u00f9\7A\2\2\u00e8\u00e9"+
		"\7^\2\2\u00e9\u00f9\7^\2\2\u00ea\u00eb\7^\2\2\u00eb\u00f9\7c\2\2\u00ec"+
		"\u00ed\7^\2\2\u00ed\u00f9\7d\2\2\u00ee\u00ef\7^\2\2\u00ef\u00f9\7h\2\2"+
		"\u00f0\u00f1\7^\2\2\u00f1\u00f9\7p\2\2\u00f2\u00f3\7^\2\2\u00f3\u00f9"+
		"\7t\2\2\u00f4\u00f5\7^\2\2\u00f5\u00f9\7v\2\2\u00f6\u00f7\7^\2\2\u00f7"+
		"\u00f9\7x\2\2\u00f8\u00e2\3\2\2\2\u00f8\u00e4\3\2\2\2\u00f8\u00e6\3\2"+
		"\2\2\u00f8\u00e8\3\2\2\2\u00f8\u00ea\3\2\2\2\u00f8\u00ec\3\2\2\2\u00f8"+
		"\u00ee\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f8\u00f2\3\2\2\2\u00f8\u00f4\3\2"+
		"\2\2\u00f8\u00f6\3\2\2\2\u00f9:\3\2\2\2\u00fa\u00fc\5=\37\2\u00fb\u00fd"+
		"\5? \2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u0100\5E#\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0107\3\2\2"+
		"\2\u0101\u0102\5C\"\2\u0102\u0104\5? \2\u0103\u0105\5E#\2\u0104\u0103"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u00fa\3\2\2\2\u0106"+
		"\u0101\3\2\2\2\u0107<\3\2\2\2\u0108\u010a\5C\"\2\u0109\u0108\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\60\2\2\u010c\u0111\5"+
		"C\"\2\u010d\u010e\5C\"\2\u010e\u010f\7\60\2\2\u010f\u0111\3\2\2\2\u0110"+
		"\u0109\3\2\2\2\u0110\u010d\3\2\2\2\u0111>\3\2\2\2\u0112\u0114\7g\2\2\u0113"+
		"\u0115\5A!\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2"+
		"\2\u0116\u011d\5C\"\2\u0117\u0119\7G\2\2\u0118\u011a\5A!\2\u0119\u0118"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\5C\"\2\u011c"+
		"\u0112\3\2\2\2\u011c\u0117\3\2\2\2\u011d@\3\2\2\2\u011e\u011f\t\4\2\2"+
		"\u011fB\3\2\2\2\u0120\u0127\5K&\2\u0121\u0123\7)\2\2\u0122\u0121\3\2\2"+
		"\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\5K&\2\u0125\u0122"+
		"\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128"+
		"D\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012b\t\5\2\2\u012bF\3\2\2\2\u012c"+
		"\u012d\5I%\2\u012dH\3\2\2\2\u012e\u012f\t\6\2\2\u012fJ\3\2\2\2\u0130\u0131"+
		"\t\7\2\2\u0131L\3\2\2\2\u0132\u0133\t\b\2\2\u0133N\3\2\2\2\u0134\u0135"+
		"\t\t\2\2\u0135\u0136\3\2\2\2\u0136\u0137\b(\2\2\u0137P\3\2\2\2\u0138\u0139"+
		"\7\61\2\2\u0139\u013a\7,\2\2\u013a\u013e\3\2\2\2\u013b\u013d\13\2\2\2"+
		"\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013f\3\2\2\2\u013e\u013c"+
		"\3\2\2\2\u013f\u0141\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0142\7,\2\2\u0142"+
		"\u0143\7\61\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b)\3\2\u0145R\3\2\2\2"+
		"\u0146\u0147\7\61\2\2\u0147\u0148\7\61\2\2\u0148\u014c\3\2\2\2\u0149\u014b"+
		"\n\n\2\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\b*"+
		"\3\2\u0150T\3\2\2\2\u0151\u0152\7\61\2\2\u0152\u0153\7\61\2\2\u0153\u0154"+
		"\7\61\2\2\u0154\u0158\3\2\2\2\u0155\u0157\n\n\2\2\u0156\u0155\3\2\2\2"+
		"\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159V\3"+
		"\2\2\2\u015a\u0158\3\2\2\2\u015b\u015f\7%\2\2\u015c\u015e\n\n\2\2\u015d"+
		"\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160X\3\2\2\2\u0161\u015f\3\2\2\2\35\2rv{\u0082\u0086\u008b\u00c3"+
		"\u00c5\u00d7\u00de\u00f8\u00fc\u00ff\u0104\u0106\u0109\u0110\u0114\u0119"+
		"\u011c\u0122\u0127\u013e\u014c\u0158\u015f\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}