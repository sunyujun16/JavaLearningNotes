package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

class SingleThreadExecutor3 {
    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();

        IntStream.range(0, 10)
                .mapToObj(InterferingTask::new)
                .forEach(exec::execute);

        exec.shutdown();
    }
}

public class A08_SingleThreadExecutor3 {
}
