package chap24_concurrent;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

import onjava.Nap;

class QuittingCompletable {
    public static void main(String[] args) {
        List<QuittableTask> tasks =
                IntStream.range(1, QuittingTasks.COUNT)
                        .mapToObj(QuittableTask::new)
                        .collect(Collectors.toList());

        List<CompletableFuture<Void>> cfutures =
                tasks.stream()
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());

        new Nap(1); // 如果注释掉, 大部分task甚至没机会进入while循环. 说明
        // 程序确实是立即向下运行, 没有等待.
        tasks.forEach(QuittableTask::quit);
        // 没这句, 则主线程直接罢工, 不管其他线程执行完没有. 想起Python的守护
        // 线程了. 但不是一回事. 记得Python的thread好像也有join语法.
        cfutures.forEach(CompletableFuture::join);
    }
}

public class A10_QuittingCompletable {
}
