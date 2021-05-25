// Keeps track of how many of itself are created.
package chap16_validating;

import java.util.*;

class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;

    public CountedList() {
        System.out.println("CountedList #" + id);
    }

    public int getId() {
        return id;
    }
}

public class A01_CountedList {
}
