package common.practice.jmm;

public class VolatileVisibilityExperiment {

    private static boolean flagNonVolatile = true;
    private static volatile boolean flagVolatile = true;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test without volatile");
        testNonVolatile();

        Thread.sleep(2000);

        System.out.println("Test with volatile");
        testVolatile();
    }

    private static void testNonVolatile() throws InterruptedException {
        flagNonVolatile = true;

        Thread thread = new Thread(() -> {
            while (flagNonVolatile) {

            }
            System.out.println("Thread stopped (non-volatile)");
        });

        thread.start();
        Thread.sleep(1000);
        flagNonVolatile = false;
        System.out.println("Flag set to false (non-volatile)");

        thread.join(2000);

        if (thread.isAlive()) {
            System.out.println("ERROR: Thread still running (non-volatile)");
        }
    }

    private static void testVolatile() throws InterruptedException {
        flagVolatile = true;

        Thread thread = new Thread(() -> {
            while (flagVolatile) {

            }
            System.out.println("Thread stopped (volatile)");
        });

        thread.start();
        Thread.sleep(1000);
        flagVolatile = false;
        System.out.println("Flag set to false (volatile)");

        thread.join(2000);

        if (thread.isAlive()) {
            System.out.println("ERROR: Thread still running (volatile)");
        }
    }
}
