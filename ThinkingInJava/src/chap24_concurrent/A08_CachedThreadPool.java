package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newCachedThreadPool();

        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);

        exec.shutdown();
    }
}

public class A08_CachedThreadPool {
}
