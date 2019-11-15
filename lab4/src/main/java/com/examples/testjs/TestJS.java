package com.examples.testjs;

import akka.Main;
import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.CompletionStage;

public class TestJS {
    static ActorRef storeActor;
    private static final String LOCALHOST = "localhost:";
    private static final String SERVER_INFO = "Server online at http://localhost:8080/\\nPress RETURN to stop...";
    private static final int SERVER_PORT = 8080;
    TIMEOUT_MILLsERVER_PORT = 8080;

    public static void main(String[] args) throws Exception {
        //Инициализация сервера
        ActorSystem system = ActorSystem.create("routes");
        ActorRef storeActor = system.actorOf(Props.create(StoreActor.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        JSAkkaTester app = new JSAkkaTester();

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                app.jsTesterRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(LOCALHOST, ),
                materializer
                );

        System.out.println(SERVER_INFO);
        System.in.read();

        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());



//        storeActor.tell(
//                new StoreActor.StoreMessage("test", "test"),
//                ActorRef.noSender()
//        );
//
//
//        System.out.println("");
//    }


    private Route jsTesterRoute() {
        get (
                () -> parameter(PAKAGE_ID, (pachageId) ->
                {
                }
        })
        ),
    post (
            () -> entyty()
    )
    )
}
