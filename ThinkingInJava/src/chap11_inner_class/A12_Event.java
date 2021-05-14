package chap11_inner_class;

// The common methods for any control event

import java.time.*; // Java 8 time classes

public abstract class A12_Event {
    private Instant eventTime;
    protected final Duration delayTime;
    private static int i = 0; // 我自己加的, 为了控制台结果更容易阅读.

    public A12_Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay); // 初始化delayTime.
        start(); // 初始化eventTime.
    }

    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime); // 计算Event对象的触发时间.
//        i++;
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    } //可以覆写来改变判断依据.

    public int getI() {
        return i;
    }

    public static void increaseI(){
        i++;
    }

    public abstract void action();
}

