package chap12_collections;

import java.util.PriorityQueue;
import java.util.Random;

public class E28_PriorityQueue {
    public static void main(String[] args) {
        Random rand = new Random(47);
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            pq.offer(rand.nextDouble());
        }
        while (pq.peek() != null) {
            System.out.println(pq.poll());
        }
    }

}
