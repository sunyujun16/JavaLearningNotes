package chap35_lowlevel;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence =
            new ArrayList<>();

    DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() +
                NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) { //参数固定死了, 像是偏函数
        return unit.convert(
                trigger - System.nanoTime(), NANOSECONDS);
    } // 返回的是负数, 就是说, 越小, 越应该先执行.
    // 纠正: 谁说一定是负数? 可能还没到时间嘛.

    @Override
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask) arg;
        if (trigger < that.trigger) return -1; // 我小我先来.
        if (trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public String toString() {
        return
                String.format("[%d] Task %d", delta, id);
    }

    public String summary() {
        return String.format("(%d:%d)", id, delta);
    }

    public static class EndTask extends DelayedTask {
        EndTask(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println(this +" ~ ~");
            System.out.println("-----------");
            sequence.forEach(dt ->
                    System.out.println(dt.summary()));
        }
    }
}

class DelayQueueDemo {
    public static void main(String[] args) throws Exception {
        DelayQueue<DelayedTask> tasks =
                Stream.concat( // Random delays:
                        new Random(47).ints(20,
                                0,
                                4000)
                                .mapToObj(DelayedTask::new),
                        // Add the summarizing task:
                        Stream.of(new DelayedTask.EndTask(4000)))
                        .collect(Collectors
                                .toCollection(DelayQueue::new));
        while (tasks.size() > 0)
            tasks.take().run();
    }
}

public class A07_DelayQueueDemo {
}
