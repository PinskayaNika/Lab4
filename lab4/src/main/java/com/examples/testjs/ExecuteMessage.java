package com.examples.testjs;

import javafx.util.Pair;

class ExecuteMessage {
    private Pair<Integer, FunctionPackage> msg;

    ExecuteMessage(int a, FunctionPackage functionPackage) {
        this.msg = new Pair<>(a, functionPackage);
    }//После исполнения теста результат передается актору хранилищу

    Pair<Integer, FunctionPackage> getMsg() {
        return this.msg;
    }
}
