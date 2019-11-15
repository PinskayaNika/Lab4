package com.examples.testjs;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;

public class TestJS {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("routes");
        ActorRef storeActor = system.actorOf(Props.create(StoreActor.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);




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
