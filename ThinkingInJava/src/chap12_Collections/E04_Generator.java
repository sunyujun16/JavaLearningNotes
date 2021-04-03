package chap12_Collections;

import java.util.*;

/** @noinspection WeakerAccess*/
public class E04_Generator {
    private int index = 0;
    private String[] sa = {
            "Leon",
            "No country for old man",
            "Godfather",
            "Forrest Gump",
            "The Legend of 1900",
    };

    public E04_Generator() {
    }

    protected String next() {
        if (index == sa.length) index = 0;
        return sa[index++];
    }

    // 答案直接给E04写一个方法, 统一接受Collection来循环add. 但循环写在底层, 复用性稍差.
    public static void main(String[] args) {
        E04_Generator ge = new E04_Generator();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(ge.next());
//        }
        ArrayList<String> al = new ArrayList<>();
        LinkedList<String> ll = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();

        String ne;

        for (int i = 0; i < 7; i++) {
            ne = ge.next();
            al.add(ne);
            ll.add(ne);
            hs.add(ne);
            lhs.add(ne);
            ts.add(ne);
        }

        System.out.println(al + "\n");
        System.out.println(ll + "\n");
        System.out.println(hs + "\n");
        System.out.println(lhs + "\n");
        System.out.println(ts + "\n");

    }

}
