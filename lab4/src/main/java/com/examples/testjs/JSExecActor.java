package com.examples.testjs;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.Pair;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSExecActor extends AbstractActor {
    private static final String JS_ENGINE = "nashorn";
    private static final String WRONG_ANSWER = "WRONG ANSWER!";
    private static final String CORRECT_ANSWER = "CORRECT ANSWER!";

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(ExecuteMessage.class, m -> {
                    Pair<Integer, FunctionPackage> msg = m.getMsg();
                    int index = msg.getKey();
                    FunctionPackage functionPackage = msg.getValue();
                    TestExecutionActor test = functionPackage.getTests()[index];
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName(JS_ENGINE);
                    try {
                        engine.eval(functionPackage.getJsScript());
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }

                    Invocable invocable = (Invocable) engine;
                    String res = invocable.invokeFunction(functionPackage.getFunctionName(),
                            test.getParams()).toString();

                    String check = WRONG_ANSWER;
                    if (res.equals(test.getExpectedResult())) {
                        check = CORRECT_ANSWER;
                    }

                    StoreMessage storeMessage = new StoreMessage(
                            res, test.getExpectedResult(), check,
                            test.getParams(), test.getTestName()
                    );
                    StoreCommand storeCommand = new StoreCommand(functionPackage.getPackageId(),
                            storeMessage);
                    getSender().tell(storeCommand, ActorRef.noSender());
                }).build();
    }
}