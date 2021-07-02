package chap35_lowlevel;

import java.util.function.*;
import java.util.concurrent.*;

class UnsafeReturn extends IntTestable {
    private int i = 0;

    @Override
    public int getAsInt() {
        return i;
    }

    // getAsInt在主线程运行, 自增在其他线程运行. 而二者同时读/写i的值.

    public synchronized void evenIncrement() {
        i++; // 既然是同步的,方法互不干涉,那么唯一可能是这里直接把i写入到主存了.
        i++;
    }

    public static void main(String[] args) {
        Atomicity.test(new UnsafeReturn());
    }
}

public class A05_UnsafeReturn {
}
