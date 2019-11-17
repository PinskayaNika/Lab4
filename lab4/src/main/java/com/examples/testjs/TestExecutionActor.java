package com.examples.testjs;

//актор который исполняет один тест из пакета.
//   Для исполнения JS кода можно воспользоваться следующим примером
//ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
//engine.eval(jscript);
//Invocable invocable = (Invocable) engine;
//return invocable.invokeFunction(functionName, params).toString();

//После исполнения теста результат передается актору хранилищу

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestExecutionActor {

    private static final String EXPECTED_RESULT = "expectedResult";
    private static final String PARAMS = "params";
    private static final String TEST_NAME = "testName";
    private static final String EMPTY_RESULT = "NONE";
    private static final String EMPTY_CHECKER = "NOT READY YET";


    private final String expectedResult;
    private final Object[] params;
    private final String testName;
    private String result;
    private String checker;

    @JsonCreator
    public TestExecutionActor(@JsonProperty(TEST_NAME) String testName,
                              @JsonProperty(EXPECTED_RESULT) String expectedResult,
                              @JsonProperty(PARAMS) Object[] params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
        this.result = EMPTY_RESULT;
        this.checker = EMPTY_CHECKER;
    }

    public static String getTestName() {
        return TEST_NAME;
    }

    public static String getExpectedResult() {
        return EXPECTED_RESULT;
    }


    public Object[] getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    


}
