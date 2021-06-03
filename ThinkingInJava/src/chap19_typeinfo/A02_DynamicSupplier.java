package chap19_typeinfo;

import java.util.function.*;
import java.util.stream.*;

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class A02_DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public A02_DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch (InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(
                new A02_DynamicSupplier<>(CountedInteger.class))
                .skip(10)
                .limit(5)
                . peek(s -> System.out.println(s.getClass()))
                .forEach(System.out::println);
    }
}
