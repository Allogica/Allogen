# Copyright (c) 2017, Allogica
#
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without modification,
# are permitted provided that the following conditions are met:
#
#     * Redistributions of source code must retain the above copyright notice,
#       this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above copyright notice,
#       this list of conditions and the following disclaimer in the documentation
#       and/or other materials provided with the distribution.
#     * Neither the name of Allogen nor the names of its contributors
#       may be used to endorse or promote products derived from this software
#       without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
# NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

from allogen.codegen.Constructs import *

my_class = Class(
    name="MyClass", documentation='My Class\n\nIt does many things!',
    parents=['A', 'B', 'C', 'D'],
    members=[
        Enumeration(name='Kind', documentation='A file kind enumeration type', definitions=[
            EnumerationDefinition(name='FILE', documentation='The object represents a File', value=1),
            EnumerationDefinition(name='DIRECTORY', documentation='The object represents a Directory'),
            EnumerationDefinition(name='WITH_UNDERSCORES', documentation='A enum definition with underscores'),
            EnumerationDefinition(name='OTHER', documentation='The object represents another kind of object'),
        ]),

        Class(
            name="NestedClass", documentation='A nested class!',
            members=[
                Field(name="nestedField", type="uint32_t", default_value="100", documentation='A documented field!'),
                Class(
                    name="AnotherNestedClass", documentation='A nested class!',
                    members=[
                        Field(name="nestedFieldInsideTheSuperNestedClass", type="uint32_t", default_value="100",
                              documentation='A documented field!'),
                    ]
                ),
            ]
        ),

        Field(name="myField", type="uint32_t", default_value="100", documentation='A documented field!'),

        Constructor(documentation='Creates a new MyClass object', args=[
            MethodArgument(name="param1", type="uint32_t", documentation='the param 1'),
            MethodArgument(name="param2", type="uint32_t", documentation='the param 2', default_value=100)
        ], initializers=[
            'param1', ConstructorInitializer('param2')
        ], body=[Raw('return;')]),

        Destructor(documentation='Destroys a MyClass object', trivial=True, body=[Raw('// do something')]),

        Method(name="setField", inline=True, ret="void", documentation='A documented method with arguments', args=[
            MethodArgument(name="newValue", type=TypeName("uint32_t", reference=True, const=True), documentation='the new value to be set')
        ], body=[
            Assignment(expression="newValue", to="myField")
        ], force_visibility_change=True),
        Method(name="getField", const=True, ret=TypeName("uint32_t", const=True, reference=True), body=[
            Return("myField")
        ], documentation='A documented method without arguments',
               ret_documentation='the field value as a 32 bit integer'),

        Method(name="executeThing", ret="void", documentation='A documented method with arguments', args=[
            MethodArgument(name="param1", type="uint32_t", documentation='the param 1'),
            MethodArgument(name="param2", type="uint32_t", documentation='the param 2')
        ], body=[
            Comment('if params are equal return,\nif not, assign param1 to myField', multiline=True),
            If(conditions=EqualComparisonOperator(a='param1', b='param2'), then_expr=[
                Return()
            ], else_expr=[
                Assignment(expression='param1', to='myField')
            ]),
            Assignment(expression='param1', to='myField')
        ]),
    ]
)

ns = Namespace(name='Allogica', content=[Namespace(name='MyNamespace', content=[my_class])])
