package com.examples.testjs;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class StorageResultsActor extends AbstractActor {
    private Map<String, String> store = new HashMap<>();
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageProcessingActor.class, m -> {
                    store.put(m.getKey(), m.getValue());
                    System.out.println("receive message! " + m.toString());
                })
                .match(MessageProcessingActor.class, req -> sender().tell(
                        new MessageProcessingActor(req.getKey(), store.get(req.getKey())), self())
        ).build();
    }
}