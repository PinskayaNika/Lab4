package com.examples.testjs;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class StoreActor extends AbstractActor {
    private final static int NUM_ROUND_ROBIN_POOL = 5;  //показывает сколько executors может быть создано

    private final ActorRef executors;  //максимально может быть создано NUM_ROUND_ROBIN_POOL раз
    private final ActorRef storage;  //может быть только 1

    public StoreActor() {
        executors = getContext().actorOf(new RoundRobinPool(NUM_ROUND_ROBIN_POOL)
                .props(Props.create(JSExecActor.class)))
    }
}
