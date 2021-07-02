package chap35_lowlevel;

import onjava.*;

class TestAbort {
    public static void main(String[] args) {
        new TimedAbort(1);
        System.out.println("Napping for 4");
        new Nap(4); // 不等它完成就Abort了, 但是如果没有它, 主线程同样
        // 不会惯着Abort毛病, 直接退出.
    }
}

public class A03_TestAbort {
}
