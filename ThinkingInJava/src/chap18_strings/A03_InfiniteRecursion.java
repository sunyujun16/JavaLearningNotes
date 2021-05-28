package chap18_strings;

// Accidental recursion
// {ThrowsException}
// {VisuallyInspectOutput} Throws very long exception

import java.util.*;
import java.util.stream.*;

public class A03_InfiniteRecursion {
    @Override
    public String toString() {
        return
                " InfiniteRecursion address: " + this + "\n"; // 无限调用this的toString.
    }

    public static void main(String[] args) {
        Stream.generate(A03_InfiniteRecursion::new)
                .limit(10)
                .forEach(System.out::println);
    }
}
