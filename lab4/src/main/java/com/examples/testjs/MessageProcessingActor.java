package com.examples.testjs;


class MessageProcessingActor {
    private int packageId;

    MessageProcessingActor(int packageId) {
        this.packageId = packageId;
    }

    int getPackageId() {
        return packageId;
    }
}
