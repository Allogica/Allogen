package com.allogica.allogen.model;

import com.allogica.allogen.idl.model.IDLMethod;

import java.sql.Struct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InheritedMethod extends ModelObject {

    private Method method;

    public InheritedMethod(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public String getName() {
        return method.getName();
    }

    public void setName(String name) {
        method.setName(name);
    }

    public TypeName getReturnType() {
        return method.getReturnType();
    }

    public Method setReturnType(TypeName returnType) {
        return method.setReturnType(returnType);
    }

    public List<MethodArgument> getArguments() {
        return method.getArguments();
    }

    public void setArguments(List<MethodArgument> arguments) {
        method.setArguments(arguments);
    }

    public String getBody() {
        return method.getBody();
    }

    public Method setBody(String body) {
        return method.setBody(body);
    }

    public IDLMethod getIdlMethod() {
        return method.getIdlMethod();
    }

    public Method setIdlMethod(IDLMethod idlMethod) {
        return method.setIdlMethod(idlMethod);
    }

    public boolean isStatic() {
        return method.isStatic();
    }

    public Method setStatic(boolean aStatic) {
        return method.setStatic(aStatic);
    }

    public <T> T getAttribute(String name) {
        T attribute = super.getAttribute(name);
        if(attribute != null) return attribute;
        return method.getAttribute(name);
    }

    public Map<String, Object> getAttributes() {
        final Map<String, Object> attributes = new HashMap<>(method.getAttributes());

        for(Map.Entry<String, Object> entry : super.getAttributes().entrySet()) {
            attributes.put(entry.getKey(), entry.getValue());
        }

        return attributes;
    }

}
