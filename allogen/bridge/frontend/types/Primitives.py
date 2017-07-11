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

from allogen.bridge.frontend.CompilerType import BuiltinType


class PrimitiveType(BuiltinType):
    def __init__(self, context, typename, **kwargs):
        super(BuiltinType, self).__init__(context, typename)
        self.__dict__.update(kwargs)

    def get_bridge_name(self):
            return self.bridge_type

    def get_target_name(self):
        return self.target_type

class VoidType(PrimitiveType):
    def get_bridge_name(self):
        return 'void'

    def get_target_name(self):
        return 'void'


class Int8Type(PrimitiveType):
    def get_bridge_name(self):
        return 'int8_t'

    def get_target_name(self):
        return 'int8_t'


class UInt8Type(PrimitiveType):
    def get_bridge_name(self):
        return 'uint8_t'

    def get_target_name(self):
        return 'uint8_t'


class Int16Type(PrimitiveType):
    def get_bridge_name(self):
        return 'int16_t'

    def get_target_name(self):
        return 'int16_t'


class UInt16Type(PrimitiveType):
    def get_bridge_name(self):
        return 'uint16_t'

    def get_target_name(self):
        return 'uint16_t'


class Int32Type(PrimitiveType):
    def get_bridge_name(self):
        return 'int32_t'

    def get_target_name(self):
        return 'int32_t'


class UInt32Type(PrimitiveType):
    def get_bridge_name(self):
        return 'uint32_t'

    def get_target_name(self):
        return 'uint32_t'


class Int64Type(PrimitiveType):
    def get_bridge_name(self):
        return 'int64_t'

    def get_target_name(self):
        return 'int64_t'


class UInt64Type(PrimitiveType):
    def get_bridge_name(self):
        return 'uint64_t'

    def get_target_name(self):
        return 'uint64_t'
