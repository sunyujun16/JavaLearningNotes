package chap35_lowlevel;

// Locks in the concurrent library allow you
// to give up on trying to acquire a lock

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import onjava.Nap;

class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(
                    "tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void letWait() {
        boolean captured = false;
        try {
            captured = lock.tryLock();
            new Nap(2.1);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed(); // True -- lock is available

        // Now create a second task to grab the lock:
        CompletableFuture.runAsync(() -> {
            al.lock.lock();
            System.out.println("acquired");
            new Nap(1); // 调整解锁时机.发现untimed方法不等待,直接跳过.
            al.lock.unlock();
            System.out.println("released"); // 谁上锁, 谁解锁.
        });
        new Nap(0.1); // Give the second task a chance
        al.untimed(); // False -- lock grabbed by task

        // 确保超时? 但此处无效, 因为是同步的, runAsync才行. 懒得继续改了...
        al.letWait();

        al.timed(); // False -- lock grabbed by task
//        System.out.println("---------------------------------");
////        al.lock.unlock(); // 报错, 不能在其他线程去解锁
////        System.out.println("released");
//        al.untimed();
//        al.timed();
    }
}

public class A06_AttemptLocking {
}
