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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OPEN_CURLY=9, 
		CLOSE_CURLY=10, Integerliteral=11, Decimalliteral=12, Hexadecimalliteral=13, 
		Namespace=14, Class=15, Constructor=16, Destructor=17, Static=18, Annotation=19, 
		Identifier=20, False=21, True=22, Stringliteral=23, Floatingliteral=24, 
		WS=25, BlockComment=26, LineComment=27, DocumentationBlock=28, LineDirective=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "OPEN_CURLY", 
		"CLOSE_CURLY", "Integerliteral", "Decimalliteral", "Hexadecimalliteral", 
		"HEXADECIMALDIGIT", "Namespace", "Class", "Constructor", "Destructor", 
		"Static", "Annotation", "Identifier", "False", "True", "Stringliteral", 
		"Schar", "Escapesequence", "Simpleescapesequence", "Floatingliteral", 
		"Fractionalconstant", "Exponentpart", "SIGN", "Digitsequence", "Floatingsuffix", 
		"Identifiernondigit", "NONDIGIT", "DIGIT", "NONZERODIGIT", "WS", "BlockComment", 
		"LineComment", "DocumentationBlock", "LineDirective"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'<'", "','", "'>'", "';'", "':'", "'='", "'{'", "'}'", 
		null, null, null, "'namespace'", "'class'", "'constructor'", "'destructor'", 
		"'static'", "'@'", null, "'false'", "'true'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "OPEN_CURLY", "CLOSE_CURLY", 
		"Integerliteral", "Decimalliteral", "Hexadecimalliteral", "Namespace", 
		"Class", "Constructor", "Destructor", "Static", "Annotation", "Identifier", 
		"False", "True", "Stringliteral", "Floatingliteral", "WS", "BlockComment", 
		"LineComment", "DocumentationBlock", "LineDirective"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u015d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\5\fn\n\f\3\r\3\r\5\rr\n\r\3\r\7\ru\n\r\f\r\16\r"+
		"x\13\r\3\16\3\16\3\16\3\16\5\16~\n\16\3\16\3\16\5\16\u0082\n\16\3\16\7"+
		"\16\u0085\n\16\f\16\16\16\u0088\13\16\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\26\7\26\u00bf\n\26\f\26\16\26\u00c2\13\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u00d1"+
		"\n\31\f\31\16\31\u00d4\13\31\3\31\3\31\3\32\3\32\5\32\u00da\n\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f4\n\34\3\35\3\35"+
		"\5\35\u00f8\n\35\3\35\5\35\u00fb\n\35\3\35\3\35\3\35\5\35\u0100\n\35\5"+
		"\35\u0102\n\35\3\36\5\36\u0105\n\36\3\36\3\36\3\36\3\36\3\36\5\36\u010c"+
		"\n\36\3\37\3\37\5\37\u0110\n\37\3\37\3\37\3\37\5\37\u0115\n\37\3\37\5"+
		"\37\u0118\n\37\3 \3 \3!\3!\5!\u011e\n!\3!\7!\u0121\n!\f!\16!\u0124\13"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u0138"+
		"\n(\f(\16(\u013b\13(\3(\3(\3(\3(\3(\3)\3)\3)\3)\7)\u0146\n)\f)\16)\u0149"+
		"\13)\3)\3)\3*\3*\3*\3*\3*\7*\u0152\n*\f*\16*\u0155\13*\3+\3+\7+\u0159"+
		"\n+\f+\16+\u015c\13+\3\u0139\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\2\37\20!\21#\22%\23\'\24)\25+\26-\27/\30"+
		"\61\31\63\2\65\2\67\29\32;\2=\2?\2A\2C\2E\2G\2I\2K\2M\33O\34Q\35S\36U"+
		"\37\3\2\13\5\2\62;CHch\6\2\f\f\17\17$$^^\4\2--//\6\2HHNNhhnn\5\2C\\aa"+
		"c|\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0172\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\29\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5"+
		"Y\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21"+
		"e\3\2\2\2\23g\3\2\2\2\25i\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33}\3\2\2\2"+
		"\35\u0089\3\2\2\2\37\u008b\3\2\2\2!\u0095\3\2\2\2#\u009b\3\2\2\2%\u00a7"+
		"\3\2\2\2\'\u00b2\3\2\2\2)\u00b9\3\2\2\2+\u00bb\3\2\2\2-\u00c3\3\2\2\2"+
		"/\u00c9\3\2\2\2\61\u00ce\3\2\2\2\63\u00d9\3\2\2\2\65\u00db\3\2\2\2\67"+
		"\u00f3\3\2\2\29\u0101\3\2\2\2;\u010b\3\2\2\2=\u0117\3\2\2\2?\u0119\3\2"+
		"\2\2A\u011b\3\2\2\2C\u0125\3\2\2\2E\u0127\3\2\2\2G\u0129\3\2\2\2I\u012b"+
		"\3\2\2\2K\u012d\3\2\2\2M\u012f\3\2\2\2O\u0133\3\2\2\2Q\u0141\3\2\2\2S"+
		"\u014c\3\2\2\2U\u0156\3\2\2\2WX\7*\2\2X\4\3\2\2\2YZ\7+\2\2Z\6\3\2\2\2"+
		"[\\\7>\2\2\\\b\3\2\2\2]^\7.\2\2^\n\3\2\2\2_`\7@\2\2`\f\3\2\2\2ab\7=\2"+
		"\2b\16\3\2\2\2cd\7<\2\2d\20\3\2\2\2ef\7?\2\2f\22\3\2\2\2gh\7}\2\2h\24"+
		"\3\2\2\2ij\7\177\2\2j\26\3\2\2\2kn\5\31\r\2ln\5\33\16\2mk\3\2\2\2ml\3"+
		"\2\2\2n\30\3\2\2\2ov\5K&\2pr\7)\2\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2su\5"+
		"I%\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\32\3\2\2\2xv\3\2\2\2yz\7"+
		"\62\2\2z~\7z\2\2{|\7\62\2\2|~\7Z\2\2}y\3\2\2\2}{\3\2\2\2~\177\3\2\2\2"+
		"\177\u0086\5\35\17\2\u0080\u0082\7)\2\2\u0081\u0080\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\5\35\17\2\u0084\u0081\3\2\2\2"+
		"\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\34"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\t\2\2\2\u008a\36\3\2\2\2\u008b"+
		"\u008c\7p\2\2\u008c\u008d\7c\2\2\u008d\u008e\7o\2\2\u008e\u008f\7g\2\2"+
		"\u008f\u0090\7u\2\2\u0090\u0091\7r\2\2\u0091\u0092\7c\2\2\u0092\u0093"+
		"\7e\2\2\u0093\u0094\7g\2\2\u0094 \3\2\2\2\u0095\u0096\7e\2\2\u0096\u0097"+
		"\7n\2\2\u0097\u0098\7c\2\2\u0098\u0099\7u\2\2\u0099\u009a\7u\2\2\u009a"+
		"\"\3\2\2\2\u009b\u009c\7e\2\2\u009c\u009d\7q\2\2\u009d\u009e\7p\2\2\u009e"+
		"\u009f\7u\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7w\2\2"+
		"\u00a2\u00a3\7e\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6"+
		"\7t\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa"+
		"\7u\2\2\u00aa\u00ab\7v\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7w\2\2\u00ad"+
		"\u00ae\7e\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7t\2\2"+
		"\u00b1&\3\2\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7c\2"+
		"\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7e\2\2\u00b8(\3\2"+
		"\2\2\u00b9\u00ba\7B\2\2\u00ba*\3\2\2\2\u00bb\u00c0\5E#\2\u00bc\u00bf\5"+
		"E#\2\u00bd\u00bf\5I%\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1,\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7h\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7n\2"+
		"\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7g\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7"+
		"v\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7w\2\2\u00cc\u00cd\7g\2\2\u00cd\60"+
		"\3\2\2\2\u00ce\u00d2\7$\2\2\u00cf\u00d1\5\63\32\2\u00d0\u00cf\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6\62\3\2\2\2\u00d7"+
		"\u00da\n\3\2\2\u00d8\u00da\5\65\33\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00da\64\3\2\2\2\u00db\u00dc\5\67\34\2\u00dc\66\3\2\2\2\u00dd\u00de"+
		"\7^\2\2\u00de\u00f4\7)\2\2\u00df\u00e0\7^\2\2\u00e0\u00f4\7$\2\2\u00e1"+
		"\u00e2\7^\2\2\u00e2\u00f4\7A\2\2\u00e3\u00e4\7^\2\2\u00e4\u00f4\7^\2\2"+
		"\u00e5\u00e6\7^\2\2\u00e6\u00f4\7c\2\2\u00e7\u00e8\7^\2\2\u00e8\u00f4"+
		"\7d\2\2\u00e9\u00ea\7^\2\2\u00ea\u00f4\7h\2\2\u00eb\u00ec\7^\2\2\u00ec"+
		"\u00f4\7p\2\2\u00ed\u00ee\7^\2\2\u00ee\u00f4\7t\2\2\u00ef\u00f0\7^\2\2"+
		"\u00f0\u00f4\7v\2\2\u00f1\u00f2\7^\2\2\u00f2\u00f4\7x\2\2\u00f3\u00dd"+
		"\3\2\2\2\u00f3\u00df\3\2\2\2\u00f3\u00e1\3\2\2\2\u00f3\u00e3\3\2\2\2\u00f3"+
		"\u00e5\3\2\2\2\u00f3\u00e7\3\2\2\2\u00f3\u00e9\3\2\2\2\u00f3\u00eb\3\2"+
		"\2\2\u00f3\u00ed\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"8\3\2\2\2\u00f5\u00f7\5;\36\2\u00f6\u00f8\5=\37\2\u00f7\u00f6\3\2\2\2"+
		"\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00fb\5C\"\2\u00fa\u00f9"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u0102\3\2\2\2\u00fc\u00fd\5A!\2\u00fd"+
		"\u00ff\5=\37\2\u00fe\u0100\5C\"\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0102\3\2\2\2\u0101\u00f5\3\2\2\2\u0101\u00fc\3\2\2\2\u0102"+
		":\3\2\2\2\u0103\u0105\5A!\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\7\60\2\2\u0107\u010c\5A!\2\u0108\u0109\5A!"+
		"\2\u0109\u010a\7\60\2\2\u010a\u010c\3\2\2\2\u010b\u0104\3\2\2\2\u010b"+
		"\u0108\3\2\2\2\u010c<\3\2\2\2\u010d\u010f\7g\2\2\u010e\u0110\5? \2\u010f"+
		"\u010e\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0118\5A"+
		"!\2\u0112\u0114\7G\2\2\u0113\u0115\5? \2\u0114\u0113\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\5A!\2\u0117\u010d\3\2\2\2\u0117"+
		"\u0112\3\2\2\2\u0118>\3\2\2\2\u0119\u011a\t\4\2\2\u011a@\3\2\2\2\u011b"+
		"\u0122\5I%\2\u011c\u011e\7)\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2"+
		"\2\u011e\u011f\3\2\2\2\u011f\u0121\5I%\2\u0120\u011d\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123B\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u0126\t\5\2\2\u0126D\3\2\2\2\u0127\u0128\5G$\2\u0128"+
		"F\3\2\2\2\u0129\u012a\t\6\2\2\u012aH\3\2\2\2\u012b\u012c\t\7\2\2\u012c"+
		"J\3\2\2\2\u012d\u012e\t\b\2\2\u012eL\3\2\2\2\u012f\u0130\t\t\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\b\'\2\2\u0132N\3\2\2\2\u0133\u0134\7\61\2\2"+
		"\u0134\u0135\7,\2\2\u0135\u0139\3\2\2\2\u0136\u0138\13\2\2\2\u0137\u0136"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\61"+
		"\2\2\u013e\u013f\3\2\2\2\u013f\u0140\b(\3\2\u0140P\3\2\2\2\u0141\u0142"+
		"\7\61\2\2\u0142\u0143\7\61\2\2\u0143\u0147\3\2\2\2\u0144\u0146\n\n\2\2"+
		"\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\b)\3\2\u014b"+
		"R\3\2\2\2\u014c\u014d\7\61\2\2\u014d\u014e\7\61\2\2\u014e\u014f\7\61\2"+
		"\2\u014f\u0153\3\2\2\2\u0150\u0152\n\n\2\2\u0151\u0150\3\2\2\2\u0152\u0155"+
		"\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154T\3\2\2\2\u0155"+
		"\u0153\3\2\2\2\u0156\u015a\7%\2\2\u0157\u0159\n\n\2\2\u0158\u0157\3\2"+
		"\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"V\3\2\2\2\u015c\u015a\3\2\2\2\35\2mqv}\u0081\u0086\u00be\u00c0\u00d2\u00d9"+
		"\u00f3\u00f7\u00fa\u00ff\u0101\u0104\u010b\u010f\u0114\u0117\u011d\u0122"+
		"\u0139\u0147\u0153\u015a\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}