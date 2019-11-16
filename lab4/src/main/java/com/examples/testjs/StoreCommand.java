package com.examples.testjs;

public class StoreCommand {
    private final int packageId;
    private final StoreMessage storageMessage;

    public StoreCommand(int index, StoreMessage storageMsg) {
        this.packageId =index;
        this.storageMessage = storageMsg;
    }

    public int getPackageId() {
        return packageId;
    }

    public StoreMessage getStorageMessage() {
        return storageMessage;
    }
}
