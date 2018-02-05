package com.allogica.allogen.backend.embind;

import com.allogica.allogen.Compiler;
import com.allogica.allogen.CompilerContext;
import com.allogica.allogen.backend.AbstractCompilerBackend;
import com.allogica.allogen.model.Class;
import com.allogica.allogen.model.Constructor;
import com.allogica.allogen.model.Method;
import com.allogica.allogen.model.Property;

import java.net.URL;

public class EmbindBackend extends AbstractCompilerBackend {

    @Override
    public URL getTargetTemplateURL() {
        return null;
    }

    @Override
    public String getTargetOutputFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return null;
    }

    @Override
    public URL getBridgeTemplateURL() {
        return EmbindBackend.class.getResource("BridgeTemplate.stg");
    }

    @Override
    public String getBridgeOutputHeaderFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return null;
    }

    @Override
    public String getBridgeOutputImplementationFile(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        return compilerContext.getBridgePath(clazz.getNamespaces(), clazz.getName()) + "+Embind.cpp";
    }

    @Override
    public void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz) {
        clazz.setAttribute("emName", clazz.getName());
        clazz.setAttribute("emBindingsName", clazz.getName());

        for(Property property: clazz.getProperties().values()) {
            property.setAttribute("emName", property.getName());
        }

        int id = 0;
        for(Constructor constructor : clazz.getConstructors()) {
            constructor.setAttribute("emID", id);
            id++;
        }
    }

    @Override
    public void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Method method) {
        method.setAttribute("emName", method.getName());
    }

//    @Override
//    public void handle(Compiler<?, ?> compiler, CompilerContext compilerContext, Class clazz, Property property) {
//        clazz.setAttribute("emName", property.getName());
//    }

}
