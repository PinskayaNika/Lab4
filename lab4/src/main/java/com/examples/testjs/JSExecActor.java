package com.examples.testjs;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;

public class JSExecActor {

    @Override
    public AbstractActor.Receive createReceive() {
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
                                tests.add(msg.getStorageMessage());
                                store.put(msg.getPackageId(), tests);
                            } else {
                                ArrayList<StoreMessage> tests = new ArrayList<>();
                                tests.add(msg.getStorageMessage());
                                store.put(msg.getPackageId(), tests);
                            }
                        }
                ).build();
    }
}
