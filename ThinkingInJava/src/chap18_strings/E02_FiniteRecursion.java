package chap18_strings;

// Accidental recursion
// {ThrowsException}
// {VisuallyInspectOutput} Throws very long exception

import java.util.stream.Stream;

public class E02_FiniteRecursion {
    @Override
    public String toString() {
        return
//                " InfiniteRecursion address: " + this + "\n"; // 无限调用this的toString.
                " finiteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        Stream.generate(E02_FiniteRecursion::new)
                .limit(10)
                .forEach(System.out::println);
    }
}
