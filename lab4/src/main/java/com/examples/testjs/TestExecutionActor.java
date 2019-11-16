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

    private static final String EXPECTED_RESULT "expectedResult"
    private static final String PARAMS = "params";
    private static final String TEST_NAME = "testName";
    private static final String EMPTY_RESULT = "NONE";
    private static final String EMPTY_RESULT = "NONE";


    private final int packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    @JsonCreator
    public TestExecutionActor(@JsonProperty(PACKAGE_ID) String packageId,
                              @JsonProperty(JS_SCRIPT) String jsScript,
                              @JsonProperty(FUNCTION_NAME) String functionName,
                              @JsonProperty(TESTS) Test[] tests) {
        this.packageId = Integer.parseInt(packageId);
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public String getJsScript() {
        return jsScript;
    }

    public int getPackageId() {
        return packageId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public TestExecutionActor[] getTests() {
        return tests;
    }

    public TestExecutionActor getTests(int i) {
        return tests[i];
    }
}
