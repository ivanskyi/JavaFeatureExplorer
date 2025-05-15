package common.version.v24.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VirtualThreadMessageProducer {

    public Queue<String> getQueueWithMessages() {
        Queue<String> queueWithMessages = new ConcurrentLinkedQueue<>();
        List<Thread> threads = new ArrayList<>(1000);

        for (int i = 0; i < 1000; i++) {
            int id = i;
            Thread thread = Thread.startVirtualThread(() -> queueWithMessages.add("Thread " + id));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted while waiting for completion", e);
            }
        }

        return queueWithMessages;
    }
}
