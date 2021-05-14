package chap12_collections;

// Anything Iterable works with for-in

import java.util.*;

public class A13_IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " +
            "we know the Earth to be banana-shaped."
    ).split(" ");

    // 首先覆写Iterable中的iterator方法, 返回Iterator接口的实现对象.
    @Override
    public Iterator<String> iterator() {
        // 而返回实现对象时, 所采用的这个匿名内部类, 又要覆写Iterator接口的方法,以实现Iterator具体功能.
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new A13_IterableClass())
            System.out.print(s + " ");
    }
}
