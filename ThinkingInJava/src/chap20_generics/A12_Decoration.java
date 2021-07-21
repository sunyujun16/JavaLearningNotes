package chap20_generics;

import java.util.*;

class Basic0 {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

// 这个还比较好理解, 就是相当于向父类的方法添加了新的操作.
class Decorator0 extends Basic0 {
    protected Basic0 basic;

    Decorator0(Basic0 basic) {
        this.basic = basic;
    }

    @Override
    public void set(String val) {
        System.out.println("Decorator0新的操作");
        basic.set(val);
    }

    @Override
    public String get() {
        return basic.get();
    }
}

class TimeStamped0 extends Decorator0 {
    private final long timeStamp;

    TimeStamped0(Basic0 basic) {
        super(basic);
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumbered0 extends Decorator0 {
    private static long counter = 1;
    private final long serialNumber = counter++;

    SerialNumbered0(Basic0 basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

class Decoration {
    public static void main(String[] args) {
        TimeStamped0 t = new TimeStamped0(new Basic0());
        TimeStamped0 t2 = new TimeStamped0(
                new SerialNumbered0(new Basic0()));

        // 自己添加的代码.只有cast才能使用被装饰的对象,这太鸡肋了.
        // sb, 哪里鸡肋了, 这不就是普普通通的向下转型吗?
        SerialNumbered0 t2t = (SerialNumbered0) t2.basic;
        System.out.println(t2t.getSerialNumber());

        // t2.getSerialNumber(); // Not available
        SerialNumbered0 s = new SerialNumbered0(new Basic0());
        SerialNumbered0 s2 = new SerialNumbered0(
                new TimeStamped0(new Basic0()));

//         s2.getStamp(); // Not available

        // 自己添加:
        TimeStamped0 tt = (TimeStamped0) s2.basic;
        System.out.println(tt.getStamp());
    }
}

public class A12_Decoration {
}
