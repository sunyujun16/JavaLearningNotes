package chap23_annotations;

import java.util.*;

public class StackL<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T v) {
        list.addFirst(v);
    }

    public T top() {
        return list.getFirst();
    }

    public T pop() {
        return list.removeFirst();
    }
}
