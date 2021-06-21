package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

import onjava.*;

class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newSingleThreadExecutor(); // 单独新线程而非主线程.

        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::execute);

        System.out.println("All tasks submitted");
        exec.shutdown(); //关门, 门内的接着奏乐接着舞.

        while (!exec.isTerminated()) {
            System.out.println(
                    Thread.currentThread().getName() +
                            " awaiting termination");
            new Nap(0.1);
        }
    }
}

public class A08_SingleThreadExecutor {
}
