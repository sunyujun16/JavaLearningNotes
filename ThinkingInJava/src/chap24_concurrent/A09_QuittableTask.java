package chap24_concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import onjava.Nap;

class QuittableTask implements Runnable {
    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running =
            new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        int count = 0;
        while (running.get()){ // [1]
            new Nap(0.01);
            ++count;
            System.out.println(id + ": " + Thread.currentThread().getName());
        }
        System.out.print(id + " stop running at "+ count +" times.\n"); // [2]
    }

    // 自己加的
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        IntStream.range(0,9)
//                .parallel()
                .mapToObj(QuittableTask::new)
                .peek(es::execute)
                .peek(qt -> new Nap(0.04))
                .forEach(qt -> qt.quit());

        es.shutdown();


    }
}

public class A09_QuittableTask {
}
