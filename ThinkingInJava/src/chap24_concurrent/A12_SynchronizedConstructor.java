package chap24_concurrent;

import java.util.concurrent.atomic.*;

class SyncConstructor implements HasID {
    private final int id;
    private static Object
            constructorLock = new Object();

    SyncConstructor(SharedArg sa) {
        synchronized (constructorLock) {
            id = sa.get();
        }
    }

    @Override
    public int getID() {
        return id;
    }
}

class SynchronizedConstructor {
    public static void main(String[] args) {
        Unsafe unsafe = new Unsafe();
        IDChecker.test(() ->
                new SyncConstructor(unsafe));
    }
}

public class A12_SynchronizedConstructor {
}
