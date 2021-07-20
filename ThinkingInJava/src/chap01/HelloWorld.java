// chap01/HelloWorld
package chap01;

import java.util.*;
import onjava.*;
import onjava.Stack;

interface Printable {
    void print();
}

class Universe extends ArrayList<Planet> implements Printable {
    private int time;

    public Universe addAr(Planet... planets) {
        addAll(new ArrayList<>(Arrays.asList(planets)));
        return this;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "I am Universe with: " + super.toString();
    }
}

class Planet {
    private int size;

    public static void tryArParam(Object[] obs) {
        Arrays.asList(obs).forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Planet.";
    }
}

class Earth extends Planet {
    private int humanPopulation;

    Earth(int pop) {
        humanPopulation = pop;
    }

    public static void destroy() {
        System.out.println("Nuclear war happened.");
    }

    public void whatIAm() {
        destroy();
        System.out.println("I am a " + super.toString());
    }

    @Override
    public String toString() {
        return super.toString() + "with population of: " + humanPopulation;
    }
}

public class HelloWorld {
    public static void main(String[] arg) {
        System.out.println("Hello, Java world, I'll conquer you!"
                + new Date());
        assert 1 == 2; // 没有启用, -ea.

//        // 操作符重载
//        System.out.println(1 + 2 + "" + 3 + 4);
//
//        new Earth(0).whatIAm();
//
//        new Universe().addAr(new Earth(60), new Earth(70)).print();
//        System.out.println("---------------------");
//
//        // 截断
//        float d1 = 21474123418.1f;
//        System.out.println(d1);
//
//        Long l1 = 21474123418L;
//        System.out.println(Long.toBinaryString(21474123418L));
//
//        int d2 = (int) d1;
//        System.out.println(d2);
//        System.out.println(Integer.toBinaryString(d2));
//
//        // 试验Object数组是否接收任何类型的数组
//        //noinspection unchecked
//        Planet.tryArParam(new ArrayList<Object>(
//                Arrays.asList(
//                        new Planet(), new Earth(123456))
//        ).toArray());

        List lst1 = new ArrayList(Arrays.asList(new Integer[]{1,2,3,4,5}));
        List lst2 = new ArrayList(Arrays.asList(new Integer[]{4,5,6,7,8}));
        List lst3 = new ArrayList(lst1);
        lst3.retainAll(lst2);
        System.out.println(lst1);
        System.out.println(lst3);

    }
}
