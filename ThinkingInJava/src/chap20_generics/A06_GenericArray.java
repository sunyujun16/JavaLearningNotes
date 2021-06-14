package chap20_generics;

class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);

        for (int i = 0; i < 10; i++)
            gai.put(i, i);
        for (int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println("\n");

        try {
            Integer[] ia = gai.rep(); // type already lost
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // 因为自始至终, 就从来没存过Integer类型的对象.
        // 其根源我猜啊, 在于数组层面上没有Integer的Class信息.
        System.out.println(gai.rep());
    }
}

public class A06_GenericArray {
}
