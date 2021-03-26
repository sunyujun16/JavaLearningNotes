package chap11_Collections;

// Collections print themselves automatically

import java.util.*;

public class A03_PrintingCollections {
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("pig");
        return collection;
    }

    // Overloaded
    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("pig", "Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        System.out.println(fill(new HashSet<>())); // no order
        System.out.println(fill(new TreeSet<>())); //ascending comparison order
        System.out.println(fill(new LinkedHashSet<>()));  // added order

        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
    }
}
