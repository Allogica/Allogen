// Generated from com/allogica/allogen/idl/grammar/IDL.g4 by ANTLR 4.7
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, OPEN_CURLY=9, 
		CLOSE_CURLY=10, Integerliteral=11, Decimalliteral=12, Hexadecimalliteral=13, 
		Namespace=14, Class=15, Constructor=16, Destructor=17, Static=18, Annotation=19, 
		Identifier=20, False=21, True=22, Stringliteral=23, Floatingliteral=24, 
		WS=25, BlockComment=26, LineComment=27, DocumentationBlock=28, LineDirective=29;
	public static final int
		RULE_sourcefile = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_regulartypename = 3, 
		RULE_lambdareturn = 4, RULE_lambdatype = 5, RULE_typename = 6, RULE_typenametemplateargs = 7, 
		RULE_namespacename = 8, RULE_namespacedefinition = 9, RULE_namespacebody = 10, 
		RULE_classname = 11, RULE_classdefinition = 12, RULE_classbody = 13, RULE_includedefinition = 14, 
		RULE_constructordefinition = 15, RULE_destructordefinition = 16, RULE_methodname = 17, 
		RULE_methoddefinition = 18, RULE_methodreturn = 19, RULE_methodarguments = 20, 
		RULE_argumentname = 21, RULE_argumenttype = 22, RULE_methodargument = 23, 
		RULE_methodbody = 24, RULE_block = 25, RULE_methodbodycontent = 26, RULE_annotationname = 27, 
		RULE_annotation = 28, RULE_annotationparamname = 29, RULE_annotationparamvalue = 30, 
		RULE_annotationbody = 31, RULE_literal = 32, RULE_booleanliteral = 33;
	public static final String[] ruleNames = {
		"sourcefile", "declarations", "declaration", "regulartypename", "lambdareturn", 
		"lambdatype", "typename", "typenametemplateargs", "namespacename", "namespacedefinition", 
		"namespacebody", "classname", "classdefinition", "classbody", "includedefinition", 
		"constructordefinition", "destructordefinition", "methodname", "methoddefinition", 
		"methodreturn", "methodarguments", "argumentname", "argumenttype", "methodargument", 
		"methodbody", "block", "methodbodycontent", "annotationname", "annotation", 
		"annotationparamname", "annotationparamvalue", "annotationbody", "literal", 
		"booleanliteral"
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Annotation) | (1L << DocumentationBlock))) != 0)) {
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Annotation) | (1L << DocumentationBlock))) != 0) );
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
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
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

	public static class LambdareturnContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(IDLParser.Identifier, 0); }
		public LambdareturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdareturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).enterLambdareturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IDLListener ) ((IDLListener)listener).exitLambdareturn(this);
		}
	}

	public final LambdareturnContext lambdareturn() throws RecognitionException {
		LambdareturnContext _localctx = new LambdareturnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lambdareturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
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

	public static class LambdatypeContext extends ParserRuleContext {
		public LambdareturnContext lambdareturn() {
			return getRuleContext(LambdareturnContext.class,0);
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
		enterRule(_localctx, 10, RULE_lambdatype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			lambdareturn();
			setState(87);
			match(T__0);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(88);
				methodarguments();
				}
			}

			setState(91);
			match(T__1);
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
		enterRule(_localctx, 12, RULE_typename);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(93);
				regulartypename();
				}
				break;
			case 2:
				{
				setState(94);
				lambdatype();
				}
				break;
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(97);
				typenametemplateargs();
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
		enterRule(_localctx, 14, RULE_typenametemplateargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(100);
			match(T__2);
			setState(101);
			typename();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(102);
				match(T__3);
				setState(103);
				typename();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(T__4);
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
		enterRule(_localctx, 16, RULE_namespacename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
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
		enterRule(_localctx, 18, RULE_namespacedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(Namespace);
			setState(114);
			namespacename();
			setState(115);
			match(OPEN_CURLY);
			setState(116);
			namespacebody();
			setState(117);
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
		enterRule(_localctx, 20, RULE_namespacebody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Annotation) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(119);
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
		enterRule(_localctx, 22, RULE_classname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		enterRule(_localctx, 24, RULE_classdefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DocumentationBlock) {
				{
				setState(124);
				match(DocumentationBlock);
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(127);
				annotation();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(Class);
			setState(134);
			classname();
			setState(135);
			match(OPEN_CURLY);
			setState(136);
			classbody();
			setState(137);
			match(CLOSE_CURLY);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(138);
				match(T__5);
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
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LineDirective) {
				{
				{
				setState(141);
				includedefinition();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(147);
					constructordefinition();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(153);
				destructordefinition();
				}
				break;
			}
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Static) | (1L << Annotation) | (1L << Identifier))) != 0)) {
				{
				{
				setState(156);
				methoddefinition();
				}
				}
				setState(161);
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
			setState(162);
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
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(164);
				annotation();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(Constructor);
			setState(171);
			match(T__0);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(172);
				methodarguments();
				}
			}

			setState(175);
			match(T__1);
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(176);
				methodbody();
				}
				break;
			}
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(179);
				match(T__5);
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
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(182);
				annotation();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(Destructor);
			setState(189);
			match(T__0);
			setState(190);
			match(T__1);
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(191);
				methodbody();
				}
				break;
			}
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(194);
				match(T__5);
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
			setState(197);
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
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(199);
				annotation();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Static) {
				{
				setState(205);
				match(Static);
				}
			}

			setState(208);
			methodreturn();
			setState(209);
			methodname();
			setState(210);
			match(T__0);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(211);
				methodarguments();
				}
			}

			setState(214);
			match(T__1);
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(215);
				methodbody();
				}
				break;
			}
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(218);
				match(T__5);
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
			setState(221);
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
			setState(223);
			methodargument();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(224);
				match(T__3);
				setState(225);
				methodargument();
				}
				}
				setState(230);
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
			setState(231);
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
			setState(233);
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
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DocumentationBlock) {
				{
				setState(235);
				match(DocumentationBlock);
				}
			}

			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(238);
				annotation();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			argumentname();
			setState(245);
			match(T__6);
			setState(246);
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
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_CURLY) {
				{
				setState(248);
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
			setState(251);
			match(OPEN_CURLY);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << OPEN_CURLY) | (1L << Integerliteral) | (1L << Decimalliteral) | (1L << Hexadecimalliteral) | (1L << Namespace) | (1L << Class) | (1L << Constructor) | (1L << Destructor) | (1L << Static) | (1L << Annotation) | (1L << Identifier) | (1L << False) | (1L << True) | (1L << Stringliteral) | (1L << Floatingliteral) | (1L << WS) | (1L << BlockComment) | (1L << LineComment) | (1L << DocumentationBlock) | (1L << LineDirective))) != 0)) {
				{
				setState(254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(252);
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
					setState(253);
					block();
					}
					break;
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259);
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
			setState(261);
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
			setState(263);
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
			setState(265);
			match(Annotation);
			setState(266);
			annotationname();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(267);
				match(T__0);
				setState(268);
				annotationbody();
				setState(269);
				match(T__1);
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
			setState(273);
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
			setState(275);
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
			setState(285); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(277);
				annotationparamname();
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(278);
					match(T__7);
					setState(279);
					annotationparamvalue();
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__3) {
						{
						setState(280);
						match(T__3);
						}
					}

					}
				}

				}
				}
				setState(287); 
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
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integerliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(Integerliteral);
				}
				break;
			case Stringliteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(Stringliteral);
				}
				break;
			case False:
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				booleanliteral();
				}
				break;
			case Floatingliteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
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
			setState(295);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u012c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\5\2H\n\2\3\2\3\2\3\3\6\3M\n\3\r\3\16\3N\3\4\3\4"+
		"\5\4S\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\5\7\\\n\7\3\7\3\7\3\b\3\b\5\bb\n"+
		"\b\3\b\5\be\n\b\3\t\3\t\3\t\3\t\7\tk\n\t\f\t\16\tn\13\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\5\f{\n\f\3\r\3\r\3\16\5\16\u0080"+
		"\n\16\3\16\7\16\u0083\n\16\f\16\16\16\u0086\13\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u008e\n\16\3\17\7\17\u0091\n\17\f\17\16\17\u0094\13\17"+
		"\3\17\7\17\u0097\n\17\f\17\16\17\u009a\13\17\3\17\5\17\u009d\n\17\3\17"+
		"\7\17\u00a0\n\17\f\17\16\17\u00a3\13\17\3\20\3\20\3\21\7\21\u00a8\n\21"+
		"\f\21\16\21\u00ab\13\21\3\21\3\21\3\21\5\21\u00b0\n\21\3\21\3\21\5\21"+
		"\u00b4\n\21\3\21\5\21\u00b7\n\21\3\22\7\22\u00ba\n\22\f\22\16\22\u00bd"+
		"\13\22\3\22\3\22\3\22\3\22\5\22\u00c3\n\22\3\22\5\22\u00c6\n\22\3\23\3"+
		"\23\3\24\7\24\u00cb\n\24\f\24\16\24\u00ce\13\24\3\24\5\24\u00d1\n\24\3"+
		"\24\3\24\3\24\3\24\5\24\u00d7\n\24\3\24\3\24\5\24\u00db\n\24\3\24\5\24"+
		"\u00de\n\24\3\25\3\25\3\26\3\26\3\26\7\26\u00e5\n\26\f\26\16\26\u00e8"+
		"\13\26\3\27\3\27\3\30\3\30\3\31\5\31\u00ef\n\31\3\31\7\31\u00f2\n\31\f"+
		"\31\16\31\u00f5\13\31\3\31\3\31\3\31\3\31\3\32\5\32\u00fc\n\32\3\33\3"+
		"\33\3\33\7\33\u0101\n\33\f\33\16\33\u0104\13\33\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0112\n\36\3\37\3\37\3 \3"+
		" \3!\3!\3!\3!\5!\u011c\n!\5!\u011e\n!\6!\u0120\n!\r!\16!\u0121\3\"\3\""+
		"\3\"\3\"\5\"\u0128\n\"\3#\3#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\4\3\2\f\f\3\2\27\30\2\u0131\2G\3"+
		"\2\2\2\4L\3\2\2\2\6R\3\2\2\2\bT\3\2\2\2\nV\3\2\2\2\fX\3\2\2\2\16a\3\2"+
		"\2\2\20f\3\2\2\2\22q\3\2\2\2\24s\3\2\2\2\26z\3\2\2\2\30|\3\2\2\2\32\177"+
		"\3\2\2\2\34\u0092\3\2\2\2\36\u00a4\3\2\2\2 \u00a9\3\2\2\2\"\u00bb\3\2"+
		"\2\2$\u00c7\3\2\2\2&\u00cc\3\2\2\2(\u00df\3\2\2\2*\u00e1\3\2\2\2,\u00e9"+
		"\3\2\2\2.\u00eb\3\2\2\2\60\u00ee\3\2\2\2\62\u00fb\3\2\2\2\64\u00fd\3\2"+
		"\2\2\66\u0107\3\2\2\28\u0109\3\2\2\2:\u010b\3\2\2\2<\u0113\3\2\2\2>\u0115"+
		"\3\2\2\2@\u011f\3\2\2\2B\u0127\3\2\2\2D\u0129\3\2\2\2FH\5\4\3\2GF\3\2"+
		"\2\2GH\3\2\2\2HI\3\2\2\2IJ\7\2\2\3J\3\3\2\2\2KM\5\6\4\2LK\3\2\2\2MN\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2O\5\3\2\2\2PS\5\24\13\2QS\5\32\16\2RP\3\2\2"+
		"\2RQ\3\2\2\2S\7\3\2\2\2TU\7\26\2\2U\t\3\2\2\2VW\7\26\2\2W\13\3\2\2\2X"+
		"Y\5\n\6\2Y[\7\3\2\2Z\\\5*\26\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\7\4\2"+
		"\2^\r\3\2\2\2_b\5\b\5\2`b\5\f\7\2a_\3\2\2\2a`\3\2\2\2bd\3\2\2\2ce\5\20"+
		"\t\2dc\3\2\2\2de\3\2\2\2e\17\3\2\2\2fg\7\5\2\2gl\5\16\b\2hi\7\6\2\2ik"+
		"\5\16\b\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2"+
		"op\7\7\2\2p\21\3\2\2\2qr\7\26\2\2r\23\3\2\2\2st\7\20\2\2tu\5\22\n\2uv"+
		"\7\13\2\2vw\5\26\f\2wx\7\f\2\2x\25\3\2\2\2y{\5\4\3\2zy\3\2\2\2z{\3\2\2"+
		"\2{\27\3\2\2\2|}\7\26\2\2}\31\3\2\2\2~\u0080\7\36\2\2\177~\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\u0084\3\2\2\2\u0081\u0083\5:\36\2\u0082\u0081\3\2"+
		"\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\21\2\2\u0088\u0089\5"+
		"\30\r\2\u0089\u008a\7\13\2\2\u008a\u008b\5\34\17\2\u008b\u008d\7\f\2\2"+
		"\u008c\u008e\7\b\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\33"+
		"\3\2\2\2\u008f\u0091\5\36\20\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2"+
		"\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0098\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0095\u0097\5 \21\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009d\5\"\22\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u00a1\3\2\2\2\u009e\u00a0\5&\24\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\35\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a4\u00a5\7\37\2\2\u00a5\37\3\2\2\2\u00a6\u00a8\5:\36\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7\22\2\2\u00ad"+
		"\u00af\7\3\2\2\u00ae\u00b0\5*\26\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\7\4\2\2\u00b2\u00b4\5\62\32\2\u00b3"+
		"\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b7\7\b"+
		"\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7!\3\2\2\2\u00b8\u00ba"+
		"\5:\36\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7\23"+
		"\2\2\u00bf\u00c0\7\3\2\2\u00c0\u00c2\7\4\2\2\u00c1\u00c3\5\62\32\2\u00c2"+
		"\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c6\7\b"+
		"\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6#\3\2\2\2\u00c7\u00c8"+
		"\7\26\2\2\u00c8%\3\2\2\2\u00c9\u00cb\5:\36\2\u00ca\u00c9\3\2\2\2\u00cb"+
		"\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d0\3\2"+
		"\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7\24\2\2\u00d0\u00cf\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\5(\25\2\u00d3\u00d4\5$"+
		"\23\2\u00d4\u00d6\7\3\2\2\u00d5\u00d7\5*\26\2\u00d6\u00d5\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\7\4\2\2\u00d9\u00db\5\62"+
		"\32\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc"+
		"\u00de\7\b\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\'\3\2\2\2"+
		"\u00df\u00e0\5\16\b\2\u00e0)\3\2\2\2\u00e1\u00e6\5\60\31\2\u00e2\u00e3"+
		"\7\6\2\2\u00e3\u00e5\5\60\31\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7+\3\2\2\2\u00e8\u00e6\3"+
		"\2\2\2\u00e9\u00ea\7\26\2\2\u00ea-\3\2\2\2\u00eb\u00ec\5\16\b\2\u00ec"+
		"/\3\2\2\2\u00ed\u00ef\7\36\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2"+
		"\u00ef\u00f3\3\2\2\2\u00f0\u00f2\5:\36\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f7\5,\27\2\u00f7\u00f8\7\t\2\2\u00f8\u00f9\5."+
		"\30\2\u00f9\61\3\2\2\2\u00fa\u00fc\5\66\34\2\u00fb\u00fa\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\63\3\2\2\2\u00fd\u0102\7\13\2\2\u00fe\u0101\n\2\2"+
		"\2\u00ff\u0101\5\64\33\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101"+
		"\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2"+
		"\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7\f\2\2\u0106\65\3\2\2\2\u0107\u0108"+
		"\5\64\33\2\u0108\67\3\2\2\2\u0109\u010a\7\26\2\2\u010a9\3\2\2\2\u010b"+
		"\u010c\7\25\2\2\u010c\u0111\58\35\2\u010d\u010e\7\3\2\2\u010e\u010f\5"+
		"@!\2\u010f\u0110\7\4\2\2\u0110\u0112\3\2\2\2\u0111\u010d\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112;\3\2\2\2\u0113\u0114\7\26\2\2\u0114=\3\2\2\2\u0115"+
		"\u0116\5B\"\2\u0116?\3\2\2\2\u0117\u011d\5<\37\2\u0118\u0119\7\n\2\2\u0119"+
		"\u011b\5> \2\u011a\u011c\7\6\2\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2"+
		"\2\u011c\u011e\3\2\2\2\u011d\u0118\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120"+
		"\3\2\2\2\u011f\u0117\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122A\3\2\2\2\u0123\u0128\7\r\2\2\u0124\u0128\7\31\2\2"+
		"\u0125\u0128\5D#\2\u0126\u0128\7\32\2\2\u0127\u0123\3\2\2\2\u0127\u0124"+
		"\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128C\3\2\2\2\u0129"+
		"\u012a\t\3\2\2\u012aE\3\2\2\2(GNR[adlz\177\u0084\u008d\u0092\u0098\u009c"+
		"\u00a1\u00a9\u00af\u00b3\u00b6\u00bb\u00c2\u00c5\u00cc\u00d0\u00d6\u00da"+
		"\u00dd\u00e6\u00ee\u00f3\u00fb\u0100\u0102\u0111\u011b\u011d\u0121\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}