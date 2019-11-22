package com.examples.testjs;

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

    String getTestName() {
        return testName;
    }

    String getExpectedResult() {
        return expectedResult;
    }


    Object[] getParams() {
        return params;
    }

    public String getResult() {
        return result;
    }

    public String getChecker() {
        return checker;
    }
}
