package com.allogica.allogen.util;

import com.allogica.allogen.types.Type;

import java.util.ArrayList;
import java.util.List;

public class TypeUtils {

    public static List<Type> getAllDependantTypes(Type type) {
        List<Type> types = new ArrayList<>();
        types.add(type);
        for(final Type t : type.getDependantTypes()) {
            types.add(t);
            types.addAll(getAllDependantTypes(t));
        }
        return types;
    }

}
