package chap12_collections;

import java.util.ArrayList;

// Holds a sequence of Objects
interface Selector {
    boolean end();

    Object current();

    void next();
}

public class E03_Sequence {
    private ArrayList<Object> items;
    private int length = 0;

    private E03_Sequence() {
        items = new ArrayList<Object>();
    }

    private void add(Object x) {
        items.add(x);
        length++;
    }

    // 相当于实现一个自定义的迭代器接口. 只是没有系统的迭代器接口更通用且直接地支持forEach语法.
    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == length;
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < length) i++;
        }
    }

    private Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        E03_Sequence es = new E03_Sequence();

        for (int i = 0; i < 16; i++)
            es.add(Integer.toString(i));

        Selector selector = es.selector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}


