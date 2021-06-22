package chap24_concurrent;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

import onjava.Nap;

class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        List<QuittableTask> tasks =
                IntStream.range(1, COUNT)
                        .mapToObj(QuittableTask::new)
                        .peek(qt -> es.execute(qt))
                        .collect(Collectors.toList());
//        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}

public class A09_QuittingTasks {
}
