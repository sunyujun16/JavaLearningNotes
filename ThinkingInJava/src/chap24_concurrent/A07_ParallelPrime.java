package chap24_concurrent;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.LongStream.*;

import java.io.*;
import java.nio.file.*;

import onjava.Timer;

class ParallelPrime {
    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math
                .sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        List<String> primes =
                iterate(2, i -> i + 1)
                        .parallel()              // [1]
                        .filter(ParallelPrime::isPrime)
                        .limit(COUNT)
                        .mapToObj(Long::toString)
                        .collect(Collectors.toList());
        System.out.println(timer.duration());
        Files.write(Paths.get("ThinkingInJava/src/" +
                        "chap24_concurrent/primes.txt"),
                primes, StandardOpenOption.CREATE);
    }
}

public class A07_ParallelPrime {
}
