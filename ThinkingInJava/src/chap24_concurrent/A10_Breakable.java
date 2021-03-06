package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

class Breakable {
    String id;
    private int failcount;

    public Breakable(String id, int failcount) {
        this.id = id;
        this.failcount = failcount;
    }

    @Override
    public String toString() {
        return "Breakable_" + id +
                " [" + failcount + "]";
    }

    public static Breakable work(Breakable b) {
        if (--b.failcount == 0) {
            System.out.println(
                    "About to throw Exception for " + b.id + " 的异常");
            throw new RuntimeException(
                    "Breakable_" + b.id + " failed");
        }
//        if (b.id == "C") new Nap(0.1);
        System.out.println(b + "is a Breakable and is 正确地.");
        return b;
    }
}

public class A10_Breakable {
}
