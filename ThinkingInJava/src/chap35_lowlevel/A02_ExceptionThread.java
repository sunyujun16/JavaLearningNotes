package chap35_lowlevel;

// {ThrowsException}

import java.util.concurrent.*;

class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
        es.shutdown();
    }
}

public class A02_ExceptionThread {
}
