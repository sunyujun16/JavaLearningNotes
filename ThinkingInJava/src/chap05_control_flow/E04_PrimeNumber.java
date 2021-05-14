package chap05_control_flow;

public class E04_PrimeNumber {
    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        for (int num = 4; num <= 100; num++) System.out.println(num + (isPrime(num) ? "素-" : "荤"));
    }
}
