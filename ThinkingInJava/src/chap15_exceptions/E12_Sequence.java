package chap15_exceptions;

// Holds a sequence of Objects
interface Selector {
    boolean end();

    Object current();

    void next();
}

/** @noinspection WeakerAccess*/
public class E12_Sequence {
    private Object[] items;
    private int next = 0;

    E12_Sequence(int size) {
        items = new Object[size];
    }

    private void add(Object x) {
        if (next < items.length)
            items[next++] = x;
        else
            throw new ArrayIndexOutOfBoundsException("出界了兄dei.");
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
        E12_Sequence e12Sequence = new E12_Sequence(10);

        try{
            for (int i = 0; i < 11; i++)
                e12Sequence.add(Integer.toString(i));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception caught: ");
            e.printStackTrace(System.out);

            Selector selector = e12Sequence.selector();

            while (!selector.end()) {
                System.out.print(selector.current() + " ");
                selector.next();
            }
        }

    }
}

