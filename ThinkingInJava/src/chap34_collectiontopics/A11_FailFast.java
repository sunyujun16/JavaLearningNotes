package chap34_collectiontopics;

// Demonstrates the "fail-fast" behavior

import java.util.*;

class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }

        // 这样也不行哦, 不过Python针对这种操作没有强行抛出异常.
        List<Integer> li = new ArrayList<>(
                Arrays.asList(1, 2, 4, 2));
        try {
            for (Integer i : li) {
                li.add(3);
                if (i == 3) break;
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("another one : "+e);
        }
    }
}

public class A11_FailFast {
}
