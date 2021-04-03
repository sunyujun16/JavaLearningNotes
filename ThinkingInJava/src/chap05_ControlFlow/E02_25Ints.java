package chap05_ControlFlow;

import java.util.Random;

public class E02_25Ints {
    private static void mine() {
        for (int i = 0; i < 25; i++) {
//            System.out.println(i);
            double randInt = Math.floor(Math.random() * 100) + 1;
            if (randInt < 60) System.out.println(i + ": 垃圾" + randInt);
            else if (randInt < 80) System.out.println(i + ": 不咋地" + randInt);
            else if (randInt < 90) System.out.println(i + ": 还行吧" + randInt);
            else System.out.println(i + ": 应该的" + randInt);
        }
    }

    private static Random r = new Random(47);

    private static void comp() {
        int i1 = r.nextInt();
        int i2 = r.nextInt();

        System.out.println(i1 + ", " + i2);
        if (i1 > i2) System.out.println("Greater");
        else if (i1 < i2) System.out.println("Less");
        else System.out.println("Equal");
    }

    public static void main(Object... args) {
//        mine();
        for (int i = 0; i < 25; i++) {
            comp();
        }

    }
}

