// chap01/HelloWorld
package chap01;

import java.util.*;

class Universe {
    private int time;
    private Planet pl;

    @Override
    public String toString() {
        return "I am Universe.";
    }
}

class Planet {
    private int size;

    @Override
    public String toString() {
        return "Planet.";
    }
}

class Earth extends Planet {
    private int humanPopulation;

    public static void destroy() {
        System.out.println("Nuclear war happened.");
    }

    public void whatIAm() {
        destroy();
        System.out.println("I am a " + super.toString());
    }
}

public class HelloWorld {
    public static void main(String[] arg) {
        System.out.println("Hello, Java world, I'll conquer you!"
                + new Date());
        assert 1 == 2;
        System.out.println(1+2+""+3+4);

        new Earth().whatIAm();
        System.out.println("---------------------");

        float d1 = 21474123418.1f;
        System.out.println(d1);

        Long l1 = 21474123418L;
        System.out.println(Long.toBinaryString(21474123418L));

        int d2 = (int)d1;
        System.out.println(d2);
        System.out.println(Integer.toBinaryString(d2));

    }
}
