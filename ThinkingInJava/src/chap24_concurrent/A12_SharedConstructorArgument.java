package chap24_concurrent;

import java.util.concurrent.atomic.*;

interface SharedArg {
    int get();
}

class Unsafe implements SharedArg {
    private int i = 0; // 非静态变量, 不过后面使用单一对象, 所以无所谓了.

    public int get() {
        return i++;
    }
}

class Safe implements SharedArg {
    private static AtomicInteger counter =
            new AtomicInteger();

    public int get() {
        return counter.getAndIncrement();
    }
}

class SharedUser implements HasID {
    private final int id;

    SharedUser(SharedArg sa) {
        id = sa.get();
    }

    @Override
    public int getID() {
        return id;
    }
}

class SharedConstructorArgument {
    public static void main(String[] args) {
        Unsafe unsafe = new Unsafe();
        IDChecker.test(() -> new SharedUser(unsafe)); // new的过程会不断调用
        Safe safe = new Safe();
        IDChecker.test(() -> new SharedUser(safe));
    }
}

public class A12_SharedConstructorArgument {
}
