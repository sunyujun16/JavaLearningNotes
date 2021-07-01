package chap34_collectiontopics;

// Compares basic behavior

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

class QueueBehavior {
    static Stream<String> strings() {
        return Arrays.stream(
                ("one two three four five six seven " +
                        "eight nine ten").split(" "));
    }

    static void test(int id, Queue<String> queue) {
        System.out.print(id + ": ");
        strings().map(queue::offer).forEach(x->{});
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int count = 10;
        test(1, new LinkedList<>());
        test(2, new PriorityQueue<>()); // 显然和Comparable有关.
        test(3, new ArrayBlockingQueue<>(count));
        test(4, new ConcurrentLinkedQueue<>());
        test(5, new LinkedBlockingQueue<>());
        test(6, new PriorityBlockingQueue<>());
        test(7, new ArrayDeque<>());
        test(8, new ConcurrentLinkedDeque<>());
        test(9, new LinkedBlockingDeque<>());
        test(10, new LinkedTransferQueue<>());
        test(11, new SynchronousQueue<>()); // 阻塞队列,
    }
}

public class A09_QueueBehavior {
}
