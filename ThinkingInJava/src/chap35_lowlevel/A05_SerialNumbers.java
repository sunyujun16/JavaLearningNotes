package chap35_lowlevel;

class SerialNumbers {
    private volatile int serialNumber = 0;

    public int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
}

public class A05_SerialNumbers {
}
