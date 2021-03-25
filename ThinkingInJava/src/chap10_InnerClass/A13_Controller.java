package chap10_InnerClass;

// The reusable framework for control systems
//import java.sql.Time;

import java.util.*;
import java.time.*;

public class A13_Controller {
    // A class from java.util to hold A12_Event objects:
    private static final Instant ins = Instant.now();
    String sThen = (ins.toString().split(":")[2].substring(0, 5));
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
                    String sNow = (Instant.now().toString().split(":")[2].substring(0, 5));
                    double timeMinus = Double.parseDouble(sNow) - Double.parseDouble(sThen);
//                    double f1 = timeMinus.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    String res = String.format("%.2f", timeMinus);
                    System.out.println(res + " --- " + e);
                    e.action();
                    eventList.remove(e);
                }
    }
}


