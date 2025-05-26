package common.practice.jmm;

public class SynchronizedExperiment {

    private int sharedCounter = 0;

    public synchronized void increment() {
        sharedCounter++;
    }

    public int getSharedCounter() {
        return sharedCounter;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExperiment experiment = new SynchronizedExperiment();

        Thread firstWorker = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                experiment.increment();
            }
        });

        Thread secondWorker = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                experiment.increment();
            }
        });

        Thread thirdWorker = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                experiment.increment();
            }
        });

        firstWorker.start();
        secondWorker.start();
        thirdWorker.start();

        firstWorker.join();
        secondWorker.join();
        thirdWorker.join();

        System.out.println("Final counter value: " + experiment.getSharedCounter());
    }
}
