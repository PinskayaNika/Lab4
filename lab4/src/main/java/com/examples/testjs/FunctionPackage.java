package com.examples.testjs;

import akka.actor.ActorRef;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionPackage {
    private static final String PACKAGE_ID = "packageId";
    private static final String JS_SCRIPT = "jsScript";
    private static final String FUNCTION_NAME = "functionName";
    private static final String TESTS = "tests";

    private final int packageId;
    private final String jsScript;
    private final String functionName;
    private final TestExecutionActor[] tests;

    @JsonCreator
    public FunctionPackage(@JsonProperty(PACKAGE_ID) String packageId,
                           @JsonProperty(JS_SCRIPT) String jsScript,
                           @JsonProperty(FUNCTION_NAME) String functionName,
                           @JsonProperty(TESTS) TestExecutionActor[] tests) {
        this.packageId = Integer.parseInt(packageId);
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    String getJsScript() {
        return jsScript;
    }

    int getPackageId() {
        return packageId;
    }

    String getFunctionName() {
        return functionName;
    }

    TestExecutionActor[] getTests() {
        return tests;
    }

    public TestExecutionActor getTests(int i) {
        return tests[i];
    }
}
