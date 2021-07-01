package chap34_collectiontopics;

// Unsupported operations in Java collections

import java.util.*;

class Unsupported {
    static void check(String description, Runnable tst) {
        try {
            tst.run();
        } catch (Exception e) {
            System.out.println(description + "(): " + e);
        }
    }

    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);

        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<>(subList);
        check("retainAll", () -> c.retainAll(c2));
        check("removeAll", () -> c.removeAll(c2));
        check("clear", () -> c.clear());
        check("add", () -> c.add("X"));
        check("addAll", () -> c.addAll(c2));
        check("remove", () -> c.remove("C"));

        // The List.set() method modifies the value but
        // doesn't change the size of the data structure:
        check("List.set", () -> list.set(0, "X"));
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "A B C D E F G H I J K L".split(" "));
        // 尽管Arrays.asList返回的也是一个ArrayList, 但此ArrayList不是
        // 彼ArrayList, 它们在两个不同的包中.

        // 咋整都行
        test("Modifiable Copy", new ArrayList<>(list));
        // 除了set都不得行.
        test("Arrays.asList()", list);
        // 咋整都不行
        test("unmodifiableList()",
                Collections.unmodifiableList(
                        new ArrayList<>(list)));
    }
}

public class A07_Unsupported {
}
