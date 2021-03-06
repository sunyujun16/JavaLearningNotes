package chap14_streams;

import static java.util.stream.IntStream.*;

public class A02_Ranges {
    public static void main(String[] args) {

        // The traditional way:
        int result = 0;
        for (int i = 10; i < 20; i++)
            result += i;
        System.out.println(result);

        // for-in with a range:
        result = 0;
        for (int i : range(10, 20).toArray())
            result += i;
        System.out.println(result);

        // Use streams:
        System.out.println(range(10, 20).sum());
    }
}

