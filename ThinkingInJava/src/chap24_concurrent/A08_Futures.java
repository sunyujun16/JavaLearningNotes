package chap24_concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

class Futures {
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ExecutorService exec
                = Executors.newSingleThreadExecutor();

        Future<Integer> f =
                exec.submit(new CountingTask(99));

        System.out.println(f.get()); // [1] it waits.
        exec.shutdown();
    }
}

public class A08_Futures {
}
