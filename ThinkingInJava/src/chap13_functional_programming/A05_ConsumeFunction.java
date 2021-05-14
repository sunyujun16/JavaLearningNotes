package chap13_functional_programming;

import java.util.function.*;

class One {
}

class Two {
}

public class A05_ConsumeFunction {
    static Two consume(Function<One, Two> onetwo) {
        return onetwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
