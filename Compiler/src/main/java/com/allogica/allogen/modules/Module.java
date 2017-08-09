package com.allogica.allogen.modules;

import com.allogica.allogen.model.Class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Module implements Serializable {

    private List<Class> exportedClasses = new ArrayList<>();

    public Module() {
    }

    public Module(List<Class> exportedClasses) {
        this.exportedClasses = exportedClasses;
    }

    public List<Class> getExportedClasses() {
        return exportedClasses;
    }

    public Module setExportedClasses(List<Class> exportedClasses) {
        this.exportedClasses = exportedClasses;
        return this;
    }
}
