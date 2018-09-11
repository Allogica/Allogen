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
		Namespace=15, Class=16, Extends=17, Abstract=18, Constructor=19, Destructor=20, 
		Static=21, Annotation=22, Identifier=23, False=24, True=25, Stringliteral=26, 
		Floatingliteral=27, WS=28, BlockComment=29, LineComment=30, DocumentationBlock=31, 
		LineDirective=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"OPEN_CURLY", "CLOSE_CURLY", "Integerliteral", "Decimalliteral", "Hexadecimalliteral", 
		"HEXADECIMALDIGIT", "Namespace", "Class", "Extends", "Abstract", "Constructor", 
		"Destructor", "Static", "Annotation", "Identifier", "False", "True", "Stringliteral", 
		"Schar", "Escapesequence", "Simpleescapesequence", "Floatingliteral", 
		"Fractionalconstant", "Exponentpart", "SIGN", "Digitsequence", "Floatingsuffix", 
		"Identifiernondigit", "NONDIGIT", "DIGIT", "NONZERODIGIT", "WS", "BlockComment", 
		"LineComment", "DocumentationBlock", "LineDirective"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'::'", "'('", "')'", "'<'", "','", "'>'", "';'", "':'", "'='", 
		"'{'", "'}'", null, null, null, "'namespace'", "'class'", "'extends'", 
		"'abstract'", "'constructor'", "'destructor'", "'static'", "'@'", null, 
		"'false'", "'true'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "OPEN_CURLY", 
		"CLOSE_CURLY", "Integerliteral", "Decimalliteral", "Hexadecimalliteral", 
		"Namespace", "Class", "Extends", "Abstract", "Constructor", "Destructor", 
		"Static", "Annotation", "Identifier", "False", "True", "Stringliteral", 
		"Floatingliteral", "WS", "BlockComment", "LineComment", "DocumentationBlock", 
		"LineDirective"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u0177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\rw\n\r\3\16\3\16\5"+
		"\16{\n\16\3\16\7\16~\n\16\f\16\16\16\u0081\13\16\3\17\3\17\3\17\3\17\5"+
		"\17\u0087\n\17\3\17\3\17\5\17\u008b\n\17\3\17\7\17\u008e\n\17\f\17\16"+
		"\17\u0091\13\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\31\7\31\u00d9\n\31\f\31\16\31\u00dc\13\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\7\34\u00eb\n\34\f\34"+
		"\16\34\u00ee\13\34\3\34\3\34\3\35\3\35\5\35\u00f4\n\35\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u010e\n\37\3 \3 \5 \u0112\n "+
		"\3 \5 \u0115\n \3 \3 \3 \5 \u011a\n \5 \u011c\n \3!\5!\u011f\n!\3!\3!"+
		"\3!\3!\3!\5!\u0126\n!\3\"\3\"\5\"\u012a\n\"\3\"\3\"\3\"\5\"\u012f\n\""+
		"\3\"\5\"\u0132\n\"\3#\3#\3$\3$\5$\u0138\n$\3$\7$\u013b\n$\f$\16$\u013e"+
		"\13$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\7+\u0152"+
		"\n+\f+\16+\u0155\13+\3+\3+\3+\3+\3+\3,\3,\3,\3,\7,\u0160\n,\f,\16,\u0163"+
		"\13,\3,\3,\3-\3-\3-\3-\3-\7-\u016c\n-\f-\16-\u016f\13-\3.\3.\7.\u0173"+
		"\n.\f.\16.\u0176\13.\3\u0153\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\2!\21#\22%\23\'\24)\25+\26-\27/\30"+
		"\61\31\63\32\65\33\67\349\2;\2=\2?\35A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\36U"+
		"\37W Y![\"\3\2\13\5\2\62;CHch\6\2\f\f\17\17$$^^\4\2--//\6\2HHNNhhnn\5"+
		"\2C\\aac|\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u018c\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2?\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2"+
		"\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\3]\3\2\2\2\5`\3\2\2\2\7b\3\2\2\2\td"+
		"\3\2\2\2\13f\3\2\2\2\rh\3\2\2\2\17j\3\2\2\2\21l\3\2\2\2\23n\3\2\2\2\25"+
		"p\3\2\2\2\27r\3\2\2\2\31v\3\2\2\2\33x\3\2\2\2\35\u0086\3\2\2\2\37\u0092"+
		"\3\2\2\2!\u0094\3\2\2\2#\u009e\3\2\2\2%\u00a4\3\2\2\2\'\u00ac\3\2\2\2"+
		")\u00b5\3\2\2\2+\u00c1\3\2\2\2-\u00cc\3\2\2\2/\u00d3\3\2\2\2\61\u00d5"+
		"\3\2\2\2\63\u00dd\3\2\2\2\65\u00e3\3\2\2\2\67\u00e8\3\2\2\29\u00f3\3\2"+
		"\2\2;\u00f5\3\2\2\2=\u010d\3\2\2\2?\u011b\3\2\2\2A\u0125\3\2\2\2C\u0131"+
		"\3\2\2\2E\u0133\3\2\2\2G\u0135\3\2\2\2I\u013f\3\2\2\2K\u0141\3\2\2\2M"+
		"\u0143\3\2\2\2O\u0145\3\2\2\2Q\u0147\3\2\2\2S\u0149\3\2\2\2U\u014d\3\2"+
		"\2\2W\u015b\3\2\2\2Y\u0166\3\2\2\2[\u0170\3\2\2\2]^\7<\2\2^_\7<\2\2_\4"+
		"\3\2\2\2`a\7*\2\2a\6\3\2\2\2bc\7+\2\2c\b\3\2\2\2de\7>\2\2e\n\3\2\2\2f"+
		"g\7.\2\2g\f\3\2\2\2hi\7@\2\2i\16\3\2\2\2jk\7=\2\2k\20\3\2\2\2lm\7<\2\2"+
		"m\22\3\2\2\2no\7?\2\2o\24\3\2\2\2pq\7}\2\2q\26\3\2\2\2rs\7\177\2\2s\30"+
		"\3\2\2\2tw\5\33\16\2uw\5\35\17\2vt\3\2\2\2vu\3\2\2\2w\32\3\2\2\2x\177"+
		"\5Q)\2y{\7)\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|~\5O(\2}z\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\34\3\2\2\2\u0081\177\3\2"+
		"\2\2\u0082\u0083\7\62\2\2\u0083\u0087\7z\2\2\u0084\u0085\7\62\2\2\u0085"+
		"\u0087\7Z\2\2\u0086\u0082\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008f\5\37\20\2\u0089\u008b\7)\2\2\u008a\u0089\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\5\37\20\2\u008d\u008a\3"+
		"\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\36\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\t\2\2\2\u0093 \3\2\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7c\2\2\u0096\u0097\7o\2\2\u0097\u0098\7g\2\2"+
		"\u0098\u0099\7u\2\2\u0099\u009a\7r\2\2\u009a\u009b\7c\2\2\u009b\u009c"+
		"\7e\2\2\u009c\u009d\7g\2\2\u009d\"\3\2\2\2\u009e\u009f\7e\2\2\u009f\u00a0"+
		"\7n\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"$\3\2\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7z\2\2\u00a6\u00a7\7v\2\2\u00a7"+
		"\u00a8\7g\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7f\2\2\u00aa\u00ab\7u\2\2"+
		"\u00ab&\3\2\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7u\2"+
		"\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3"+
		"\7e\2\2\u00b3\u00b4\7v\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7"+
		"\7q\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7t\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be\7v\2\2"+
		"\u00be\u00bf\7q\2\2\u00bf\u00c0\7t\2\2\u00c0*\3\2\2\2\u00c1\u00c2\7f\2"+
		"\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\7u\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6"+
		"\7t\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9\7v\2\2\u00c9"+
		"\u00ca\7q\2\2\u00ca\u00cb\7t\2\2\u00cb,\3\2\2\2\u00cc\u00cd\7u\2\2\u00cd"+
		"\u00ce\7v\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7k\2\2"+
		"\u00d1\u00d2\7e\2\2\u00d2.\3\2\2\2\u00d3\u00d4\7B\2\2\u00d4\60\3\2\2\2"+
		"\u00d5\u00da\5K&\2\u00d6\u00d9\5K&\2\u00d7\u00d9\5O(\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\62\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7h\2\2"+
		"\u00de\u00df\7c\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2"+
		"\7g\2\2\u00e2\64\3\2\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6"+
		"\7w\2\2\u00e6\u00e7\7g\2\2\u00e7\66\3\2\2\2\u00e8\u00ec\7$\2\2\u00e9\u00eb"+
		"\59\35\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7$"+
		"\2\2\u00f08\3\2\2\2\u00f1\u00f4\n\3\2\2\u00f2\u00f4\5;\36\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4:\3\2\2\2\u00f5\u00f6\5=\37\2\u00f6"+
		"<\3\2\2\2\u00f7\u00f8\7^\2\2\u00f8\u010e\7)\2\2\u00f9\u00fa\7^\2\2\u00fa"+
		"\u010e\7$\2\2\u00fb\u00fc\7^\2\2\u00fc\u010e\7A\2\2\u00fd\u00fe\7^\2\2"+
		"\u00fe\u010e\7^\2\2\u00ff\u0100\7^\2\2\u0100\u010e\7c\2\2\u0101\u0102"+
		"\7^\2\2\u0102\u010e\7d\2\2\u0103\u0104\7^\2\2\u0104\u010e\7h\2\2\u0105"+
		"\u0106\7^\2\2\u0106\u010e\7p\2\2\u0107\u0108\7^\2\2\u0108\u010e\7t\2\2"+
		"\u0109\u010a\7^\2\2\u010a\u010e\7v\2\2\u010b\u010c\7^\2\2\u010c\u010e"+
		"\7x\2\2\u010d\u00f7\3\2\2\2\u010d\u00f9\3\2\2\2\u010d\u00fb\3\2\2\2\u010d"+
		"\u00fd\3\2\2\2\u010d\u00ff\3\2\2\2\u010d\u0101\3\2\2\2\u010d\u0103\3\2"+
		"\2\2\u010d\u0105\3\2\2\2\u010d\u0107\3\2\2\2\u010d\u0109\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010e>\3\2\2\2\u010f\u0111\5A!\2\u0110\u0112\5C\"\2\u0111"+
		"\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0115\5I"+
		"%\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u011c\3\2\2\2\u0116"+
		"\u0117\5G$\2\u0117\u0119\5C\"\2\u0118\u011a\5I%\2\u0119\u0118\3\2\2\2"+
		"\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u010f\3\2\2\2\u011b\u0116"+
		"\3\2\2\2\u011c@\3\2\2\2\u011d\u011f\5G$\2\u011e\u011d\3\2\2\2\u011e\u011f"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\7\60\2\2\u0121\u0126\5G$\2\u0122"+
		"\u0123\5G$\2\u0123\u0124\7\60\2\2\u0124\u0126\3\2\2\2\u0125\u011e\3\2"+
		"\2\2\u0125\u0122\3\2\2\2\u0126B\3\2\2\2\u0127\u0129\7g\2\2\u0128\u012a"+
		"\5E#\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u0132\5G$\2\u012c\u012e\7G\2\2\u012d\u012f\5E#\2\u012e\u012d\3\2\2\2"+
		"\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\5G$\2\u0131\u0127"+
		"\3\2\2\2\u0131\u012c\3\2\2\2\u0132D\3\2\2\2\u0133\u0134\t\4\2\2\u0134"+
		"F\3\2\2\2\u0135\u013c\5O(\2\u0136\u0138\7)\2\2\u0137\u0136\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\5O(\2\u013a\u0137\3\2\2"+
		"\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013dH"+
		"\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\t\5\2\2\u0140J\3\2\2\2\u0141"+
		"\u0142\5M\'\2\u0142L\3\2\2\2\u0143\u0144\t\6\2\2\u0144N\3\2\2\2\u0145"+
		"\u0146\t\7\2\2\u0146P\3\2\2\2\u0147\u0148\t\b\2\2\u0148R\3\2\2\2\u0149"+
		"\u014a\t\t\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b*\2\2\u014cT\3\2\2\2\u014d"+
		"\u014e\7\61\2\2\u014e\u014f\7,\2\2\u014f\u0153\3\2\2\2\u0150\u0152\13"+
		"\2\2\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0154\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7,"+
		"\2\2\u0157\u0158\7\61\2\2\u0158\u0159\3\2\2\2\u0159\u015a\b+\3\2\u015a"+
		"V\3\2\2\2\u015b\u015c\7\61\2\2\u015c\u015d\7\61\2\2\u015d\u0161\3\2\2"+
		"\2\u015e\u0160\n\n\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164"+
		"\u0165\b,\3\2\u0165X\3\2\2\2\u0166\u0167\7\61\2\2\u0167\u0168\7\61\2\2"+
		"\u0168\u0169\7\61\2\2\u0169\u016d\3\2\2\2\u016a\u016c\n\n\2\2\u016b\u016a"+
		"\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"Z\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0174\7%\2\2\u0171\u0173\n\n\2\2\u0172"+
		"\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u0175\\\3\2\2\2\u0176\u0174\3\2\2\2\35\2vz\177\u0086\u008a\u008f"+
		"\u00d8\u00da\u00ec\u00f3\u010d\u0111\u0114\u0119\u011b\u011e\u0125\u0129"+
		"\u012e\u0131\u0137\u013c\u0153\u0161\u016d\u0174\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}