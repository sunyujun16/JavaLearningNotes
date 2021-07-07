package chap35_lowlevel;

import java.util.stream.*;
import java.util.concurrent.*;

class ShowThread implements Runnable {
    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName());
    }
}

class WorkStealingPool {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(
                Runtime.getRuntime().availableProcessors());

        ExecutorService exec =
                Executors.newWorkStealingPool();

        IntStream.range(0, 10)
                .mapToObj(n -> new ShowThread())
                .forEach(exec::execute);

        exec.awaitTermination(1, TimeUnit.SECONDS);
    }
}

public class A01_WorkStealingPool {
}
