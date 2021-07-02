package chap35_lowlevel;

class SynchronizedSerialNumbers extends SerialNumbers {
    private int serialNumber = 0;

    public synchronized int nextSerialNumber() {
        return serialNumber++; // 读取值和递增值的过程都不可能异步, 所以安全.
    }

    public static void main(String[] args) {
        SerialNumberChecker.test(
                new SynchronizedSerialNumbers());
    }
}

public class A05_SynchronizedSerialNumbers {
}
