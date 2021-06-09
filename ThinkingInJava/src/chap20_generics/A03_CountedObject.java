package chap20_generics;

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    CountedObject() {
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject " + id;
    }
}

public class A03_CountedObject {
}
