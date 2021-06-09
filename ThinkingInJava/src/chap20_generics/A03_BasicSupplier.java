package chap20_generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.function.*;
import java.lang.reflect.InvocationTargetException;

class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public BasicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            // Assumes type is a public class:
            // 我偏不, 嘿.
            Constructor ctor = type.getDeclaredConstructor();
            ctor.setAccessible(true);
            return (T) ctor.newInstance();
        } catch (InstantiationException |
                NoSuchMethodException |
                InvocationTargetException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // Produce a default Supplier from a type token:
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}

public class A03_BasicSupplier {
}
