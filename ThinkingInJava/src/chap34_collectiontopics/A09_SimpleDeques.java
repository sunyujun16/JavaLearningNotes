package chap34_collectiontopics;

// Very basic test of Deques

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

class CountString implements Supplier<String> {
    private int n = 0;

    CountString() {
    }

    CountString(int start) {
        n = start;
    }

    @Override
    public String get() {
        return Integer.toString(n++);
    }
}

class SimpleDeques {
    static void test(Deque<String> deque) {
        CountString s1 = new CountString(),
                s2 = new CountString(20);
        for (int n = 0; n < 8; n++) {
            deque.offerFirst(s1.get());
            deque.offerLast(s2.get()); // Same as offer()
        }
        System.out.println(deque);
        String result = "";
        while (deque.size() > 0) {
            System.out.print(deque.peekFirst() + " "); // peek只看不取.
            result += deque.pollFirst() + " "; // poll直接带走.
            System.out.print(deque.peekLast() + " ");
            result += deque.pollLast() + " ";
        }
        System.out.println("\n" + result);
    }

    public static void main(String[] args) {
        int count = 10;
        System.out.println("LinkedList");
        test(new LinkedList<>());
        System.out.println("ArrayDeque");
        test(new ArrayDeque<>());
        System.out.println("LinkedBlockingDeque");
        test(new LinkedBlockingDeque<>(count));
        System.out.println("ConcurrentLinkedDeque");
        test(new ConcurrentLinkedDeque<>());
    }
}

public class A09_SimpleDeques {
}
