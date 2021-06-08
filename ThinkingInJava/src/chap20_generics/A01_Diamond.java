package chap20_generics;

class Bob {
}

class Diamond<T> {
    public static void main(String[] args) {
        GenericHolder<Bob> h3 = new GenericHolder<>();
        h3.set(new Bob());
    }
}

public class A01_Diamond {
}
