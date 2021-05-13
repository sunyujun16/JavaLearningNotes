package chap14_Streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class A04_Signal {
    private final String msg;

    public A04_Signal(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Signal(" + msg + ")";
    }

    static Random rand = new Random(47);

    public static A04_Signal morse() {
        switch (rand.nextInt(4)) {
            case 1:
                return new A04_Signal("1-dot");
            case 2:
                return new A04_Signal("2-dash");
            default:
                return null;
        }
    }

    public static Stream<Optional<A04_Signal>> stream() {
        return Stream.generate(A04_Signal::morse)
                .map(signal -> Optional.ofNullable(signal));
    }
}

