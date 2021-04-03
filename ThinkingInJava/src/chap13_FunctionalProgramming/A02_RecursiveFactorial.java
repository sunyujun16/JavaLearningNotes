package chap13_FunctionalProgramming;

public class A02_RecursiveFactorial {
    private static A03_IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);

        for (int i = 0; i <= 10; i++)
            System.out.println(fact.call(i));
    }
}

