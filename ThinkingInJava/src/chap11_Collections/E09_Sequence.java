package chap11_Collections;

import java.util.*;

public class E09_Sequence {
    private ArrayList items;
    private int length = 0;

    private E09_Sequence() {
        items = new ArrayList();
    }

    private void add(Object x) {
        items.add(x);
        length++;
    }

    private class SequenceSelector implements Iterable {
        private int i = 0;

        @Override
        public Iterator iterator() {
            return new Iterator() {
                @Override
                public boolean hasNext() {
                    return i < length;
                }

                @Override
                public Object next() {
                    return items.get(i++);
                }
            };
        }
    }

    private SequenceSelector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        E09_Sequence es = new E09_Sequence();

        for (int i = 0; i < 16; i++)
            es.add(Integer.toString(i));

        Iterator selector = es.selector().iterator();

        while (selector.hasNext()) {
            System.out.print(selector.next() + " ");
        }
    }
}
