package chap24_concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

class CachedThreadPool3 {
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec =
                Executors.newCachedThreadPool();

        List<CountingTask> tasks =
                IntStream.range(0, 10)
                        .mapToObj(CountingTask::new)
                        .collect(Collectors.toList());

        List<Future<Integer>> futures =
                exec.invokeAll(tasks); // 所有任务完成后, 一起返回列表

        Integer sum = futures.stream()
                .map(CachedThreadPool3::extractResult)
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}

public class A08_CachedThreadPool3 {
}
