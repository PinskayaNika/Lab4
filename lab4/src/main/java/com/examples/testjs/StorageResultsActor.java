package com.examples.testjs;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StorageResultsActor extends AbstractActor {
    private HashMap<Integer, ArrayList<StoreMessage>> store = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageProcessingActor.class, req ->
                    getSender().tell(
                            store.get(req.getPackageId()).toArray(),
                            ActorRef.noSender()
                    )
                )
                .match(StoreComand.class, msg -> {
                    if (store.containsKey(msg.getPackageId())) {
                        ArrayList<StoreMessage> tests = store.get(msg.getPackageId());
                        tests.add(msg.getStireMessage());
                        store.put(msg.getPackageId(), tests);
                    } else {
                    sender().tell(
                                new MessageProcessingActor(msg.getKey(), store.get(req.getKey())), self())
                    }
        ).build();
    }
}