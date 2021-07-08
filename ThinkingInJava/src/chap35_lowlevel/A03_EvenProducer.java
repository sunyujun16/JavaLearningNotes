package chap35_lowlevel;

import onjava.Nap;

// When threads collide
// {VisuallyInspectOutput}
class EvenProducer extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue; // [1]
        new Nap(0.001); // 保证迅速发生变量冲突.没有这个则很难发生,估计是因为
        // 我的虚拟机可以同时执行的线程太少了(算上主线程才4个).
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenProducer());
    }
}

public class A03_EvenProducer {
}
