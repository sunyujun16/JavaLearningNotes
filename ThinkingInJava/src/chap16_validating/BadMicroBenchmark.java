package chap16_validating;

import java.util.*;

import onjava.Timer;

public class BadMicroBenchmark {
    static final int SIZE = 25_000_000;

    public static void main(String[] args) {
        try { // For machines with insufficient memory
            long[] la = new long[SIZE];

            System.out.println("setAll: " +
                    Timer.duration(() ->
                            Arrays.setAll(la, n -> n)));

            System.out.println("parallelSetAll: " +
                    Timer.duration(() ->
                            Arrays.parallelSetAll(la, n -> n)));
        } catch (OutOfMemoryError e) {
            System.out.println("Insufficient memory");
            System.exit(0);
        }
    }
}
