package com.examples.testjs;

class StoreCommand {
    private final int packageId;
    private final StoreMessage storageMessage;

    StoreCommand(int index, StoreMessage storageMsg) {
        this.packageId =index;
        this.storageMessage = storageMsg;
    }

    int getPackageId() {
        return packageId;
    }

    StoreMessage getStorageMessage() {
        return storageMessage;
    }
}
