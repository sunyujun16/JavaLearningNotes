package chap24_concurrent;

import java.util.concurrent.atomic.*;

final class SyncFactory implements HasID {
    private final int id;

    private SyncFactory(SharedArg sa) {
        id = sa.get();
    }

    @Override
    public int getID() {
        return id;
    }

    public static

    synchronized // 再看不见把你眼睛挖了喂狗,草了...

    SyncFactory
    factory(SharedArg sa) {
        return new SyncFactory(sa);
    }
}

class SynchronizedFactory {
    public static void main(String[] args) {
        Unsafe unsafe = new Unsafe();
        IDChecker.test(() ->
                SyncFactory.factory(unsafe));
    }
}

public class A12_SynchronizedFactory {
}
