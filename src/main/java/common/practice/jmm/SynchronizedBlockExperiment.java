package common.practice.jmm;

public class SynchronizedBlockExperiment {

    private final String lock = "LOCK";
    private int counter = 0;

    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        var demo = new SynchronizedBlockExperiment();

        var firstThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo.increment();
            }
        });

        var secondThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo.increment();
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("Final counter value: " + demo.getCounter());
    }
}
