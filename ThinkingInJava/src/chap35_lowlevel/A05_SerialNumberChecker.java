package chap35_lowlevel;

// Test SerialNumbers implementations for thread-safety

import java.util.concurrent.*;

import onjava.Nap;

class SerialNumberChecker implements Runnable {
    private CircularSet serials = new CircularSet(1000);
    private SerialNumbers producer;

    public SerialNumberChecker(SerialNumbers producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            int serial = producer.nextSerialNumber();
            new Nap(0.1); // 阻塞是为了更容易发生...错误的结果
            if (serials.contains(serial)) {
                System.out.println("Duplicate: " + serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    static void test(SerialNumbers producer) {
        for (int i = 0; i < 10; i++)
            CompletableFuture.runAsync(
                    new SerialNumberChecker(producer));
        new Nap(4, "No duplicates detected");
    }
}

public class A05_SerialNumberChecker {
}
