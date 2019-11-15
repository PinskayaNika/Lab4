package com.examples.testjs;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class TestJS {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("test");
        ActorRef storeActor = system.actorOf(Props.create(StoreActor.class)
        );
        storeActor.tell(
                new StoreActor.StoreMessage("test", "test"),
                ActorRef.noSender()
        );


        System.out.println("");
    }


    private
    return concat(
            get(
            () -> parameter(PACKAGE_ID)
    )
    )
}
