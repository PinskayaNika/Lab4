package com.examples.testjs;

import javafx.util.Pair;

public class ExecuteMesage {
    private Pair<Integer, FunctionPackage> msg;

    public ExecuteMesage(int a, FunctionPackage functionPackage) {
        this.msg = new Pair<>(a, functionPackage);
    }

    public Pair<Integer, FunctionPackage> getMsg() {
        return this.msg;
    }
}
