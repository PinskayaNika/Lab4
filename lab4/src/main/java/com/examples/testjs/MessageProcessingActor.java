package com.examples.testjs;

//актор который хранит результаты тестов.
//   Обрабатывает следующие сообщения :
//   cообщение с результатом одного теста -> кладет его в локальное хранилище.
//   Сообщение с запросом результата теста → отвечает сообщением с     результатом всех тестов для заданного  packageId

public class MessageProcessingActor {
    private int packageId;

    public MessageProcessingActor(int packageId) {
        this.packageId = packageId;
    }

    public int getPackageId() {
        return packageId;
    }
}
