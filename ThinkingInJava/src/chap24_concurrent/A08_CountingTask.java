package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

class CountingTask implements Callable<Integer> {
    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() {
        Integer val = 0; // 局部变量似乎就安全了吧...当然安全, 因为没有别人访问这个变量
        for (int i = 0; i < 100; i++)
            val++;
        System.out.println(id + " " +
                Thread.currentThread().getName() + " " + val);
        return val;
    }
}

public class A08_CountingTask {
}
