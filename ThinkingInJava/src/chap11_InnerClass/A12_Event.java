package chap11_InnerClass;

// The common methods for any control event

import java.time.*; // Java 8 time classes

public abstract class A12_Event {
    private Instant eventTime;
    protected final Duration delayTime;
    private static int i = 0;

    public A12_Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
//        i++;
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    public int getI() {
        return i;
    }

    public static void increaseI(){
        i++;
    }

    public abstract void action();
}

