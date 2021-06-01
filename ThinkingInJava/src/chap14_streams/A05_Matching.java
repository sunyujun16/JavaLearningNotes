package chap14_streams;

import java.util.stream.*;
import java.util.function.*;

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {
    // 接口含test方法, 接收两个泛型, 返回boolean.
}

public class A05_Matching {
    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d ", n)),
                        n -> n < val));
    }

    public static void main(String[] args) {
        show(Stream::allMatch, 10); // 又一个非绑定方法引用的应用.
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}

