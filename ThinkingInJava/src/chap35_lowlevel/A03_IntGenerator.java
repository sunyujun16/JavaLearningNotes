package chap35_lowlevel;

import java.util.concurrent.atomic.AtomicBoolean;

abstract class IntGenerator {
//    private AtomicBoolean canceled =
//            new AtomicBoolean();

    // 如果出问题我就试试这个. 以保证可见性.
    private volatile AtomicBoolean canceled =
            new AtomicBoolean();

    public abstract int next();

    public void cancel() {
        canceled.set(true);
    }

    public boolean isCanceled() {
        return canceled.get();
    }
}

public class A03_IntGenerator {
}
