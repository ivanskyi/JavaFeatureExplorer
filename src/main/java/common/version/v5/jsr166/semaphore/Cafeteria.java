package common.version.v5.jsr166.semaphore;

import java.util.concurrent.Semaphore;

public class Cafeteria {

    public static void main(String[] args) {
        runCafeteriaDay();
    }

    private static void runCafeteriaDay() {
        Semaphore cafeteriaVisitorCapacity = new Semaphore(2);
        for (int i = 1; i <= 10; i++) {
            final int visitorId = i;
            new Thread(() -> {
                try {
                    cafeteriaVisitorCapacity.acquire();
                    System.out.println("Visitor " + visitorId + " entered the cafeteria.");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println("Visitor " + visitorId + " left the cafeteria.");
                    cafeteriaVisitorCapacity.release();
                }
            }).start();
        }
    }
}
