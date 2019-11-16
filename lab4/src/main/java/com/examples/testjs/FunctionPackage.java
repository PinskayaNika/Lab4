package com.examples.testjs;

import akka.actor.ActorRef;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionPackage {
    private static final String PACKAGE_ID = "packageId";
    private static final String JS_SCRIPT = "Script";
    private static final String FUNCTION_NAME = "functionName";
    private static final String TESTS = "functionName";

    private final int packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    @JsonCreator
    public FunctionPackage(@JsonProperty(PACKAGE_ID) String packageId,
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

    public Test[] getTests() {
        return tests;
    }

    public Test getTests(int i) {
        return tests[i];
    }
}
