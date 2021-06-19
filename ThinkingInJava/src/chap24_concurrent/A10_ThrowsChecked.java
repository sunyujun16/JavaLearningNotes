package chap24_concurrent;

import java.util.stream.*;
import java.util.concurrent.*;

class ThrowsChecked {
    class Checked extends Exception {
    }

    static ThrowsChecked nochecked(ThrowsChecked tc) {
        return tc;
    }

    static ThrowsChecked withchecked(ThrowsChecked tc) throws Checked {
        return tc;
    }

    static void testStream() {
        Stream.of(new ThrowsChecked())
                .map(ThrowsChecked::nochecked)
//                .map(ThrowsChecked::withchecked); // [1]
                .map(tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
        // 必须手动处理异常, 挺尴尬.
    }

    static void testCompletableFuture() {
        CompletableFuture
                .completedFuture(new ThrowsChecked())
                .thenApply(ThrowsChecked::nochecked)
//                .thenApply(ThrowsChecked::withchecked); // [2]
                .thenApply(tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

public class A10_ThrowsChecked {
}
