package chap35_lowlevel;

import java.util.concurrent.*;

class SwallowedException {
    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            throw new RuntimeException();
        });
        exec.shutdown();
    }
}

public class A01_SwallowedException {
}
