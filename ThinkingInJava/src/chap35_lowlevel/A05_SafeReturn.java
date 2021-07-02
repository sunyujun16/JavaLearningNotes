package chap35_lowlevel;

import java.util.function.*;
import java.util.concurrent.*;

class SafeReturn extends IntTestable {
    private int i = 0;

    public synchronized int getAsInt() {
        return i;
    }
    // 同一个对象的synchronized方法同步执行, 避免了同时读和写i的值.

    public synchronized void evenIncrement() {
        i++;
        i++;
    }

    public static void main(String[] args) {
        Atomicity.test(new SafeReturn());
    }
}

public class A05_SafeReturn {
}
