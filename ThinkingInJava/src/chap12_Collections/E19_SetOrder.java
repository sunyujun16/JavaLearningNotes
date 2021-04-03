package chap12_Collections;

import java.util.*;

import net.mindview.util.*;

public class E19_SetOrder {
    public static void main(String[] args) {
        Set<String> s1 =
                new HashSet<>(Countries.names(25));
        System.out.println(s1);

        String[] elements = s1.toArray(new String[0]);
        Arrays.sort(elements);

        Set<String> s2 = new LinkedHashSet<>(Arrays.asList(elements));
        System.out.println(s2);
    }
}

