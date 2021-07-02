package chap34_collectiontopics;

// Java 1.0/1.1 Vector and Enumeration

import java.util.*;

import onjava.*;

class Enumerations {
    public static void main(String[] args) {
        Vector<String> v =
                new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();

        while (e.hasMoreElements())
            System.out.print(e.nextElement() + ", ");

        // Produce an Enumeration from a Collection:
        e = Collections.enumeration(new ArrayList<>());
    }
}

public class A13_Enumerations {
}
