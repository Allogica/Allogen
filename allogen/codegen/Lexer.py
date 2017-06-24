from pyparsing import *

class InterfaceDict(TokenConverter):
    """Converter to return a repetitive expression as a list, but also as a dictionary.
       Each element can also be referenced using the first token in the expression as its key.
       Useful for tabular report scraping when the first column can be used as a item key.
    """

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


opening_bracket = Literal("{").suppress()
closing_bracket = Literal("}").suppress()
type_delimiter = Literal(":").suppress()
optional_semicolon = Optional(Literal(';')).suppress()

hex_id = (Literal('<').suppress() + Word(alphanums) + Literal('>').suppress())

docstring = Optional(Literal('///').suppress() + Regex(r"(\\\n|.)*").setName("// comment"))

typename = Word(alphanums + "<>:,_*")
cpp_identifier = Word(alphanums + "<>:,")

field_default_value = Literal('=') + cpp_identifier("default_value")
fields = InterfaceDict(ZeroOrMore(
    Group(docstring("docstring") + Word(alphanums)("field_name") + type_delimiter + typename("field_type") + Optional(
        field_default_value) + optional_semicolon)), param='field_name')

serialization_decl = Group(
    Keyword('serialization') + commaSeparatedList(',') +
    optional_semicolon
)

return_decl = Group(
    (typename("return_type"))("type") |
    (Literal('{').suppress() + fields("fields") + Optional(serialization_decl)('serialization') + Literal(
        '}').suppress())("body")
)

operation = Group(
    docstring("docstring") +

    Optional(Literal('optional'))("optional") +
    return_decl("return_type") +
    Word(alphanums)("name") + Optional(hex_id)("id") +
    Literal("(").suppress() + (
        fields("fields") +
        Optional(serialization_decl('serialization'))
    )
    + Literal(")") + optional_semicolon
)

extension = Group(
    Keyword('extension').suppress() + Word(alphanums)("to") + opening_bracket +
    ZeroOrMore(operation)("operations") +
    closing_bracket + optional_semicolon
)

interface = Group(
    docstring("docstring") +
    Keyword('interface').suppress() + Word(alphanums)("name") + hex_id +
    Optional(Literal('extends') + Word(alphanums)("parent_name")) +
    opening_bracket +
    fields("fields") +
    InterfaceDict(ZeroOrMore(extension), param='to')("extension") +
    InterfaceDict(ZeroOrMore(operation), param='name')("operations") +
    closing_bracket + optional_semicolon
)

syntax = Each([
    InterfaceDict(ZeroOrMore(interface), param='name')("interfaces")
])


def parse(str):
    return syntax.parseString(str)
