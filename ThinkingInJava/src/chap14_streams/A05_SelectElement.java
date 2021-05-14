package chap14_streams;

import static chap14_streams.A05_RandInts.*;

public class A05_SelectElement {
    public static void main(String[] args) {
        System.out.println(rands().findFirst().getAsInt());

        System.out.println(rands().parallel().findFirst().getAsInt()); // no influence

        System.out.println(rands().findAny().getAsInt()); // still first element in stream.

        System.out.println(rands().parallel().findAny().getAsInt()); // do influence
    }
}


