package chap24_concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

class CountingStream {
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(0, 10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> ct.call())
                        .reduce(0, Integer::sum));
    }
}

public class A08_CountingStream {
}
