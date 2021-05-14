package chap13_functional_programming;

class This {
    void two(int i, double d) {
    }

    void three(int i, double d, String s) {
    }

    void four(int i, double d, String s, char c) {
    }
}

interface TwoArgs {
    void call2(This aThis, int i, double d);
}

interface ThreeArgs {
    void call3(This aThis, int i, double d, String s);
}

interface FourArgs {
    void call4(This aThis, int i, double d, String s, char c);
}

public class A03_MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoargs = This::two;
        ThreeArgs threeargs = This::three;
        FourArgs fourargs = This::four;

        This aThis = new This();

        twoargs.call2(aThis, 11, 3.14);
        threeargs.call3(aThis, 11, 3.14, "Three");
        fourargs.call4(aThis, 11, 3.14, "Four", 'Z');
    }
}

