package chap35_lowlevel;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

import onjava.*;

class AtomicIntegerTest extends IntTestable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getAsInt() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    public static void main(String[] args) {
        Atomicity.test(new AtomicIntegerTest());
    }
}

public class A05_AtomicIntegerTest {
}
