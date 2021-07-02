package chap35_lowlevel;

// Preventing thread collisions with mutexes

import java.util.concurrent.locks.*;

import onjava.Nap;

class MutexEvenProducer extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            new Nap(0.01); // Cause failure faster
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenProducer());
    }
}

public class A06_MutexEvenProducer {
}
