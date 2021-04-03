package chap13_FunctionalProgramming;

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

    // 下面是书里的做法, 可以看作是对我的代码的重构, 以提供复用性.
    A02_RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) { return fib.call(n); }

    public static void main(String[] args) {
        A02_RecursiveFibonacci rf = new A02_RecursiveFibonacci();
        for(int i = 0; i <= 10; i++)
            System.out.println(rf.fibonacci(i));
    }
}
