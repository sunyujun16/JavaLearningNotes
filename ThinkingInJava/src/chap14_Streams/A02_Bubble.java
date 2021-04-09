package chap14_Streams;

import java.util.function.*;

public class A02_Bubble {
    public final int i;

    public A02_Bubble(int n) {
        i = n;
    }

    @Override
    public String toString() {
        return "Bubble(" + i + ")";
    }

    private static int count = 0;

    public static A02_Bubble bubbler() {
        return new A02_Bubble(count++);
    }
}


