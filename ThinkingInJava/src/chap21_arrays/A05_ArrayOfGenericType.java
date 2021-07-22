package chap21_arrays;

class ArrayOfGenericType<T> {
    T[] array; // OK

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        // error: generic array creation:
//        array = new T[size];
        array = (T[]) new Object[size]; // unchecked cast
    }

    // error: generic array creation:
//    public <U> U[] makeArray() {
//        return new U[10];
//    }
}

public class A05_ArrayOfGenericType {
}
