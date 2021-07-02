package chap35_lowlevel;

import java.util.concurrent.*;

class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        ExecutorService es =
                Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
        es.shutdown();
    }
}

public class A2_SettingDefaultHandler {
}
