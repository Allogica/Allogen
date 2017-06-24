from pyparsing import *
import pyparsing


class InterfaceDict(TokenConverter):
    def __init__(self, expr, param):
        super(InterfaceDict, self).__init__(expr)
        self.saveAsList = True
        self.param = param

    def postParse(self, instring, loc, tokenlist):
        for i, tok in enumerate(tokenlist):
            if len(tok) == 0:
                continue
            ikey = tok[self.param]
            if isinstance(ikey, int):
                ikey = pyparsing._ustr(tok[0]).strip()
            if len(tok) == 1:
                tokenlist[ikey] = pyparsing._ParseResultsWithOffset("", i)
            elif len(tok) == 2 and not isinstance(tok[1], ParseResults):
                tokenlist[ikey] = pyparsing._ParseResultsWithOffset(tok[1], i)
            else:
                dictvalue = tok.copy()  # ParseResults(i)
                del dictvalue[0]
                if len(dictvalue) != 1 or (isinstance(dictvalue, ParseResults) and dictvalue.haskeys()):
                    tokenlist[ikey] = pyparsing._ParseResultsWithOffset(dictvalue, i)
                else:
                    tokenlist[ikey] = pyparsing._ParseResultsWithOffset(dictvalue[0], i)

        if self.resultsName:
            return [tokenlist]
        else:
            return tokenlist


opening_bracket = Literal('{').suppress()
closing_bracket = Literal('}').suppress()
optional_semicolon = Optional(Literal(';').suppress())
cpp_ident = alphanums + '_'

import_decl = Group(
    Literal('import')('type') + QuotedString('"')('path') + optional_semicolon
)

annotation = Group(
    Literal('@').suppress() + Word(cpp_ident)('name') + Optional(
        Literal('(') + InterfaceDict(delimitedList(Group(
            Word(cpp_ident)('name') + Literal('=') + Combine(
                Literal('true') | Literal('false') | QuotedString('"') | Word(nums)
            )('value')
        )), param='name') + Literal(')')
    ) + optional_semicolon
)
annotations = InterfaceDict(ZeroOrMore(
    annotation
), param='name')

extends_declaration = Combine(Literal('extends').suppress() + Word(cpp_ident), adjacent=False)
implements_declaration = Combine(Literal('implements').suppress() + Word(cpp_ident), adjacent=False)

cpp_inline_code = Combine(originalTextFor(nestedExpr(opener='{', closer='}')))
typename = Group(
    Combine(delimitedList(Word(cpp_ident), delim='::'), joinString='::')('typename') + Optional(
        Literal('?')('optional') | Literal('!')('non_null')
    )
)

documentation = Optional(Combine(
    OneOrMore(
        Literal('///').suppress() + Regex(r"(\\\n|.)*")
    ),
    adjacent=False, joinString="\n"
))

method_argument = Group(
    documentation('documentation') +
    annotations('annotations') +
    Word(cpp_ident)('name') + Literal(':').suppress() +
    typename('type') + Optional(
        Literal('=') + Word(cpp_ident)('default_value')
    )
)

method_prototype = Group(
    documentation('documentation') +
    annotations('annotations') +
    typename('return') + Word(cpp_ident)('name') +
    Literal('(').suppress() + Optional(
        InterfaceDict(delimitedList(method_argument), param='name')('arguments')
    ) + Literal(')').suppress() +
    Optional(
        cpp_inline_code
    )('body') + optional_semicolon
)
constructor_prototype = Group(
    documentation('documentation') +
    annotations('annotations') +
    Literal('constructor').suppress() +
    Literal('(').suppress() + Optional(
        InterfaceDict(delimitedList(method_argument), param='name')('arguments')
    ) + Literal(')').suppress() +
    Optional(
        cpp_inline_code
    )('body') + optional_semicolon
)
destructor_prototype = Group(
    documentation('documentation') +
    annotations('annotations') +
    Literal('destructor').suppress() +
    Literal('()').suppress() +
    Optional(
        cpp_inline_code
    )('body') + optional_semicolon
)

method_list = (
    InterfaceDict(ZeroOrMore(method_prototype), param='name')
)

full_method_list = (
    ZeroOrMore(constructor_prototype)('constructors') +
    Optional(destructor_prototype('destructor')) +
    InterfaceDict(ZeroOrMore(method_prototype), param='name')('methods')
)

interface = Group(
    documentation('documentation') +
    annotations('annotations') +
    Literal('interface')('type') + Word(cpp_ident)('name') + Optional(extends_declaration)(
        'extends') + opening_bracket +
    full_method_list +
    closing_bracket + optional_semicolon
)
cls = Group(
    documentation('documentation') +
    annotations('annotations') +
    Literal('class')('type') + Word(cpp_ident)('name') + (Optional(extends_declaration))('extends') + (
        Optional(implements_declaration))('implements') + opening_bracket +
    full_method_list +
    closing_bracket + optional_semicolon
)

namespace_body = (
    InterfaceDict(ZeroOrMore(
        interface | cls
    ), param='name')
)
namespace = Group(
    annotations('annotations') +
    Literal('namespace')('type') + Combine(delimitedList(Word(cpp_ident), delim='::'), joinString='::')('name') +
    opening_bracket +
    namespace_body('content') +
    closing_bracket + optional_semicolon
)

definition = Group(
    Literal('def').suppress() + Word(cpp_ident)('name') + (
        Literal('true') | Literal('false') | QuotedString('"') | Word(nums)
    )('value') + optional_semicolon
)

definitions = InterfaceDict(ZeroOrMore(
    definition
), param='name')

syntax = Each(
    ZeroOrMore(import_decl)('imports') +
    definitions('definitions') +
    InterfaceDict(ZeroOrMore(
        interface | cls | namespace
    ), param='name')
)

with open('sample/sample.i') as f:
    c = f.read()

parsed = syntax.parseString(c, parseAll=True)
print parsed.dump()

class ParsedOutput:
    def __init__(self):
        pass


class Parser:
    def __init__(self):
        pass

    def parse(self, str):
        pass
