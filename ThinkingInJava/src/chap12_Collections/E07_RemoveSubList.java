package chap12_Collections;

import java.util.*;

class MyClass {
    private static int n;
    private int id;

    MyClass() {
        id = ++n;
    }

    @Override
    public String toString() {
        return "my class " + id;
    }
}

public class E07_RemoveSubList {
    MyClass[] mc = new MyClass[5];

    private E07_RemoveSubList() {
        for (int i = 0; i < 5; i++) {
            mc[i] = new MyClass();
        }
    }

    public static void main(String[] args) {
        E07_RemoveSubList er = new E07_RemoveSubList();
        MyClass[] mc = er.mc;

        List<MyClass> lmc = new ArrayList<>(Arrays.asList(mc));
//        System.out.println(lmc);
//        for (MyClass mcs : lmc) {
//            System.out.println(mcs);
//        }

        List<MyClass> sub = lmc.subList(1, 4);
        System.out.println(sub);
        System.out.println(lmc);

        List<MyClass> copySub = new ArrayList<>(sub);

        sub.clear();
//        // 以下两种都会造成修改sub的底层引用(lmc), 导致sub访问错误
//        lmc.removeAll(copySub);
//        System.out.println(lmc);
//        lmc.removeAll(sub);
//        System.out.println(lmc);

        System.out.println(sub);

    }
}
