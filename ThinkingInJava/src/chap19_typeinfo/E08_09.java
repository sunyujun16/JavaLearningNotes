package chap19_typeinfo;

import onjava.Rand;

import java.util.ArrayList;
import java.util.Arrays;

class TesArray extends ArrayList {
    int n;
    private int k;
    public int i;
}

public class E08_09 {
    static void prIn(Class obc) {
        String s = obc.getSimpleName();
        System.out.println(s);

        Class papa = obc.getSuperclass();

        // only public if use obc.getFields();
        Arrays.stream(obc.getDeclaredFields())
                .forEach(System.out::println);

        if (!s.equals("Object")) {
            prIn(papa);
        }
    }

    public static void main(String[] args) {
        prIn(new TesArray().getClass());
    }
}
