package chap35_lowlevel;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

import onjava.Nap;

class Prioritized implements Comparable<Prioritized> {
    private static AtomicInteger counter =
            new AtomicInteger();
    private final int id = counter.getAndIncrement();
    private final int priority;
    private static List<Prioritized> sequence =
            new CopyOnWriteArrayList<>();

    Prioritized(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(Prioritized arg) {
        return priority < arg.priority ? 1 :  // 这次是"我小则我大"了.
                (priority > arg.priority ? -1 : 0);
    }

    @Override
    public String toString() {
        return String.format(
                "[%d] Prioritized %d", priority, id);
    }

    public void displaySequence() {
        int count = 0;
        for (Prioritized pt : sequence) {
            System.out.printf("(%d:%d)", pt.id, pt.priority);
            if (++count % 5 == 0)
                System.out.println();
        }
    }

    public static class EndSentinel extends Prioritized {
        EndSentinel() {
            super(-1);
        }
    }
}

class Producer implements Runnable {
    private static AtomicInteger seed =
            new AtomicInteger(47);
    private SplittableRandom rand =
            new SplittableRandom(seed.getAndAdd(10));
    private Queue<Prioritized> queue;

    Producer(Queue<Prioritized> q) {
        queue = q;
    }

    @Override
    public void run() {
        rand.ints(10, 0, 20)
                .mapToObj(Prioritized::new)
                .peek(p -> new Nap(rand.nextDouble() / 10))
                .forEach(p -> queue.add(p));
        queue.add(new Prioritized.EndSentinel());
    }
}

class Consumer implements Runnable {
    private PriorityBlockingQueue<Prioritized> q;
    private SplittableRandom rand =
            new SplittableRandom(47);

    Consumer(PriorityBlockingQueue<Prioritized> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Prioritized pt = q.take();
                System.out.println(pt);
                if (pt instanceof Prioritized.EndSentinel) {
                    pt.displaySequence();
                    break;
                }
                new Nap(rand.nextDouble() / 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        PriorityBlockingQueue<Prioritized> queue =
                new PriorityBlockingQueue<>();
        CompletableFuture.runAsync(new Producer(queue));
        CompletableFuture.runAsync(new Producer(queue));
        CompletableFuture.runAsync(new Producer(queue));
        CompletableFuture.runAsync(new Consumer(queue))
                .join();
        // Consumer不关心有几个-1, 只要找到-1就break.所以尽管有
        // 三个-1, 但只输出了第一个.
    }
}

public class A07_PriorityBlockingQueueDemo {
}
