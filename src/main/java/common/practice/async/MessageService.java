package common.practice.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class MessageService {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public String getGreetingUsingRunAsync() {
        AtomicReference<String> loadedGreeting = new AtomicReference<>();

        CompletableFuture<Void> greetingLoader = CompletableFuture.runAsync(()
                -> loadedGreeting.set("Hello from async greeting loader")
        );
        greetingLoader.join();

        return loadedGreeting.get();
    }

    public String getGreetingUsingSupplyAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello", executor);
        return future.join();
    }

    public String getGreetingUsingThenApply() {
        CompletableFuture<String> greetingLoader = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> fullGreeting = greetingLoader
                .thenApply(greeting -> greeting + " Developer");

        return fullGreeting.join();
    }

    public String getGreetingUsingThenAccept() {
        AtomicReference<String> result = new AtomicReference<>();

        CompletableFuture<String> greetingLoader = CompletableFuture.supplyAsync(() -> "Hello");
        greetingLoader.thenAccept(result::set);

        return result.get();
    }
}
