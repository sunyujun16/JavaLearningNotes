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

        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        // 没这句, 则主线程直接罢工, 不管其他线程执行完没有. 想起Python的守护线程了.
        cfutures.forEach(CompletableFuture::join);
    }
}

public class A10_QuittingCompletable {
}
