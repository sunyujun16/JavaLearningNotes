package chap14_streams;

import java.util.stream.*;
import static java.util.stream.LongStream.*;

public class A03_Prime {
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    public LongStream numbers() {
        return iterate(2, i -> i + 1)
                .filter(A03_Prime::isPrime);
    }

    public static void main(String[] args) {
        new A03_Prime().numbers()
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new A03_Prime().numbers()
                .skip(90)
                .limit(10)
                .forEach(n -> System.out.format("%d ", n));
    }
}

/* Output:
2 3 5 7 11 13 17 19 23 29
467 479 487 491 499 503 509 521 523 541
*/


