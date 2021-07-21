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
            System.out.print(gai.get(i) + " "); // 能打印, 对象毕竟还是存在.
        System.out.println("\n");

        // 但是array其实是Object[]类型的, 你尝试用Integer接收, 不得行.
        try {
            Integer[] ia = gai.rep(); // type already lost
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // 自始至终, 就从来没存过Integer类型的对象.
        System.out.println(gai.rep());
    }
}

public class A06_GenericArray {
}
