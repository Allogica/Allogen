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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OPEN_CURLY=10, CLOSE_CURLY=11, Integerliteral=12, Decimalliteral=13, Hexadecimalliteral=14, 
		Namespace=15, Class=16, Constructor=17, Destructor=18, Static=19, Annotation=20, 
		Identifier=21, False=22, True=23, Stringliteral=24, Floatingliteral=25, 
		WS=26, BlockComment=27, LineComment=28, DocumentationBlock=29, LineDirective=30;
	public static final int
		RULE_sourcefile = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_regulartypename = 3, 
		RULE_lambdatype = 4, RULE_typename = 5, RULE_typenametemplateargs = 6, 
		RULE_namespacename = 7, RULE_namespacedefinition = 8, RULE_namespacebody = 9, 
		RULE_classname = 10, RULE_classdefinition = 11, RULE_classbody = 12, RULE_includedefinition = 13, 
		RULE_constructordefinition = 14, RULE_destructordefinition = 15, RULE_methodname = 16, 
		RULE_methoddefinition = 17, RULE_methodreturn = 18, RULE_methodarguments = 19, 
		RULE_argumentname = 20, RULE_argumenttype = 21, RULE_methodargument = 22, 
		RULE_methodbody = 23, RULE_block = 24, RULE_methodbodycontent = 25, RULE_annotationname = 26, 
		RULE_annotation = 27, RULE_annotationparamname = 28, RULE_annotationparamvalue = 29, 
		RULE_annotationbody = 30, RULE_literal = 31, RULE_booleanliteral = 32;
	public static final String[] ruleNames = {
		"sourcefile", "declarations", "declaration", "regulartypename", "lambdatype", 
		"typename", "typenametemplateargs", "namespacename", "namespacedefinition", 
		"namespacebody", "classname", "classdefinition", "classbody", "includedefinition", 
		"constructordefinition", "destructordefinition", "methodname", "methoddefinition", 
		"methodreturn", "methodarguments", "argumentname", "argumenttype", "methodargument", 
		"methodbody", "block", "methodbodycontent", "annotationname", "annotation", 
		"annotationparamname", "annotationparamvalue", "annotationbody", "literal", 
		"booleanliteral"
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
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Annotation) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(66);
				declarations();
				}
			}

			setState(69);
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
			setState(72); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				declaration();
				}
				}
				setState(74); 
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
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Namespace:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				namespacedefinition();
				}
				break;
			case Class:
			case Annotation:
			case DocumentationBlock:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
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
			setState(80);
			match(Identifier);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(81);
				match(T__0);
				setState(82);
				match(Identifier);
				}
				}
				setState(87);
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
			setState(88);
			regulartypename();
			setState(89);
			match(T__1);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(90);
				methodarguments();
				}
			}

			setState(93);
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(95);
				regulartypename();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(96);
					typenametemplateargs();
					}
				}

				}
				break;
			case 2:
				{
				setState(99);
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
			setState(102);
			match(T__3);
			setState(103);
			typename();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(104);
				match(T__4);
				setState(105);
				typename();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
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
			setState(113);
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
			setState(115);
			match(Namespace);
			setState(116);
			namespacename();
			setState(117);
			match(OPEN_CURLY);
			setState(118);
			namespacebody();
			setState(119);
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
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Namespace) | (1L << Class) | (1L << Annotation) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(121);
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
			setState(124);
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
		enterRule(_localctx, 22, RULE_classdefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DocumentationBlock) {
				{
				setState(126);
				match(DocumentationBlock);
				}
			}

			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(129);
				annotation();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(Class);
			setState(136);
			classname();
			setState(137);
			match(OPEN_CURLY);
			setState(138);
			classbody();
			setState(139);
			match(CLOSE_CURLY);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(140);
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
		enterRule(_localctx, 24, RULE_classbody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LineDirective) {
				{
				{
				setState(143);
				includedefinition();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149);
					constructordefinition();
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(155);
				destructordefinition();
				}
				break;
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Static) | (1L << Annotation) | (1L << Identifier))) != 0)) {
				{
				{
				setState(158);
				methoddefinition();
				}
				}
				setState(163);
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
		enterRule(_localctx, 26, RULE_includedefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
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
		enterRule(_localctx, 28, RULE_constructordefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(166);
				annotation();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(Constructor);
			setState(173);
			match(T__1);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(174);
				methodarguments();
				}
			}

			setState(177);
			match(T__2);
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(178);
				methodbody();
				}
				break;
			}
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(181);
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
		enterRule(_localctx, 30, RULE_destructordefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(184);
				annotation();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			match(Destructor);
			setState(191);
			match(T__1);
			setState(192);
			match(T__2);
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(193);
				methodbody();
				}
				break;
			}
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(196);
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
		enterRule(_localctx, 32, RULE_methodname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
		enterRule(_localctx, 34, RULE_methoddefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(201);
				annotation();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Static) {
				{
				setState(207);
				match(Static);
				}
			}

			setState(210);
			methodreturn();
			setState(211);
			methodname();
			setState(212);
			match(T__1);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Annotation) | (1L << Identifier) | (1L << DocumentationBlock))) != 0)) {
				{
				setState(213);
				methodarguments();
				}
			}

			setState(216);
			match(T__2);
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(217);
				methodbody();
				}
				break;
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(220);
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
		enterRule(_localctx, 36, RULE_methodreturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
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
		enterRule(_localctx, 38, RULE_methodarguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			methodargument();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(226);
				match(T__4);
				setState(227);
				methodargument();
				}
				}
				setState(232);
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
		enterRule(_localctx, 40, RULE_argumentname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
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
		enterRule(_localctx, 42, RULE_argumenttype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		enterRule(_localctx, 44, RULE_methodargument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DocumentationBlock) {
				{
				setState(237);
				match(DocumentationBlock);
				}
			}

			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Annotation) {
				{
				{
				setState(240);
				annotation();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			argumentname();
			setState(247);
			match(T__7);
			setState(248);
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
		enterRule(_localctx, 46, RULE_methodbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_CURLY) {
				{
				setState(250);
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
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(OPEN_CURLY);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << OPEN_CURLY) | (1L << Integerliteral) | (1L << Decimalliteral) | (1L << Hexadecimalliteral) | (1L << Namespace) | (1L << Class) | (1L << Constructor) | (1L << Destructor) | (1L << Static) | (1L << Annotation) | (1L << Identifier) | (1L << False) | (1L << True) | (1L << Stringliteral) | (1L << Floatingliteral) | (1L << WS) | (1L << BlockComment) | (1L << LineComment) | (1L << DocumentationBlock) | (1L << LineDirective))) != 0)) {
				{
				setState(256);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(254);
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
					setState(255);
					block();
					}
					break;
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(261);
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
		enterRule(_localctx, 50, RULE_methodbodycontent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		enterRule(_localctx, 52, RULE_annotationname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		enterRule(_localctx, 54, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(Annotation);
			setState(268);
			annotationname();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(269);
				match(T__1);
				setState(270);
				annotationbody();
				setState(271);
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
		enterRule(_localctx, 56, RULE_annotationparamname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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
		enterRule(_localctx, 58, RULE_annotationparamvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
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
		enterRule(_localctx, 60, RULE_annotationbody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(279);
				annotationparamname();
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(280);
					match(T__8);
					setState(281);
					annotationparamvalue();
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__4) {
						{
						setState(282);
						match(T__4);
						}
					}

					}
				}

				}
				}
				setState(289); 
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
		enterRule(_localctx, 62, RULE_literal);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integerliteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				match(Integerliteral);
				}
				break;
			case Stringliteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(Stringliteral);
				}
				break;
			case False:
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				booleanliteral();
				}
				break;
			case Floatingliteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(294);
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
		enterRule(_localctx, 64, RULE_booleanliteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u012e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\5\2F\n\2\3\2\3\2\3\3\6\3K\n\3\r\3\16\3L\3\4\3\4\5\4Q\n"+
		"\4\3\5\3\5\3\5\7\5V\n\5\f\5\16\5Y\13\5\3\6\3\6\3\6\5\6^\n\6\3\6\3\6\3"+
		"\7\3\7\5\7d\n\7\3\7\5\7g\n\7\3\b\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13}\n\13\3\f\3\f\3\r\5\r"+
		"\u0082\n\r\3\r\7\r\u0085\n\r\f\r\16\r\u0088\13\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0090\n\r\3\16\7\16\u0093\n\16\f\16\16\16\u0096\13\16\3\16\7\16"+
		"\u0099\n\16\f\16\16\16\u009c\13\16\3\16\5\16\u009f\n\16\3\16\7\16\u00a2"+
		"\n\16\f\16\16\16\u00a5\13\16\3\17\3\17\3\20\7\20\u00aa\n\20\f\20\16\20"+
		"\u00ad\13\20\3\20\3\20\3\20\5\20\u00b2\n\20\3\20\3\20\5\20\u00b6\n\20"+
		"\3\20\5\20\u00b9\n\20\3\21\7\21\u00bc\n\21\f\21\16\21\u00bf\13\21\3\21"+
		"\3\21\3\21\3\21\5\21\u00c5\n\21\3\21\5\21\u00c8\n\21\3\22\3\22\3\23\7"+
		"\23\u00cd\n\23\f\23\16\23\u00d0\13\23\3\23\5\23\u00d3\n\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00d9\n\23\3\23\3\23\5\23\u00dd\n\23\3\23\5\23\u00e0\n\23"+
		"\3\24\3\24\3\25\3\25\3\25\7\25\u00e7\n\25\f\25\16\25\u00ea\13\25\3\26"+
		"\3\26\3\27\3\27\3\30\5\30\u00f1\n\30\3\30\7\30\u00f4\n\30\f\30\16\30\u00f7"+
		"\13\30\3\30\3\30\3\30\3\30\3\31\5\31\u00fe\n\31\3\32\3\32\3\32\7\32\u0103"+
		"\n\32\f\32\16\32\u0106\13\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0114\n\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \5 "+
		"\u011e\n \5 \u0120\n \6 \u0122\n \r \16 \u0123\3!\3!\3!\3!\5!\u012a\n"+
		"!\3\"\3\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@B\2\4\3\2\r\r\3\2\30\31\2\u0135\2E\3\2\2\2\4J\3\2\2\2\6"+
		"P\3\2\2\2\bR\3\2\2\2\nZ\3\2\2\2\ff\3\2\2\2\16h\3\2\2\2\20s\3\2\2\2\22"+
		"u\3\2\2\2\24|\3\2\2\2\26~\3\2\2\2\30\u0081\3\2\2\2\32\u0094\3\2\2\2\34"+
		"\u00a6\3\2\2\2\36\u00ab\3\2\2\2 \u00bd\3\2\2\2\"\u00c9\3\2\2\2$\u00ce"+
		"\3\2\2\2&\u00e1\3\2\2\2(\u00e3\3\2\2\2*\u00eb\3\2\2\2,\u00ed\3\2\2\2."+
		"\u00f0\3\2\2\2\60\u00fd\3\2\2\2\62\u00ff\3\2\2\2\64\u0109\3\2\2\2\66\u010b"+
		"\3\2\2\28\u010d\3\2\2\2:\u0115\3\2\2\2<\u0117\3\2\2\2>\u0121\3\2\2\2@"+
		"\u0129\3\2\2\2B\u012b\3\2\2\2DF\5\4\3\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2"+
		"GH\7\2\2\3H\3\3\2\2\2IK\5\6\4\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2"+
		"\2M\5\3\2\2\2NQ\5\22\n\2OQ\5\30\r\2PN\3\2\2\2PO\3\2\2\2Q\7\3\2\2\2RW\7"+
		"\27\2\2ST\7\3\2\2TV\7\27\2\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X"+
		"\t\3\2\2\2YW\3\2\2\2Z[\5\b\5\2[]\7\4\2\2\\^\5(\25\2]\\\3\2\2\2]^\3\2\2"+
		"\2^_\3\2\2\2_`\7\5\2\2`\13\3\2\2\2ac\5\b\5\2bd\5\16\b\2cb\3\2\2\2cd\3"+
		"\2\2\2dg\3\2\2\2eg\5\n\6\2fa\3\2\2\2fe\3\2\2\2g\r\3\2\2\2hi\7\6\2\2in"+
		"\5\f\7\2jk\7\7\2\2km\5\f\7\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o"+
		"q\3\2\2\2pn\3\2\2\2qr\7\b\2\2r\17\3\2\2\2st\7\27\2\2t\21\3\2\2\2uv\7\21"+
		"\2\2vw\5\20\t\2wx\7\f\2\2xy\5\24\13\2yz\7\r\2\2z\23\3\2\2\2{}\5\4\3\2"+
		"|{\3\2\2\2|}\3\2\2\2}\25\3\2\2\2~\177\7\27\2\2\177\27\3\2\2\2\u0080\u0082"+
		"\7\37\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0086\3\2\2\2"+
		"\u0083\u0085\58\35\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7\22\2\2\u008a\u008b\5\26\f\2\u008b\u008c\7\f\2\2\u008c\u008d\5"+
		"\32\16\2\u008d\u008f\7\r\2\2\u008e\u0090\7\t\2\2\u008f\u008e\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\31\3\2\2\2\u0091\u0093\5\34\17\2\u0092\u0091\3\2"+
		"\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u009a\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\5\36\20\2\u0098\u0097\3"+
		"\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\5 \21\2\u009e\u009d\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a3\3\2\2\2\u00a0\u00a2\5$\23\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\33\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7 \2\2\u00a7\35"+
		"\3\2\2\2\u00a8\u00aa\58\35\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ae\u00af\7\23\2\2\u00af\u00b1\7\4\2\2\u00b0\u00b2\5(\25\2\u00b1"+
		"\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\7\5"+
		"\2\2\u00b4\u00b6\5\60\31\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b9\7\t\2\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\37\3\2\2\2\u00ba\u00bc\58\35\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf"+
		"\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c1\7\24\2\2\u00c1\u00c2\7\4\2\2\u00c2\u00c4\7"+
		"\5\2\2\u00c3\u00c5\5\60\31\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00c8\7\t\2\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8!\3\2\2\2\u00c9\u00ca\7\27\2\2\u00ca#\3\2\2\2\u00cb\u00cd\5"+
		"8\35\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\7\25"+
		"\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\5&\24\2\u00d5\u00d6\5\"\22\2\u00d6\u00d8\7\4\2\2\u00d7\u00d9\5"+
		"(\25\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00dc\7\5\2\2\u00db\u00dd\5\60\31\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3"+
		"\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00e0\7\t\2\2\u00df\u00de\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0%\3\2\2\2\u00e1\u00e2\5\f\7\2\u00e2\'\3\2\2\2\u00e3"+
		"\u00e8\5.\30\2\u00e4\u00e5\7\7\2\2\u00e5\u00e7\5.\30\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		")\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7\27\2\2\u00ec+\3\2\2\2\u00ed"+
		"\u00ee\5\f\7\2\u00ee-\3\2\2\2\u00ef\u00f1\7\37\2\2\u00f0\u00ef\3\2\2\2"+
		"\u00f0\u00f1\3\2\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f4\58\35\2\u00f3\u00f2"+
		"\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\5*\26\2\u00f9\u00fa\7\n"+
		"\2\2\u00fa\u00fb\5,\27\2\u00fb/\3\2\2\2\u00fc\u00fe\5\64\33\2\u00fd\u00fc"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\61\3\2\2\2\u00ff\u0104\7\f\2\2\u0100"+
		"\u0103\n\2\2\2\u0101\u0103\5\62\32\2\u0102\u0100\3\2\2\2\u0102\u0101\3"+
		"\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\7\r\2\2\u0108\63\3\2\2"+
		"\2\u0109\u010a\5\62\32\2\u010a\65\3\2\2\2\u010b\u010c\7\27\2\2\u010c\67"+
		"\3\2\2\2\u010d\u010e\7\26\2\2\u010e\u0113\5\66\34\2\u010f\u0110\7\4\2"+
		"\2\u0110\u0111\5> \2\u0111\u0112\7\5\2\2\u0112\u0114\3\2\2\2\u0113\u010f"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u01149\3\2\2\2\u0115\u0116\7\27\2\2\u0116"+
		";\3\2\2\2\u0117\u0118\5@!\2\u0118=\3\2\2\2\u0119\u011f\5:\36\2\u011a\u011b"+
		"\7\13\2\2\u011b\u011d\5<\37\2\u011c\u011e\7\7\2\2\u011d\u011c\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011a\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u0119\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124?\3\2\2\2\u0125\u012a\7\16\2\2"+
		"\u0126\u012a\7\32\2\2\u0127\u012a\5B\"\2\u0128\u012a\7\33\2\2\u0129\u0125"+
		"\3\2\2\2\u0129\u0126\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a"+
		"A\3\2\2\2\u012b\u012c\t\3\2\2\u012cC\3\2\2\2)ELPW]cfn|\u0081\u0086\u008f"+
		"\u0094\u009a\u009e\u00a3\u00ab\u00b1\u00b5\u00b8\u00bd\u00c4\u00c7\u00ce"+
		"\u00d2\u00d8\u00dc\u00df\u00e8\u00f0\u00f5\u00fd\u0102\u0104\u0113\u011d"+
		"\u011f\u0123\u0129";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}