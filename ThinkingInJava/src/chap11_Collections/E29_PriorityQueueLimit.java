package chap11_Collections;

import java.util.PriorityQueue;

class Empty {
}

public class E29_PriorityQueueLimit {
    public static void main(String[] args) {
        PriorityQueue<Object> pq = new PriorityQueue<>();
        pq.offer(new Empty());

        // Empty does not implement Comparable, Therefor, does not has any "priority".
//        pq.offer(new Empty());
//        pq.offer(new Empty());
    }

}
