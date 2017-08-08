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
public class IDLParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Integerliteral=1, Decimalliteral=2, Hexadecimalliteral=3, Booleanliteral=4, 
		Namespace=5, Class=6, Constructor=7, Destructor=8, Annotation=9, Identifier=10, 
		False=11, True=12, Stringliteral=13, Floatingliteral=14, CONSTRUCTOR=15, 
		DESTRUCTOR=16, OPEN_PARENS=17, CLOSE_PARENS=18, LCURLY=19, RCURLY=20, 
		LTEMPLATE=21, RTEMPLATE=22, COMMA=23, SEMICOLON=24, EQUAL=25, COLON=26, 
		WS=27, BlockComment=28, LineComment=29, DocumentationBlock=30, LineDirective=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Integerliteral", "Decimalliteral", "Hexadecimalliteral", "HEXADECIMALDIGIT", 
		"Booleanliteral", "Namespace", "Class", "Constructor", "Destructor", "Annotation", 
		"Identifier", "False", "True", "Stringliteral", "Schar", "Escapesequence", 
		"Simpleescapesequence", "Floatingliteral", "Fractionalconstant", "Exponentpart", 
		"SIGN", "Digitsequence", "Floatingsuffix", "Identifiernondigit", "NONDIGIT", 
		"DIGIT", "NONZERODIGIT", "CONSTRUCTOR", "DESTRUCTOR", "OPEN_PARENS", "CLOSE_PARENS", 
		"LCURLY", "RCURLY", "LTEMPLATE", "RTEMPLATE", "COMMA", "SEMICOLON", "EQUAL", 
		"COLON", "WS", "BlockComment", "LineComment", "DocumentationBlock", "LineDirective"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'namespace'", "'class'", null, null, "'@'", 
		null, "'false'", "'true'", null, null, null, null, "'('", "')'", "'{'", 
		"'}'", "'<'", "'>'", "','", "';'", "'='", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Integerliteral", "Decimalliteral", "Hexadecimalliteral", "Booleanliteral", 
		"Namespace", "Class", "Constructor", "Destructor", "Annotation", "Identifier", 
		"False", "True", "Stringliteral", "Floatingliteral", "CONSTRUCTOR", "DESTRUCTOR", 
		"OPEN_PARENS", "CLOSE_PARENS", "LCURLY", "RCURLY", "LTEMPLATE", "RTEMPLATE", 
		"COMMA", "SEMICOLON", "EQUAL", "COLON", "WS", "BlockComment", "LineComment", 
		"DocumentationBlock", "LineDirective"
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


	public IDLParserLexer(CharStream input) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0175\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\5\2^\n\2\3\3\3\3\5\3b\n\3\3\3\7\3e\n\3\f\3\16\3h\13"+
		"\3\3\4\3\4\3\4\3\4\5\4n\n\4\3\4\3\4\5\4r\n\4\3\4\7\4u\n\4\f\4\16\4x\13"+
		"\4\3\5\3\5\3\6\3\6\5\6~\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\7\f"+
		"\u00ac\n\f\f\f\16\f\u00af\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\7\17\u00be\n\17\f\17\16\17\u00c1\13\17\3\17\3\17"+
		"\3\20\3\20\5\20\u00c7\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00e1\n\22\3\23\3\23\5\23\u00e5\n\23\3\23\5\23\u00e8\n\23\3"+
		"\23\3\23\3\23\5\23\u00ed\n\23\5\23\u00ef\n\23\3\24\5\24\u00f2\n\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00f9\n\24\3\25\3\25\5\25\u00fd\n\25\3\25\3"+
		"\25\3\25\5\25\u0102\n\25\3\25\5\25\u0105\n\25\3\26\3\26\3\27\3\27\5\27"+
		"\u010b\n\27\3\27\7\27\u010e\n\27\f\27\16\27\u0111\13\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\7*\u0150\n*\f*\16*\u0153\13*\3*\3*\3"+
		"*\3*\3*\3+\3+\3+\3+\7+\u015e\n+\f+\16+\u0161\13+\3+\3+\3,\3,\3,\3,\3,"+
		"\7,\u016a\n,\f,\16,\u016d\13,\3-\3-\7-\u0171\n-\f-\16-\u0174\13-\3\u0151"+
		"\2.\3\3\5\4\7\5\t\2\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17"+
		"\37\2!\2#\2%\20\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\21;\22=\23?\24A\25"+
		"C\26E\27G\30I\31K\32M\33O\34Q\35S\36U\37W Y!\3\2\13\5\2\62;CHch\6\2\f"+
		"\f\17\17$$^^\4\2--//\6\2HHNNhhnn\5\2C\\aac|\3\2\62;\3\2\63;\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\2\u018b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2%\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3]\3\2\2\2\5_\3\2\2\2\7m\3"+
		"\2\2\2\ty\3\2\2\2\13}\3\2\2\2\r\177\3\2\2\2\17\u0089\3\2\2\2\21\u008f"+
		"\3\2\2\2\23\u009b\3\2\2\2\25\u00a6\3\2\2\2\27\u00a8\3\2\2\2\31\u00b0\3"+
		"\2\2\2\33\u00b6\3\2\2\2\35\u00bb\3\2\2\2\37\u00c6\3\2\2\2!\u00c8\3\2\2"+
		"\2#\u00e0\3\2\2\2%\u00ee\3\2\2\2\'\u00f8\3\2\2\2)\u0104\3\2\2\2+\u0106"+
		"\3\2\2\2-\u0108\3\2\2\2/\u0112\3\2\2\2\61\u0114\3\2\2\2\63\u0116\3\2\2"+
		"\2\65\u0118\3\2\2\2\67\u011a\3\2\2\29\u011c\3\2\2\2;\u0128\3\2\2\2=\u0133"+
		"\3\2\2\2?\u0135\3\2\2\2A\u0137\3\2\2\2C\u0139\3\2\2\2E\u013b\3\2\2\2G"+
		"\u013d\3\2\2\2I\u013f\3\2\2\2K\u0141\3\2\2\2M\u0143\3\2\2\2O\u0145\3\2"+
		"\2\2Q\u0147\3\2\2\2S\u014b\3\2\2\2U\u0159\3\2\2\2W\u0164\3\2\2\2Y\u016e"+
		"\3\2\2\2[^\5\5\3\2\\^\5\7\4\2][\3\2\2\2]\\\3\2\2\2^\4\3\2\2\2_f\5\67\34"+
		"\2`b\7)\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2ce\5\65\33\2da\3\2\2\2eh\3\2"+
		"\2\2fd\3\2\2\2fg\3\2\2\2g\6\3\2\2\2hf\3\2\2\2ij\7\62\2\2jn\7z\2\2kl\7"+
		"\62\2\2ln\7Z\2\2mi\3\2\2\2mk\3\2\2\2no\3\2\2\2ov\5\t\5\2pr\7)\2\2qp\3"+
		"\2\2\2qr\3\2\2\2rs\3\2\2\2su\5\t\5\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3"+
		"\2\2\2w\b\3\2\2\2xv\3\2\2\2yz\t\2\2\2z\n\3\2\2\2{~\5\31\r\2|~\5\33\16"+
		"\2}{\3\2\2\2}|\3\2\2\2~\f\3\2\2\2\177\u0080\7p\2\2\u0080\u0081\7c\2\2"+
		"\u0081\u0082\7o\2\2\u0082\u0083\7g\2\2\u0083\u0084\7u\2\2\u0084\u0085"+
		"\7r\2\2\u0085\u0086\7c\2\2\u0086\u0087\7e\2\2\u0087\u0088\7g\2\2\u0088"+
		"\16\3\2\2\2\u0089\u008a\7e\2\2\u008a\u008b\7n\2\2\u008b\u008c\7c\2\2\u008c"+
		"\u008d\7u\2\2\u008d\u008e\7u\2\2\u008e\20\3\2\2\2\u008f\u0090\7e\2\2\u0090"+
		"\u0091\7q\2\2\u0091\u0092\7p\2\2\u0092\u0093\7u\2\2\u0093\u0094\7v\2\2"+
		"\u0094\u0095\7t\2\2\u0095\u0096\7w\2\2\u0096\u0097\7e\2\2\u0097\u0098"+
		"\7v\2\2\u0098\u0099\7q\2\2\u0099\u009a\7t\2\2\u009a\22\3\2\2\2\u009b\u009c"+
		"\7f\2\2\u009c\u009d\7g\2\2\u009d\u009e\7u\2\2\u009e\u009f\7v\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\u00a1\7w\2\2\u00a1\u00a2\7e\2\2\u00a2\u00a3\7v\2\2"+
		"\u00a3\u00a4\7q\2\2\u00a4\u00a5\7t\2\2\u00a5\24\3\2\2\2\u00a6\u00a7\7"+
		"B\2\2\u00a7\26\3\2\2\2\u00a8\u00ad\5\61\31\2\u00a9\u00ac\5\61\31\2\u00aa"+
		"\u00ac\5\65\33\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3"+
		"\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\30\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7n\2"+
		"\2\u00b3\u00b4\7u\2\2\u00b4\u00b5\7g\2\2\u00b5\32\3\2\2\2\u00b6\u00b7"+
		"\7v\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\34\3\2\2\2\u00bb\u00bf\7$\2\2\u00bc\u00be\5\37\20\2\u00bd\u00bc\3\2\2"+
		"\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7$\2\2\u00c3\36\3\2\2\2\u00c4"+
		"\u00c7\n\3\2\2\u00c5\u00c7\5!\21\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2"+
		"\2\2\u00c7 \3\2\2\2\u00c8\u00c9\5#\22\2\u00c9\"\3\2\2\2\u00ca\u00cb\7"+
		"^\2\2\u00cb\u00e1\7)\2\2\u00cc\u00cd\7^\2\2\u00cd\u00e1\7$\2\2\u00ce\u00cf"+
		"\7^\2\2\u00cf\u00e1\7A\2\2\u00d0\u00d1\7^\2\2\u00d1\u00e1\7^\2\2\u00d2"+
		"\u00d3\7^\2\2\u00d3\u00e1\7c\2\2\u00d4\u00d5\7^\2\2\u00d5\u00e1\7d\2\2"+
		"\u00d6\u00d7\7^\2\2\u00d7\u00e1\7h\2\2\u00d8\u00d9\7^\2\2\u00d9\u00e1"+
		"\7p\2\2\u00da\u00db\7^\2\2\u00db\u00e1\7t\2\2\u00dc\u00dd\7^\2\2\u00dd"+
		"\u00e1\7v\2\2\u00de\u00df\7^\2\2\u00df\u00e1\7x\2\2\u00e0\u00ca\3\2\2"+
		"\2\u00e0\u00cc\3\2\2\2\u00e0\u00ce\3\2\2\2\u00e0\u00d0\3\2\2\2\u00e0\u00d2"+
		"\3\2\2\2\u00e0\u00d4\3\2\2\2\u00e0\u00d6\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0"+
		"\u00da\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1$\3\2\2\2"+
		"\u00e2\u00e4\5\'\24\2\u00e3\u00e5\5)\25\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e8\5/\30\2\u00e7\u00e6\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00ef\3\2\2\2\u00e9\u00ea\5-\27\2\u00ea\u00ec\5)"+
		"\25\2\u00eb\u00ed\5/\30\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00e2\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ef&\3\2\2\2"+
		"\u00f0\u00f2\5-\27\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3"+
		"\3\2\2\2\u00f3\u00f4\7\60\2\2\u00f4\u00f9\5-\27\2\u00f5\u00f6\5-\27\2"+
		"\u00f6\u00f7\7\60\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f1\3\2\2\2\u00f8\u00f5"+
		"\3\2\2\2\u00f9(\3\2\2\2\u00fa\u00fc\7g\2\2\u00fb\u00fd\5+\26\2\u00fc\u00fb"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0105\5-\27\2\u00ff"+
		"\u0101\7G\2\2\u0100\u0102\5+\26\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0105\5-\27\2\u0104\u00fa\3\2\2\2\u0104"+
		"\u00ff\3\2\2\2\u0105*\3\2\2\2\u0106\u0107\t\4\2\2\u0107,\3\2\2\2\u0108"+
		"\u010f\5\65\33\2\u0109\u010b\7)\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3"+
		"\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e\5\65\33\2\u010d\u010a\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110.\3\2\2\2"+
		"\u0111\u010f\3\2\2\2\u0112\u0113\t\5\2\2\u0113\60\3\2\2\2\u0114\u0115"+
		"\5\63\32\2\u0115\62\3\2\2\2\u0116\u0117\t\6\2\2\u0117\64\3\2\2\2\u0118"+
		"\u0119\t\7\2\2\u0119\66\3\2\2\2\u011a\u011b\t\b\2\2\u011b8\3\2\2\2\u011c"+
		"\u011d\7e\2\2\u011d\u011e\7q\2\2\u011e\u011f\7p\2\2\u011f\u0120\7u\2\2"+
		"\u0120\u0121\7v\2\2\u0121\u0122\7t\2\2\u0122\u0123\7w\2\2\u0123\u0124"+
		"\7e\2\2\u0124\u0125\7v\2\2\u0125\u0126\7q\2\2\u0126\u0127\7t\2\2\u0127"+
		":\3\2\2\2\u0128\u0129\7f\2\2\u0129\u012a\7g\2\2\u012a\u012b\7u\2\2\u012b"+
		"\u012c\7v\2\2\u012c\u012d\7t\2\2\u012d\u012e\7w\2\2\u012e\u012f\7e\2\2"+
		"\u012f\u0130\7v\2\2\u0130\u0131\7q\2\2\u0131\u0132\7t\2\2\u0132<\3\2\2"+
		"\2\u0133\u0134\7*\2\2\u0134>\3\2\2\2\u0135\u0136\7+\2\2\u0136@\3\2\2\2"+
		"\u0137\u0138\7}\2\2\u0138B\3\2\2\2\u0139\u013a\7\177\2\2\u013aD\3\2\2"+
		"\2\u013b\u013c\7>\2\2\u013cF\3\2\2\2\u013d\u013e\7@\2\2\u013eH\3\2\2\2"+
		"\u013f\u0140\7.\2\2\u0140J\3\2\2\2\u0141\u0142\7=\2\2\u0142L\3\2\2\2\u0143"+
		"\u0144\7?\2\2\u0144N\3\2\2\2\u0145\u0146\7<\2\2\u0146P\3\2\2\2\u0147\u0148"+
		"\t\t\2\2\u0148\u0149\3\2\2\2\u0149\u014a\b)\2\2\u014aR\3\2\2\2\u014b\u014c"+
		"\7\61\2\2\u014c\u014d\7,\2\2\u014d\u0151\3\2\2\2\u014e\u0150\13\2\2\2"+
		"\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u0152\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7,\2\2\u0155"+
		"\u0156\7\61\2\2\u0156\u0157\3\2\2\2\u0157\u0158\b*\3\2\u0158T\3\2\2\2"+
		"\u0159\u015a\7\61\2\2\u015a\u015b\7\61\2\2\u015b\u015f\3\2\2\2\u015c\u015e"+
		"\n\n\2\2\u015d\u015c\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\b+"+
		"\3\2\u0163V\3\2\2\2\u0164\u0165\7\61\2\2\u0165\u0166\7\61\2\2\u0166\u0167"+
		"\7\61\2\2\u0167\u016b\3\2\2\2\u0168\u016a\n\n\2\2\u0169\u0168\3\2\2\2"+
		"\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016cX\3"+
		"\2\2\2\u016d\u016b\3\2\2\2\u016e\u0172\7%\2\2\u016f\u0171\n\n\2\2\u0170"+
		"\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173Z\3\2\2\2\u0174\u0172\3\2\2\2\36\2]afmqv}\u00ab\u00ad\u00bf"+
		"\u00c6\u00e0\u00e4\u00e7\u00ec\u00ee\u00f1\u00f8\u00fc\u0101\u0104\u010a"+
		"\u010f\u0151\u015f\u016b\u0172\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}