// chap01/HelloWorld
package chap01;

import java.util.*;

class Universe  extends ArrayList<Planet>{
    private int time;

    public void addAr(Planet... planets){
        addAll(new ArrayList<>(Arrays.asList(planets)) );
    }

    @Override
    public String toString() {
        return "I am Universe.";
    }
}

class Planet{
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

        // 操作符重载
        System.out.println(1+2+""+3+4);

        new Earth().whatIAm();

        new Universe().addAr(new Earth(), new Earth());
        System.out.println("---------------------");

        // 截断
        float d1 = 21474123418.1f;
        System.out.println(d1);

        Long l1 = 21474123418L;
        System.out.println(Long.toBinaryString(21474123418L));

        int d2 = (int)d1;
        System.out.println(d2);
        System.out.println(Integer.toBinaryString(d2));

        System.out.println("数组赋值---------------------");
        Integer[] a = {
                1, 2,
                3, // Autoboxing
        };
        Integer[] b = new Integer[] {
                1, 2,
                3, // Autoboxing
        };
        b = a;

    }
}
