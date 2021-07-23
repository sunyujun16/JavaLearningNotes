package chap24_concurrent;

class InterferingTask implements Runnable {
    final int id;
    private static Integer val = 0;

    public InterferingTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++)
            val++;
        System.out.println(id + ": " +
                Thread.currentThread().getName() + " " + val);
    }
}

public class A08_InterferingTask {
}

/*
5: pool-1-thread-6 5000
6: pool-1-thread-7 6000
0: pool-1-thread-1 1000
7: pool-1-thread-8 5000
8: pool-1-thread-9 6000
4: pool-1-thread-5 4000
3: pool-1-thread-4 4000
1: pool-1-thread-2 2000
2: pool-1-thread-3 3000
9: pool-1-thread-10 7000
*/
