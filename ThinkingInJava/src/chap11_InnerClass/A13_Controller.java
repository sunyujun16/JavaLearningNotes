package chap11_InnerClass;

// The reusable framework for control systems
//import java.sql.Time;

import java.util.*;
import java.time.*;

public class A13_Controller {
    // 这俩是我自己加的, 也是为了结果可读性.
    private final Instant ins = Instant.now();
    private final String sThen = ins.toString().split(":")[2].substring(0, 5);

    private List<A12_Event> eventList = new ArrayList<>();

    public void addA12_Event(A12_Event c) {
        eventList.add(c);
//        A12_Event.increaseI();
    }

    public void run() {
        while (eventList.size() > 0)
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for (A12_Event e : new ArrayList<>(eventList))
                if (e.ready()) {
//                    System.out.println(e);

                    //               获取瞬时时间.转换为字符串 .分割为字符数组 [按下标选取]. 取前5位截断
                    String sNow = Instant.now().toString().split(":")[2].substring(0, 5);
                    // 字符串转换为 double, 相减, 得到小数
                    double timeMinus = Double.parseDouble(sNow) - Double.parseDouble(sThen);
                    // 获取保留两位小数的字符串
                    String res = String.format("%.2f", timeMinus);

                    A12_Event.increaseI();

                    // 以下是书中的语句, 前面的语句也是我自己添加. 回头想想, 这些其实放在toString里实现更好.
                    System.out.println(
                            (Integer.toString(e.getI()).length() == 2 ? e.getI() : "0" + e.getI())
                                    + ": " + res + " --- " + e);
                    e.action();
                    eventList.remove(e);
                }
    }
}


