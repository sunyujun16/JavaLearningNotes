package chap14_streams;

import java.util.stream.*;

import static chap14_streams.A05_RandInts.*;

public class A05_NumericStreamInfo {
    public static void main(String[] args) {
        System.out.println("average  " + rands().average().getAsDouble());
        System.out.println("max      " + rands().max().getAsInt());
        System.out.println("min      " + rands().min().getAsInt());
        System.out.println("sum      " + rands().sum());
        System.out.println("summary  " + rands().summaryStatistics());
    }
}

