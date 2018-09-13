// Generated from com\allogica\allogen\idl\grammar\IDL.g4 by ANTLR 4.7
package com.allogica.allogen.idl.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IDLParser extends Parser {
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
	public static final int
		RULE_sourcefile = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_regulartypename = 3, 
		RULE_lambdatype = 4, RULE_typename = 5, RULE_typenametemplateargs = 6, 
		RULE_namespacename = 7, RULE_namespacedefinition = 8, RULE_namespacebody = 9, 
		RULE_classname = 10, RULE_classdefinition = 11, RULE_classextends = 12, 
		RULE_classbody = 13, RULE_includedefinition = 14, RULE_constructordefinition = 15, 
		RULE_destructordefinition = 16, RULE_methodname = 17, RULE_methoddefinition = 18, 
		RULE_methodreturn = 19, RULE_methodarguments = 20, RULE_argumentname = 21, 
		RULE_argumenttype = 22, RULE_methodargument = 23, RULE_methodbody = 24, 
		RULE_block = 25, RULE_methodbodycontent = 26, RULE_annotationname = 27, 
		RULE_annotation = 28, RULE_annotationparamname = 29, RULE_annotationparamvalue = 30, 
		RULE_annotationbody = 31, RULE_literal = 32, RULE_booleanliteral = 33;
	public static final String[] ruleNames = {
		"sourcefile", "declarations", "declaration", "regulartypename", "lambdatype", 
		"typename", "typenametemplateargs", "namespacename", "namespacedefinition", 
		"namespacebody", "classname", "classdefinition", "classextends", "classbody", 
		"includedefinition", "constructordefinition", "destructordefinition", 
		"methodname", "methoddefinition", "methodreturn", "methodarguments", "argumentname", 
		"argumenttype", "methodargument", "methodbody", "block", "methodbodycontent", 
		"annotationname", "annotation", "annotationparamname", "annotationparamvalue", 
		"annotationbody", "literal", "booleanliteral"
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

	@Override
	public String getGrammarFileName() { return "IDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SourcefileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(IDLParser.EOF, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public SourcefileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourcefile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterSourcefile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitSourcefile(this);
		}
	}

	public final SourcefileContext sourcefile() throws RecognitionException {
		SourcefileContext _localctx = new SourcefileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sourcefile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Abstract) | (1L << Static) | (1L << Annotation) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(68);
				declarations();
				}
			}

			setState(71);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				declaration();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Abstract) | (1L << Static) | (1L << Annotation) | (1L << DocumentationBlock))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public NamespacedefinitionContext namespacedefinition() {
			return getRuleContext(NamespacedefinitionContext.class,0);
		}
		public ClassdefinitionContext classdefinition() {
			return getRuleContext(ClassdefinitionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Namespace:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				namespacedefinition();
				}
				break;
			case Class:
			case Abstract:
			case Static:
			case Annotation:
			case DocumentationBlock:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				classdefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegulartypenameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(IDLParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(IDLParser.Identifier, i);
		}
		public RegulartypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regulartypename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterRegulartypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitRegulartypename(this);
		}
	}

	public final RegulartypenameContext regulartypename() throws RecognitionException {
		RegulartypenameContext _localctx = new RegulartypenameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_regulartypename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(Identifier);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(83);
				match(T__0);
				setState(84);
				match(Identifier);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdatypeContext extends ParserRuleContext {
		public RegulartypenameContext regulartypename() {
			return getRuleContext(RegulartypenameContext.class,0);
		}
		public MethodargumentsContext methodarguments() {
			return getRuleContext(MethodargumentsContext.class,0);
		}
		public LambdatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterLambdatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitLambdatype(this);
		}
	}

	public final LambdatypeContext lambdatype() throws RecognitionException {
		LambdatypeContext _localctx = new LambdatypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lambdatype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			regulartypename();
			setState(91);
			match(T__1);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(92);
				methodarguments();
				}
			}

			setState(95);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenameContext extends ParserRuleContext {
		public RegulartypenameContext regulartypename() {
			return getRuleContext(RegulartypenameContext.class,0);
		}
		public LambdatypeContext lambdatype() {
			return getRuleContext(LambdatypeContext.class,0);
		}
		public TypenametemplateargsContext typenametemplateargs() {
			return getRuleContext(TypenametemplateargsContext.class,0);
		}
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterTypename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitTypename(this);
		}
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(97);
				regulartypename();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(98);
					typenametemplateargs();
					}
				}

				}
				break;
			case 2:
				{
				setState(101);
				lambdatype();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypenametemplateargsContext extends ParserRuleContext {
		public List<TypenameContext> typename() {
			return getRuleContexts(TypenameContext.class);
		}
		public TypenameContext typename(int i) {
			return getRuleContext(TypenameContext.class,i);
		}
		public TypenametemplateargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typenametemplateargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterTypenametemplateargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitTypenametemplateargs(this);
		}
	}

	public final TypenametemplateargsContext typenametemplateargs() throws RecognitionException {
		TypenametemplateargsContext _localctx = new TypenametemplateargsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typenametemplateargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(104);
			match(T__3);
			setState(105);
			typename();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(106);
				match(T__4);
				setState(107);
				typename();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(T__5);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacenameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public NamespacenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterNamespacename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitNamespacename(this);
		}
	}

	public final NamespacenameContext namespacename() throws RecognitionException {
		NamespacenameContext _localctx = new NamespacenameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_namespacename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacedefinitionContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(IDLParser.Namespace, 0); }
		public NamespacenameContext namespacename() {
			return getRuleContext(NamespacenameContext.class,0);
		}
		public NamespacebodyContext namespacebody() {
			return getRuleContext(NamespacebodyContext.class,0);
		}
		public NamespacedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterNamespacedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitNamespacedefinition(this);
		}
	}

	public final NamespacedefinitionContext namespacedefinition() throws RecognitionException {
		NamespacedefinitionContext _localctx = new NamespacedefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_namespacedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(Namespace);
			setState(118);
			namespacename();
			setState(119);
			match(OPEN_CURLY);
			setState(120);
			namespacebody();
			setState(121);
			match(CLOSE_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespacebodyContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public NamespacebodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespacebody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterNamespacebody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitNamespacebody(this);
		}
	}

	public final NamespacebodyContext namespacebody() throws RecognitionException {
		NamespacebodyContext _localctx = new NamespacebodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_namespacebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Abstract) | (1L << Static) | (1L << Annotation) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(123);
				declarations();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public ClassnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterClassname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitClassname(this);
		}
	}

	public final ClassnameContext classname() throws RecognitionException {
		ClassnameContext _localctx = new ClassnameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassdefinitionContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(IDLParser.Class, 0); }
		public ClassnameContext classname() {
			return getRuleContext(ClassnameContext.class,0);
		}
		public ClassbodyContext classbody() {
			return getRuleContext(ClassbodyContext.class,0);
		}
		public TerminalNode DocumentationBlock() { return getToken(IDLParser.DocumentationBlock, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ClassextendsContext classextends() {
			return getRuleContext(ClassextendsContext.class,0);
		}
		public TerminalNode Static() { return getToken(IDLParser.Static, 0); }
		public TerminalNode Abstract() { return getToken(IDLParser.Abstract, 0); }
		public ClassdefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterClassdefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitClassdefinition(this);
		}
	}

	public final ClassdefinitionContext classdefinition() throws RecognitionException {
		ClassdefinitionContext _localctx = new ClassdefinitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classdefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DocumentationBlock) {
				{
				setState(128);
				match(DocumentationBlock);
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(131);
				annotation();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract || _la==Static) {
				{
				setState(137);
				_la = _input.LA(1);
				if ( !(_la==Abstract || _la==Static) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(140);
			match(Class);
			setState(141);
			classname();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Extends) {
				{
				setState(142);
				classextends();
				}
			}

			setState(145);
			match(OPEN_CURLY);
			setState(146);
			classbody();
			setState(147);
			match(CLOSE_CURLY);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(148);
				match(T__6);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassextendsContext extends ParserRuleContext {
		public TerminalNode Extends() { return getToken(IDLParser.Extends, 0); }
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ClassextendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classextends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterClassextends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitClassextends(this);
		}
	}

	public final ClassextendsContext classextends() throws RecognitionException {
		ClassextendsContext _localctx = new ClassextendsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_classextends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(Extends);
			setState(152);
			typename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassbodyContext extends ParserRuleContext {
		public List<IncludedefinitionContext> includedefinition() {
			return getRuleContexts(IncludedefinitionContext.class);
		}
		public IncludedefinitionContext includedefinition(int i) {
			return getRuleContext(IncludedefinitionContext.class,i);
		}
		public List<ConstructordefinitionContext> constructordefinition() {
			return getRuleContexts(ConstructordefinitionContext.class);
		}
		public ConstructordefinitionContext constructordefinition(int i) {
			return getRuleContext(ConstructordefinitionContext.class,i);
		}
		public DestructordefinitionContext destructordefinition() {
			return getRuleContext(DestructordefinitionContext.class,0);
		}
		public List<MethoddefinitionContext> methoddefinition() {
			return getRuleContexts(MethoddefinitionContext.class);
		}
		public MethoddefinitionContext methoddefinition(int i) {
			return getRuleContext(MethoddefinitionContext.class,i);
		}
		public ClassbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterClassbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitClassbody(this);
		}
	}

	public final ClassbodyContext classbody() throws RecognitionException {
		ClassbodyContext _localctx = new ClassbodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classbody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LineDirective) {
				{
				{
				setState(154);
				includedefinition();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(160);
					constructordefinition();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(166);
				destructordefinition();
				}
				break;
			}
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Static) | (1L << Annotation) | (1L << Identifier))) != 0)) {
				{
				{
				setState(169);
				methoddefinition();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludedefinitionContext extends ParserRuleContext {
		public TerminalNode LineDirective() { return getToken(IDLParser.LineDirective, 0); }
		public IncludedefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includedefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterIncludedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitIncludedefinition(this);
		}
	}

	public final IncludedefinitionContext includedefinition() throws RecognitionException {
		IncludedefinitionContext _localctx = new IncludedefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_includedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(LineDirective);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructordefinitionContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodargumentsContext methodarguments() {
			return getRuleContext(MethodargumentsContext.class,0);
		}
		public MethodbodyContext methodbody() {
			return getRuleContext(MethodbodyContext.class,0);
		}
		public ConstructordefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructordefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterConstructordefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitConstructordefinition(this);
		}
	}

	public final ConstructordefinitionContext constructordefinition() throws RecognitionException {
		ConstructordefinitionContext _localctx = new ConstructordefinitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constructordefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(177);
				annotation();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(Constructor);
			setState(184);
			match(T__1);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(185);
				methodarguments();
				}
			}

			setState(188);
			match(T__2);
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(189);
				methodbody();
				}
				break;
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(192);
				match(T__6);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DestructordefinitionContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodbodyContext methodbody() {
			return getRuleContext(MethodbodyContext.class,0);
		}
		public DestructordefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructordefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterDestructordefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitDestructordefinition(this);
		}
	}

	public final DestructordefinitionContext destructordefinition() throws RecognitionException {
		DestructordefinitionContext _localctx = new DestructordefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_destructordefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(195);
				annotation();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(Destructor);
			setState(202);
			match(T__1);
			setState(203);
			match(T__2);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(204);
				methodbody();
				}
				break;
			}
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(207);
				match(T__6);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public MethodnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethodname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethodname(this);
		}
	}

	public final MethodnameContext methodname() throws RecognitionException {
		MethodnameContext _localctx = new MethodnameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethoddefinitionContext extends ParserRuleContext {
		public MethodreturnContext methodreturn() {
			return getRuleContext(MethodreturnContext.class,0);
		}
		public MethodnameContext methodname() {
			return getRuleContext(MethodnameContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode Static() { return getToken(IDLParser.Static, 0); }
		public MethodargumentsContext methodarguments() {
			return getRuleContext(MethodargumentsContext.class,0);
		}
		public MethodbodyContext methodbody() {
			return getRuleContext(MethodbodyContext.class,0);
		}
		public MethoddefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methoddefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethoddefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethoddefinition(this);
		}
	}

	public final MethoddefinitionContext methoddefinition() throws RecognitionException {
		MethoddefinitionContext _localctx = new MethoddefinitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_methoddefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(212);
				annotation();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Static) {
				{
				setState(218);
				match(Static);
				}
			}

			setState(221);
			methodreturn();
			setState(222);
			methodname();
			setState(223);
			match(T__1);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(224);
				methodarguments();
				}
			}

			setState(227);
			match(T__2);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(228);
				methodbody();
				}
				break;
			}
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(231);
				match(T__6);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodreturnContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public MethodreturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodreturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethodreturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethodreturn(this);
		}
	}

	public final MethodreturnContext methodreturn() throws RecognitionException {
		MethodreturnContext _localctx = new MethodreturnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodreturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			typename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodargumentsContext extends ParserRuleContext {
		public List<MethodargumentContext> methodargument() {
			return getRuleContexts(MethodargumentContext.class);
		}
		public MethodargumentContext methodargument(int i) {
			return getRuleContext(MethodargumentContext.class,i);
		}
		public MethodargumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodarguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethodarguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethodarguments(this);
		}
	}

	public final MethodargumentsContext methodarguments() throws RecognitionException {
		MethodargumentsContext _localctx = new MethodargumentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_methodarguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			methodargument();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(237);
				match(T__4);
				setState(238);
				methodargument();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public ArgumentnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterArgumentname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitArgumentname(this);
		}
	}

	public final ArgumentnameContext argumentname() throws RecognitionException {
		ArgumentnameContext _localctx = new ArgumentnameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_argumentname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumenttypeContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public ArgumenttypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumenttype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterArgumenttype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitArgumenttype(this);
		}
	}

	public final ArgumenttypeContext argumenttype() throws RecognitionException {
		ArgumenttypeContext _localctx = new ArgumenttypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argumenttype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			typename();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodargumentContext extends ParserRuleContext {
		public ArgumentnameContext argumentname() {
			return getRuleContext(ArgumentnameContext.class,0);
		}
		public ArgumenttypeContext argumenttype() {
			return getRuleContext(ArgumenttypeContext.class,0);
		}
		public TerminalNode DocumentationBlock() { return getToken(IDLParser.DocumentationBlock, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodargumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodargument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethodargument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethodargument(this);
		}
	}

	public final MethodargumentContext methodargument() throws RecognitionException {
		MethodargumentContext _localctx = new MethodargumentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_methodargument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DocumentationBlock) {
				{
				setState(248);
				match(DocumentationBlock);
				}
			}

			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(251);
				annotation();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
			argumentname();
			setState(258);
			match(T__7);
			setState(259);
			argumenttype();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodbodyContext extends ParserRuleContext {
		public MethodbodycontentContext methodbodycontent() {
			return getRuleContext(MethodbodycontentContext.class,0);
		}
		public MethodbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethodbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethodbody(this);
		}
	}

	public final MethodbodyContext methodbody() throws RecognitionException {
		MethodbodyContext _localctx = new MethodbodyContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_methodbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_CURLY) {
				{
				setState(261);
				methodbodycontent();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OPEN_CURLY() { return getToken(IDLParser.OPEN_CURLY, 0); }
		public List<TerminalNode> CLOSE_CURLY() { return getTokens(IDLParser.CLOSE_CURLY); }
		public TerminalNode CLOSE_CURLY(int i) {
			return getToken(IDLParser.CLOSE_CURLY, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(OPEN_CURLY);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << OPEN_CURLY) | (1L << Integerliteral) | (1L << Decimalliteral) | (1L << Hexadecimalliteral) | (1L << Namespace) | (1L << Class) | (1L << Extends) | (1L << Abstract) | (1L << Constructor) | (1L << Destructor) | (1L << Static) | (1L << Annotation) | (1L << Identifier) | (1L << False) | (1L << True) | (1L << Stringliteral) | (1L << Floatingliteral) | (1L << WS) | (1L << BlockComment) | (1L << LineComment) | (1L << DocumentationBlock) | (1L << LineDirective))) != 0)) {
				{
				setState(267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(265);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==CLOSE_CURLY) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				case 2:
					{
					setState(266);
					block();
					}
					break;
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
			match(CLOSE_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodbodycontentContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodbodycontentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodbodycontent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterMethodbodycontent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitMethodbodycontent(this);
		}
	}

	public final MethodbodycontentContext methodbodycontent() throws RecognitionException {
		MethodbodycontentContext _localctx = new MethodbodycontentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_methodbodycontent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public AnnotationnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterAnnotationname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitAnnotationname(this);
		}
	}

	public final AnnotationnameContext annotationname() throws RecognitionException {
		AnnotationnameContext _localctx = new AnnotationnameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_annotationname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode Annotation() { return getToken(IDLParser.Annotation, 0); }
		public AnnotationnameContext annotationname() {
			return getRuleContext(AnnotationnameContext.class,0);
		}
		public AnnotationbodyContext annotationbody() {
			return getRuleContext(AnnotationbodyContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(Annotation);
			setState(279);
			annotationname();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(280);
				match(T__1);
				setState(281);
				annotationbody();
				setState(282);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationparamnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public AnnotationparamnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationparamname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterAnnotationparamname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitAnnotationparamname(this);
		}
	}

	public final AnnotationparamnameContext annotationparamname() throws RecognitionException {
		AnnotationparamnameContext _localctx = new AnnotationparamnameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_annotationparamname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationparamvalueContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public AnnotationparamvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationparamvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterAnnotationparamvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitAnnotationparamvalue(this);
		}
	}

	public final AnnotationparamvalueContext annotationparamvalue() throws RecognitionException {
		AnnotationparamvalueContext _localctx = new AnnotationparamvalueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_annotationparamvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationbodyContext extends ParserRuleContext {
		public List<AnnotationparamnameContext> annotationparamname() {
			return getRuleContexts(AnnotationparamnameContext.class);
		}
		public AnnotationparamnameContext annotationparamname(int i) {
			return getRuleContext(AnnotationparamnameContext.class,i);
		}
		public List<AnnotationparamvalueContext> annotationparamvalue() {
			return getRuleContexts(AnnotationparamvalueContext.class);
		}
		public AnnotationparamvalueContext annotationparamvalue(int i) {
			return getRuleContext(AnnotationparamvalueContext.class,i);
		}
		public AnnotationbodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationbody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterAnnotationbody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitAnnotationbody(this);
		}
	}

	public final AnnotationbodyContext annotationbody() throws RecognitionException {
		AnnotationbodyContext _localctx = new AnnotationbodyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_annotationbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(290);
				annotationparamname();
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(291);
					match(T__8);
					setState(292);
					annotationparamvalue();
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__4) {
						{
						setState(293);
						match(T__4);
						}
					}

					}
				}

				}
				}
				setState(300); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Integerliteral() { return getToken(IDLParser.Integerliteral, 0); }
		public TerminalNode Stringliteral() { return getToken(IDLParser.Stringliteral, 0); }
		public BooleanliteralContext booleanliteral() {
			return getRuleContext(BooleanliteralContext.class,0);
		}
		public TerminalNode Floatingliteral() { return getToken(IDLParser.Floatingliteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_literal);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integerliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(Integerliteral);
				}
				break;
			case Stringliteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(Stringliteral);
				}
				break;
			case False:
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				booleanliteral();
				}
				break;
			case Floatingliteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
				match(Floatingliteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanliteralContext extends ParserRuleContext {
		public TerminalNode False() { return getToken(IDLParser.False, 0); }
		public TerminalNode True() { return getToken(IDLParser.True, 0); }
		public BooleanliteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanliteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterBooleanliteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitBooleanliteral(this);
		}
	}

	public final BooleanliteralContext booleanliteral() throws RecognitionException {
		BooleanliteralContext _localctx = new BooleanliteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_booleanliteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_la = _input.LA(1);
			if ( !(_la==False || _la==True) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0139\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\5\2H\n\2\3\2\3\2\3\3\6\3M\n\3\r\3\16\3N\3\4\3\4"+
		"\5\4S\n\4\3\5\3\5\3\5\7\5X\n\5\f\5\16\5[\13\5\3\6\3\6\3\6\5\6`\n\6\3\6"+
		"\3\6\3\7\3\7\5\7f\n\7\3\7\5\7i\n\7\3\b\3\b\3\b\3\b\7\bo\n\b\f\b\16\br"+
		"\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13\177\n\13\3\f\3"+
		"\f\3\r\5\r\u0084\n\r\3\r\7\r\u0087\n\r\f\r\16\r\u008a\13\r\3\r\5\r\u008d"+
		"\n\r\3\r\3\r\3\r\5\r\u0092\n\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\16\3\16"+
		"\3\16\3\17\7\17\u009e\n\17\f\17\16\17\u00a1\13\17\3\17\7\17\u00a4\n\17"+
		"\f\17\16\17\u00a7\13\17\3\17\5\17\u00aa\n\17\3\17\7\17\u00ad\n\17\f\17"+
		"\16\17\u00b0\13\17\3\20\3\20\3\21\7\21\u00b5\n\21\f\21\16\21\u00b8\13"+
		"\21\3\21\3\21\3\21\5\21\u00bd\n\21\3\21\3\21\5\21\u00c1\n\21\3\21\5\21"+
		"\u00c4\n\21\3\22\7\22\u00c7\n\22\f\22\16\22\u00ca\13\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00d0\n\22\3\22\5\22\u00d3\n\22\3\23\3\23\3\24\7\24\u00d8\n"+
		"\24\f\24\16\24\u00db\13\24\3\24\5\24\u00de\n\24\3\24\3\24\3\24\3\24\5"+
		"\24\u00e4\n\24\3\24\3\24\5\24\u00e8\n\24\3\24\5\24\u00eb\n\24\3\25\3\25"+
		"\3\26\3\26\3\26\7\26\u00f2\n\26\f\26\16\26\u00f5\13\26\3\27\3\27\3\30"+
		"\3\30\3\31\5\31\u00fc\n\31\3\31\7\31\u00ff\n\31\f\31\16\31\u0102\13\31"+
		"\3\31\3\31\3\31\3\31\3\32\5\32\u0109\n\32\3\33\3\33\3\33\7\33\u010e\n"+
		"\33\f\33\16\33\u0111\13\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u011f\n\36\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u0129\n"+
		"!\5!\u012b\n!\6!\u012d\n!\r!\16!\u012e\3\"\3\"\3\"\3\"\5\"\u0135\n\"\3"+
		"#\3#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BD\2\5\4\2\24\24\27\27\3\2\r\r\3\2\32\33\2\u0141\2G\3\2\2\2\4"+
		"L\3\2\2\2\6R\3\2\2\2\bT\3\2\2\2\n\\\3\2\2\2\fh\3\2\2\2\16j\3\2\2\2\20"+
		"u\3\2\2\2\22w\3\2\2\2\24~\3\2\2\2\26\u0080\3\2\2\2\30\u0083\3\2\2\2\32"+
		"\u0099\3\2\2\2\34\u009f\3\2\2\2\36\u00b1\3\2\2\2 \u00b6\3\2\2\2\"\u00c8"+
		"\3\2\2\2$\u00d4\3\2\2\2&\u00d9\3\2\2\2(\u00ec\3\2\2\2*\u00ee\3\2\2\2,"+
		"\u00f6\3\2\2\2.\u00f8\3\2\2\2\60\u00fb\3\2\2\2\62\u0108\3\2\2\2\64\u010a"+
		"\3\2\2\2\66\u0114\3\2\2\28\u0116\3\2\2\2:\u0118\3\2\2\2<\u0120\3\2\2\2"+
		">\u0122\3\2\2\2@\u012c\3\2\2\2B\u0134\3\2\2\2D\u0136\3\2\2\2FH\5\4\3\2"+
		"GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\2\2\3J\3\3\2\2\2KM\5\6\4\2LK\3\2\2"+
		"\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\5\3\2\2\2PS\5\22\n\2QS\5\30\r\2RP\3"+
		"\2\2\2RQ\3\2\2\2S\7\3\2\2\2TY\7\31\2\2UV\7\3\2\2VX\7\31\2\2WU\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\t\3\2\2\2[Y\3\2\2\2\\]\5\b\5\2]_\7\4\2"+
		"\2^`\5*\26\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\5\2\2b\13\3\2\2\2ce\5\b"+
		"\5\2df\5\16\b\2ed\3\2\2\2ef\3\2\2\2fi\3\2\2\2gi\5\n\6\2hc\3\2\2\2hg\3"+
		"\2\2\2i\r\3\2\2\2jk\7\6\2\2kp\5\f\7\2lm\7\7\2\2mo\5\f\7\2nl\3\2\2\2or"+
		"\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\7\b\2\2t\17\3\2\2\2"+
		"uv\7\31\2\2v\21\3\2\2\2wx\7\21\2\2xy\5\20\t\2yz\7\f\2\2z{\5\24\13\2{|"+
		"\7\r\2\2|\23\3\2\2\2}\177\5\4\3\2~}\3\2\2\2~\177\3\2\2\2\177\25\3\2\2"+
		"\2\u0080\u0081\7\31\2\2\u0081\27\3\2\2\2\u0082\u0084\7!\2\2\u0083\u0082"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0088\3\2\2\2\u0085\u0087\5:\36\2\u0086"+
		"\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\t\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\22"+
		"\2\2\u008f\u0091\5\26\f\2\u0090\u0092\5\32\16\2\u0091\u0090\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\f\2\2\u0094\u0095\5\34"+
		"\17\2\u0095\u0097\7\r\2\2\u0096\u0098\7\t\2\2\u0097\u0096\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\31\3\2\2\2\u0099\u009a\7\23\2\2\u009a\u009b\5\f\7"+
		"\2\u009b\33\3\2\2\2\u009c\u009e\5\36\20\2\u009d\u009c\3\2\2\2\u009e\u00a1"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a5\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a4\5 \21\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00aa\5\"\22\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3"+
		"\2\2\2\u00aa\u00ae\3\2\2\2\u00ab\u00ad\5&\24\2\u00ac\u00ab\3\2\2\2\u00ad"+
		"\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\35\3\2\2"+
		"\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7\"\2\2\u00b2\37\3\2\2\2\u00b3\u00b5"+
		"\5:\36\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\25"+
		"\2\2\u00ba\u00bc\7\4\2\2\u00bb\u00bd\5*\26\2\u00bc\u00bb\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\7\5\2\2\u00bf\u00c1\5\62"+
		"\32\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c4\7\t\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4!\3\2\2\2"+
		"\u00c5\u00c7\5:\36\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00cc\7\26\2\2\u00cc\u00cd\7\4\2\2\u00cd\u00cf\7\5\2\2\u00ce\u00d0\5"+
		"\62\32\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00d3\7\t\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3#\3\2\2\2"+
		"\u00d4\u00d5\7\31\2\2\u00d5%\3\2\2\2\u00d6\u00d8\5:\36\2\u00d7\u00d6\3"+
		"\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\7\27\2\2\u00dd\u00dc\3"+
		"\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\5(\25\2\u00e0"+
		"\u00e1\5$\23\2\u00e1\u00e3\7\4\2\2\u00e2\u00e4\5*\26\2\u00e3\u00e2\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\7\5\2\2\u00e6"+
		"\u00e8\5\62\32\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3"+
		"\2\2\2\u00e9\u00eb\7\t\2\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\'\3\2\2\2\u00ec\u00ed\5\f\7\2\u00ed)\3\2\2\2\u00ee\u00f3\5\60\31\2\u00ef"+
		"\u00f0\7\7\2\2\u00f0\u00f2\5\60\31\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3"+
		"\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4+\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f6\u00f7\7\31\2\2\u00f7-\3\2\2\2\u00f8\u00f9\5\f\7\2\u00f9"+
		"/\3\2\2\2\u00fa\u00fc\7!\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u0100\3\2\2\2\u00fd\u00ff\5:\36\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0104\5,\27\2\u0104\u0105\7\n\2\2\u0105\u0106\5."+
		"\30\2\u0106\61\3\2\2\2\u0107\u0109\5\66\34\2\u0108\u0107\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\63\3\2\2\2\u010a\u010f\7\f\2\2\u010b\u010e\n\3\2"+
		"\2\u010c\u010e\5\64\33\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\r\2\2\u0113\65\3\2\2\2\u0114\u0115"+
		"\5\64\33\2\u0115\67\3\2\2\2\u0116\u0117\7\31\2\2\u01179\3\2\2\2\u0118"+
		"\u0119\7\30\2\2\u0119\u011e\58\35\2\u011a\u011b\7\4\2\2\u011b\u011c\5"+
		"@!\2\u011c\u011d\7\5\2\2\u011d\u011f\3\2\2\2\u011e\u011a\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f;\3\2\2\2\u0120\u0121\7\31\2\2\u0121=\3\2\2\2\u0122"+
		"\u0123\5B\"\2\u0123?\3\2\2\2\u0124\u012a\5<\37\2\u0125\u0126\7\13\2\2"+
		"\u0126\u0128\5> \2\u0127\u0129\7\7\2\2\u0128\u0127\3\2\2\2\u0128\u0129"+
		"\3\2\2\2\u0129\u012b\3\2\2\2\u012a\u0125\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012d\3\2\2\2\u012c\u0124\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012fA\3\2\2\2\u0130\u0135\7\16\2\2\u0131\u0135"+
		"\7\34\2\2\u0132\u0135\5D#\2\u0133\u0135\7\35\2\2\u0134\u0130\3\2\2\2\u0134"+
		"\u0131\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0133\3\2\2\2\u0135C\3\2\2\2"+
		"\u0136\u0137\t\4\2\2\u0137E\3\2\2\2+GNRY_ehp~\u0083\u0088\u008c\u0091"+
		"\u0097\u009f\u00a5\u00a9\u00ae\u00b6\u00bc\u00c0\u00c3\u00c8\u00cf\u00d2"+
		"\u00d9\u00dd\u00e3\u00e7\u00ea\u00f3\u00fb\u0100\u0108\u010d\u010f\u011e"+
		"\u0128\u012a\u012e\u0134";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}