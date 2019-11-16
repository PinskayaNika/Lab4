package com.examples.testjs;

public class StoreMessage {
    private final String result;
    private final String expectedResult;
    private String cheker;
    private final Object[] param;
    private final String testName;

    public StoreMessage(String result, String expectedResult, String cheker,
                        Object[] param, String testName) {
        this.result = result;
        this.expectedResult = expectedResult;
        this.cheker = cheker;
        this.param = param;
        this.testName = testName;
    }

    public String getResult() {
        return result;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getCheker() {
        return cheker;
    }

    public Object[] getParam() {
        return param;
    }

    public String getTestName() {
        return testName;
    }
}
