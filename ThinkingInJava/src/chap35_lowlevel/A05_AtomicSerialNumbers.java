package chap35_lowlevel;

import java.util.concurrent.atomic.*;

class AtomicSerialNumbers extends SerialNumbers {
    private AtomicInteger serialNumber =
            new AtomicInteger();

    // 原代码加了synchronized关键字, 我觉得没有必要. 即便在run方法中
    // 手动设置了阻塞, 也没有发生任何的duplicates.
//    public synchronized int nextSerialNumber() {
    public int nextSerialNumber() {
        return serialNumber.getAndIncrement();
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(
                new AtomicSerialNumbers());
    }
}

public class A05_AtomicSerialNumbers {
}
