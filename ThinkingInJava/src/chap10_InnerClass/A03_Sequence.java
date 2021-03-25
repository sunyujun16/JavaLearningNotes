package chap10_InnerClass;

// Holds a sequence of Objects
interface Selector {
    boolean end();

    Object current();

    void next();
}

public class A03_Sequence {
    private Object[] items;
    private int next = 0;

    private A03_Sequence(int size) {
        items = new Object[size];
    }

    private void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    private Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        A03_Sequence a03Sequence = new A03_Sequence(10);

        for (int i = 0; i < 10; i++)
            a03Sequence.add(Integer.toString(i));

        Selector selector = a03Sequence.selector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

