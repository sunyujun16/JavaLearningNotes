package chap24_concurrent;

import onjava.*;

import java.util.*;
import java.util.stream.*;

class CollectionIntoStream {
    public static void main(String[] args) {
        List<String> strings =
                Stream.generate(new Rand.String(5))
                        .limit(10)
                        .collect(Collectors.toList());

        strings.forEach(System.out::println);

        // Convert to a Stream for many more options:
        String result = strings.stream()
                .map(String::toUpperCase)
                .map(s -> s.substring(2))
                .reduce(":", (s1, s2) -> s1 + s2);

        System.out.println(result);
    }
}

public class A07_CollectionIntoStream {
}
