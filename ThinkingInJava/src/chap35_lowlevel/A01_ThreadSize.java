package chap35_lowlevel;

// {ExcludeFromGradle} Takes a long time or hangs

import java.util.concurrent.*;

import onjava.Nap;

class ThreadSize {
    static class Dummy extends Thread {
        @Override
        public void run() {
            new Nap(1);
        }
    }

    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        int count = 0;
        try {
            while (true) {
                exec.execute(new Dummy());
                count++;
            }
        } catch (Error e) {
            System.out.println(
                    e.getClass().getSimpleName() + ": " + count);
            System.exit(0);
        } finally {
            exec.shutdown();
        }
    }
}

public class A01_ThreadSize {
}
