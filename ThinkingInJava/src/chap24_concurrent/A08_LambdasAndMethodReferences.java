package chap24_concurrent;

import java.util.concurrent.*;
import java.util.function.Consumer;

class NotRunnable {
    public void go() {
        System.out.println("NotRunnable");
    }
}

class NotCallable {
    public Integer get() {
        System.out.println("NotCallable");
        return 1;
    }
}

class TestLamAndRef{
    void tOne(){
        System.out.println("t1...");
    }

    static void tTwo(){
        System.out.println("t2...");
    }

    static void acThem(Runnable cs){
        cs.run();
    }
}

class LambdasAndMethodReferences {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec =
                Executors.newCachedThreadPool();

        exec.submit(() -> System.out.println("Lambda1"));
        exec.submit(new NotRunnable()::go);
        exec.submit(() -> {
            System.out.println("Lambda2");
            return 1;
        });
        Future f = exec.submit(new NotCallable()::get);
        exec.shutdown();

        try {
            System.out.println(f.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // here is the difference. 瞅瞅, 瞅瞅, 基础不牢吧?
//        TestLamAndRef.acThem(TestLamAndRef::tOne);
        TestLamAndRef.acThem(new TestLamAndRef()::tOne);
    }
}

public class A08_LambdasAndMethodReferences {
}
