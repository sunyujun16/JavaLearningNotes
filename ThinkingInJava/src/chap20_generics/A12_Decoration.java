package chap20_generics;

import java.util.*;

//class Basic {
//    private String value;
//
//    public void set(String val) {
//        value = val;
//    }
//
//    public String get() {
//        return value;
//    }
//}
//
//class Decorator extends Basic {
//    protected Basic basic;
//
//    Decorator(Basic basic) {
//        this.basic = basic;
//    }
//
//    @Override
//    public void set(String val) {
//        basic.set(val);
//    }
//
//    @Override
//    public String get() {
//        return basic.get();
//    }
//}
//
//class TimeStamped extends Decorator {
//    private final long timeStamp;
//
//    TimeStamped(Basic basic) {
//        super(basic);
//        timeStamp = new Date().getTime();
//    }
//
//    public long getStamp() {
//        return timeStamp;
//    }
//}
//
//class SerialNumbered extends Decorator {
//    private static long counter = 1;
//    private final long serialNumber = counter++;
//
//    SerialNumbered(Basic basic) {
//        super(basic);
//    }
//
//    public long getSerialNumber() {
//        return serialNumber;
//    }
//}
//
//class Decoration {
//    public static void main(String[] args) {
//        TimeStamped t = new TimeStamped(new Basic());
//        TimeStamped t2 = new TimeStamped(
//                new SerialNumbered(new Basic()));
//
//        // 自己添加的代码.只有cast才能使用被装饰的对象,这太鸡肋了.
//        SerialNumbered t2t = (SerialNumbered) t2.basic;
//        System.out.println(t2t.getSerialNumber());
//
//        //- t2.getSerialNumber(); // Not available
//        SerialNumbered s = new SerialNumbered(new Basic());
//        SerialNumbered s2 = new SerialNumbered(
//                new TimeStamped(new Basic()));
//
//        //- s2.getStamp(); // Not available
//        // 自己添加:
//        TimeStamped tt = (TimeStamped) s2.basic;
//        System.out.println(tt.getStamp());
//    }
//}

public class A12_Decoration {
}
