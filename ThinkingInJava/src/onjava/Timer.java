// onjava/Timer.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package onjava;

import static java.util.concurrent.TimeUnit.*;

public class Timer {
    private long start = System.nanoTime();

    public void resetTime(){
        start = System.nanoTime();
    }

    public long duration() {
        return NANOSECONDS.toMillis(
                System.nanoTime() - start);
    }

    public static long duration(Runnable test) {
        Timer timer = new Timer(); // 初始化成员变量, start获得值.
        test.run(); // 运行传入的函数.
        return timer.duration(); // 获取程序运行的时间.
    }
}
