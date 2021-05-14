package chap04_operators;

import java.util.Random;

public class E07_FlipCoin {
    // Actually, It's flipping dice.
    private Random rand = new Random(47);

    public static void main(String[] args) {
        E07_FlipCoin e1 = new E07_FlipCoin();

        float sum = 0;
        int n = 200;
        for (int i = 0; i < n; i++) {
            int k = e1.rand.nextInt(6) + 1;
            System.out.println(i + ": " + k);
            sum += k;
        }

        System.out.println("average: " + sum / n);

    }

}
