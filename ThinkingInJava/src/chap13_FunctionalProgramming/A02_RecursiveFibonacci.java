package chap13_FunctionalProgramming;

interface IntCall {
    int call(int n, int a, int b);
}

public class A02_RecursiveFibonacci {
    IntCall fib;

    // 我的做法
//    public static void main(String[] args) {
//        A02_RecursiveFibonacci ar = new A02_RecursiveFibonacci();
//        ar.fib = (n) -> n == 1 ? 1 :
//                n == 2 ? 1 : ar.fib.call(n-1) + ar.fib.call(n-2);
//
//        System.out.println(ar.fib.call(10));
//    }

    // 下面是书里的做法, 可以看作是对我的-代码的重构, 以提供复用性.
    // 改为尾递归.
    A02_RecursiveFibonacci() {
        fib = (n, a, b) -> n == 0 ? a :
                n == 1 ? b : fib.call(n-1, b, a+b);
    }

    int fibonacci(int n) { return fib.call(n, 0, 1); }

    public static void main(String[] args) {
        A02_RecursiveFibonacci rf = new A02_RecursiveFibonacci();
        for(int i = 0; i <= 10; i++)
            System.out.println(rf.fibonacci(i));
    }
}
