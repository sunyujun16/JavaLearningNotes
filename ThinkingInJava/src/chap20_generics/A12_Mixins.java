package chap20_generics;

import java.util.*;

interface TimeStamped {
    long getStamp();

//    default String getName(){
//        return "TimeStampedImp";
//    }
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
//
//    default String getName(){
//        return "SerialNumbered";
//    }
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

//    default String getName(){
//        return "BasicImp";
//    }

    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

class Mixins {
    public static void main(String[] args) {
        Mixin
                mixin1 = new Mixin(),
                mixin2 = new Mixin();

        mixin1.set("test string 1");
        mixin2.set("test string 2");

        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " +
                mixin1.getSerialNumber());

        System.out.println(mixin2.get() + " " +
                mixin2.getStamp() + " " +
                mixin2.getSerialNumber());
    }
}

public class A12_Mixins {
}
