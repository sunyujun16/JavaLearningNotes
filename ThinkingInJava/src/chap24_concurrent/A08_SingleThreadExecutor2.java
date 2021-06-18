package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

class SingleThreadExecutor2 {
    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();

        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);

        exec.shutdown();
    }
}

public class A08_SingleThreadExecutor2 {
}
