package chap12_collections;

import java.util.*;
//import suntemp.*;

public class A11_PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>();
        Random rand = new Random(47);

        for (int i = 0; i < 10; i++)
            priorityQueue.offer(rand.nextInt(i + 10));
        A11_QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20,
                18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        A11_QueueDemo.printQ(priorityQueue);

        priorityQueue = new PriorityQueue<>(
                ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        A11_QueueDemo.printQ(priorityQueue); // reversed

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings =
                Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ =
                new PriorityQueue<>(strings);
        A11_QueueDemo.printQ(stringPQ);

        stringPQ = new PriorityQueue<>(
                strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        A11_QueueDemo.printQ(stringPQ);

        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray())
            charSet.add(c); // Autoboxing
        PriorityQueue<Character> characterPQ =
                new PriorityQueue<>(charSet);
        A11_QueueDemo.printQ(characterPQ);
    }
}

