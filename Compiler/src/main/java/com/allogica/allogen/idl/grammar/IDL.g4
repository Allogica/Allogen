/*
 * Copyright (c) 2017, Allogica
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice,
 *       this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of Allogen nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

grammar IDL;

sourcefile: declarations? EOF;

declarations:
	declaration+
;

declaration:
	namespacedefinition
	| classdefinition
;

regulartypename:
    Identifier
;

lambdareturn: Identifier;

lambdatype:
    lambdareturn '(' methodarguments? ')'
;

typename:
    (regulartypename | lambdatype)
    typenametemplateargs?
;

typenametemplateargs:
    ('<' typename (',' typename)* '>')
;

/* Namespaces */
namespacename:
    Identifier
;

namespacedefinition:
	Namespace namespacename '{' namespacebody '}'
;

namespacebody:
	declarations?
;

/* Classes */
classname:
    Identifier
;

classdefinition:
    DocumentationBlock?
    annotation*
	Class classname '{' classbody '}' ';'?
;

classbody:
    includedefinition*
    constructordefinition*
    destructordefinition?
	methoddefinition*
;

/* Includes */
includedefinition:
    LineDirective
;

/* Constructors & Destructors */
constructordefinition:
    annotation*
    'constructor' '(' methodarguments? ')' methodbody? ';'?
;

destructordefinition:
    annotation*
    'destructor' '(' ')' methodbody? ';'?
;

/* Methods */
methodname:
    Identifier
;

methoddefinition:
    annotation*
    Static? methodreturn methodname '(' methodarguments? ')' methodbody? ';'?
;

methodreturn: typename;

methodarguments:
    methodargument
    (',' methodargument)*
;

argumentname: Identifier;
argumenttype: typename;

methodargument:
    DocumentationBlock?
    annotation*
    argumentname ':' argumenttype
;

methodbody: methodbodycontent?;

block: OPEN_CURLY (~CLOSE_CURLY | block)* CLOSE_CURLY;

OPEN_CURLY: '{';
CLOSE_CURLY: '}';

methodbodycontent: block;

/* Annotations */
annotationname:
    Identifier
;

annotation:
    Annotation annotationname ('(' annotationbody ')')?
;

annotationparamname:
    Identifier
;

annotationparamvalue:
    literal
;

annotationbody:
    (annotationparamname (
        '=' annotationparamvalue ','?
    )?)+
;

/* Literals */
literal:
	Integerliteral
	| Stringliteral
	| booleanliteral
	| Floatingliteral
;

Integerliteral:
	Decimalliteral
	| Hexadecimalliteral
;

Decimalliteral:
	NONZERODIGIT
	(
		'\''? DIGIT
	)*
;

Hexadecimalliteral:
	(
		'0x'
		| '0X'
	) HEXADECIMALDIGIT
	(
		'\''? HEXADECIMALDIGIT
	)*
;

fragment
HEXADECIMALDIGIT:
	[0-9a-fA-F]
;

booleanliteral:
	False
	| True
;

/* Identifiers */
Namespace: 'namespace';
Class: 'class';

Constructor: 'constructor';
Destructor: 'destructor';
Static: 'static';

Annotation: '@';

Identifier:
	Identifiernondigit
	(
		Identifiernondigit
		| DIGIT
	)*
;

False: 'false';
True: 'true';

Stringliteral:
	'"' Schar* '"'
;

fragment
Schar:
	~["\\\r\n]
	| Escapesequence;

fragment
Escapesequence:
	Simpleescapesequence
;

fragment
Simpleescapesequence:
	'\\\''
	| '\\"'
	| '\\?'
	| '\\\\'
	| '\\a'
	| '\\b'
	| '\\f'
	| '\\n'
	| '\\r'
	| '\\t'
	| '\\v'
;

Floatingliteral:
	Fractionalconstant Exponentpart? Floatingsuffix?
	| Digitsequence Exponentpart Floatingsuffix?
;

fragment
Fractionalconstant:
	Digitsequence? '.' Digitsequence
	| Digitsequence '.'
;

fragment
Exponentpart:
	'e' SIGN? Digitsequence
	| 'E' SIGN? Digitsequence
;

fragment
SIGN:
	[+-]
;

fragment
Digitsequence:
	DIGIT
	(
		'\''? DIGIT
	)*
;

fragment
Floatingsuffix:
	[flFL]
;

fragment
Identifiernondigit:
	NONDIGIT
;

fragment
NONDIGIT:
	[a-zA-Z_]
;

fragment
DIGIT:
	[0-9]
;

fragment
NONZERODIGIT
:
	[1-9]
;

WS:   (' '|'\r'|'\n'|'\t') -> channel(HIDDEN);

BlockComment:
	'/*' .*? '*/' -> skip
;
LineComment:
	'//' ~[\r\n]* -> skip
;
DocumentationBlock:
	'///' ~[\r\n]*
;

LineDirective:   '#' ~[\r\n]*;

