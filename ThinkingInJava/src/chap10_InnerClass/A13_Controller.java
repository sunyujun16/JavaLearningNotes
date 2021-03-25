package chap10_InnerClass;

// The reusable framework for control systems
import java.util.*;
import java.time.*;

public class A13_Controller {
    // A class from java.util to hold A12_Event objects:
    private List<A12_Event> eventList = new ArrayList<>();

    public void addA12_Event(A12_Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0)
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for (A12_Event e : new ArrayList<>(eventList))
                if (e.ready()) {
//                    System.out.println(e);
                    System.out.println(e + " --- " + Instant.now());
                    e.action();
                    eventList.remove(e);
                }
    }
}


