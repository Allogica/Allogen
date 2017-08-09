// Generated from com/allogica/allogen/idl/grammar/IDLParser.g4 by ANTLR 4.7
package com.allogica.allogen.idl.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IDLParser}.
 */
public interface IDLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IDLParser#sourcefile}.
	 * @param ctx the parse tree
	 */
	void enterSourcefile(IDLParser.SourcefileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#sourcefile}.
	 * @param ctx the parse tree
	 */
	void exitSourcefile(IDLParser.SourcefileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(IDLParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(IDLParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(IDLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(IDLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#regulartypename}.
	 * @param ctx the parse tree
	 */
	void enterRegulartypename(IDLParser.RegulartypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#regulartypename}.
	 * @param ctx the parse tree
	 */
	void exitRegulartypename(IDLParser.RegulartypenameContext ctx);

	/**
	 * Enter a parse tree produced by {@link IDLParser#lambdatype}.
	 * @param ctx the parse tree
	 */
	void enterLambdatype(IDLParser.LambdatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#lambdatype}.
	 * @param ctx the parse tree
	 */
	void exitLambdatype(IDLParser.LambdatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#typename}.
	 * @param ctx the parse tree
	 */
	void enterTypename(IDLParser.TypenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#typename}.
	 * @param ctx the parse tree
	 */
	void exitTypename(IDLParser.TypenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#typenametemplateargs}.
	 * @param ctx the parse tree
	 */
	void enterTypenametemplateargs(IDLParser.TypenametemplateargsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#typenametemplateargs}.
	 * @param ctx the parse tree
	 */
	void exitTypenametemplateargs(IDLParser.TypenametemplateargsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#namespacename}.
	 * @param ctx the parse tree
	 */
	void enterNamespacename(IDLParser.NamespacenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#namespacename}.
	 * @param ctx the parse tree
	 */
	void exitNamespacename(IDLParser.NamespacenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#namespacedefinition}.
	 * @param ctx the parse tree
	 */
	void enterNamespacedefinition(IDLParser.NamespacedefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#namespacedefinition}.
	 * @param ctx the parse tree
	 */
	void exitNamespacedefinition(IDLParser.NamespacedefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#namespacebody}.
	 * @param ctx the parse tree
	 */
	void enterNamespacebody(IDLParser.NamespacebodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#namespacebody}.
	 * @param ctx the parse tree
	 */
	void exitNamespacebody(IDLParser.NamespacebodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#classname}.
	 * @param ctx the parse tree
	 */
	void enterClassname(IDLParser.ClassnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#classname}.
	 * @param ctx the parse tree
	 */
	void exitClassname(IDLParser.ClassnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#classdefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassdefinition(IDLParser.ClassdefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#classdefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassdefinition(IDLParser.ClassdefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#classbody}.
	 * @param ctx the parse tree
	 */
	void enterClassbody(IDLParser.ClassbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#classbody}.
	 * @param ctx the parse tree
	 */
	void exitClassbody(IDLParser.ClassbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#includedefinition}.
	 * @param ctx the parse tree
	 */
	void enterIncludedefinition(IDLParser.IncludedefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#includedefinition}.
	 * @param ctx the parse tree
	 */
	void exitIncludedefinition(IDLParser.IncludedefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#constructordefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstructordefinition(IDLParser.ConstructordefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#constructordefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstructordefinition(IDLParser.ConstructordefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#destructordefinition}.
	 * @param ctx the parse tree
	 */
	void enterDestructordefinition(IDLParser.DestructordefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#destructordefinition}.
	 * @param ctx the parse tree
	 */
	void exitDestructordefinition(IDLParser.DestructordefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methodname}.
	 * @param ctx the parse tree
	 */
	void enterMethodname(IDLParser.MethodnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methodname}.
	 * @param ctx the parse tree
	 */
	void exitMethodname(IDLParser.MethodnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methoddefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethoddefinition(IDLParser.MethoddefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methoddefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethoddefinition(IDLParser.MethoddefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methodreturn}.
	 * @param ctx the parse tree
	 */
	void enterMethodreturn(IDLParser.MethodreturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methodreturn}.
	 * @param ctx the parse tree
	 */
	void exitMethodreturn(IDLParser.MethodreturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methodarguments}.
	 * @param ctx the parse tree
	 */
	void enterMethodarguments(IDLParser.MethodargumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methodarguments}.
	 * @param ctx the parse tree
	 */
	void exitMethodarguments(IDLParser.MethodargumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#argumentname}.
	 * @param ctx the parse tree
	 */
	void enterArgumentname(IDLParser.ArgumentnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#argumentname}.
	 * @param ctx the parse tree
	 */
	void exitArgumentname(IDLParser.ArgumentnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#argumenttype}.
	 * @param ctx the parse tree
	 */
	void enterArgumenttype(IDLParser.ArgumenttypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#argumenttype}.
	 * @param ctx the parse tree
	 */
	void exitArgumenttype(IDLParser.ArgumenttypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methodargument}.
	 * @param ctx the parse tree
	 */
	void enterMethodargument(IDLParser.MethodargumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methodargument}.
	 * @param ctx the parse tree
	 */
	void exitMethodargument(IDLParser.MethodargumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methodbody}.
	 * @param ctx the parse tree
	 */
	void enterMethodbody(IDLParser.MethodbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methodbody}.
	 * @param ctx the parse tree
	 */
	void exitMethodbody(IDLParser.MethodbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(IDLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(IDLParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#methodbodycontent}.
	 * @param ctx the parse tree
	 */
	void enterMethodbodycontent(IDLParser.MethodbodycontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#methodbodycontent}.
	 * @param ctx the parse tree
	 */
	void exitMethodbodycontent(IDLParser.MethodbodycontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#annotationname}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationname(IDLParser.AnnotationnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#annotationname}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationname(IDLParser.AnnotationnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(IDLParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(IDLParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#annotationparamname}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationparamname(IDLParser.AnnotationparamnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#annotationparamname}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationparamname(IDLParser.AnnotationparamnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#annotationparamvalue}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationparamvalue(IDLParser.AnnotationparamvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#annotationparamvalue}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationparamvalue(IDLParser.AnnotationparamvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#annotationbody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationbody(IDLParser.AnnotationbodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#annotationbody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationbody(IDLParser.AnnotationbodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link IDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(IDLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link IDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(IDLParser.LiteralContext ctx);
}