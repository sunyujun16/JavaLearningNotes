package chap20_generics;

import java.util.*;
import java.util.stream.*;

class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);

    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        Arrays.stream(
                ("The quick brown fox jumped over " +
                        "the lazy brown dog").split(" "))
                .forEach(rs::add);
        IntStream.range(0, 11).forEach(i ->
                System.out.print(rs.select() + " "));
    }
}

public class A01_RandomList {
}
