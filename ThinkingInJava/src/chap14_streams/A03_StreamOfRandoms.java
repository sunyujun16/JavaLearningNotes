package chap14_streams;

import java.util.*;
import java.util.stream.*;

public class A03_StreamOfRandoms {
    static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(i -> {
                    System.out.println();
                    return IntStream.concat(
                            rand.ints(0,100).limit(i),
                            IntStream.of(-1));
                })
                .forEach(n -> System.out.format("%d ", n));
    }
}

