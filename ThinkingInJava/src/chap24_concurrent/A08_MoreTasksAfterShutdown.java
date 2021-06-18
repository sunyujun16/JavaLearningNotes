package chap24_concurrent;

import java.util.concurrent.*;

class MoreTasksAfterShutdown {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        exec.execute(new NapTask(1));
        exec.shutdown();
        try {
            exec.execute(new NapTask(99));
        } catch (RejectedExecutionException e) {
            System.out.println(e);
        }
    }
}

public class A08_MoreTasksAfterShutdown {
}
