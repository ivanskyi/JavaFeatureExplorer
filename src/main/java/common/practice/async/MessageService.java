package common.practice.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageService {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public String loadGreeting() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("We got an error");
                Thread.currentThread().interrupt();
            }
            return "Hello";
        }, executor);

        return future.join();
    }
}
