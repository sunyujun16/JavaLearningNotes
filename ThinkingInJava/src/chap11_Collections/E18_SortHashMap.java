package chap11_Collections;

import java.util.*;
import net.mindview.util.*;

public class E18_SortHashMap {
//    public static void main(String[] args) {
//        Countries countries = new Countries();
//        System.out.println(Countries.capitals(25));
//
//    }

    public static void main(String[] args) {
        Map<String,String> m1 =
                new HashMap<>(Countries.capitals(25));
        System.out.println(m1);
        String[] keys = m1.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        Map<String,String> m2 =
                new LinkedHashMap<>();
        for(String key : keys)
            m2.put(key, m1.get(key));
        System.out.println(m2);
    }
}

