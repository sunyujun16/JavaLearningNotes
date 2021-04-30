package chap13_FunctionalProgramming;

import java.util.*;

public class E00_TailRecursive {

    static int recursive(int n, int a) {
        System.out.println("开门动作");
        if (n == 3) {
            System.out.println("放大象");
            return a;
        } else
            return recursive(n + 1, a - 1);

//        System.out.println("关门动作");
    }

    public static void main(String[] args) {
//        System.out.println(recursive(0, 9527));
        System.out.println(E00_Recursive.f(0));
    }
}
/*
开门动作
开门动作
开门动作
开门动作
放大象
9524
 */


class E00_Recursive {
    private static int a; // 如果变量定义在方法内部，那么每层递归都将建立一个新变量，造成很大开销。

    static int f(int n) {
        System.out.print("芝麻开门, ");
        System.out.println("啪啪啪, " + "开门");

        // 开始寻找返回值（找纸条）
        if (n == 2) {  // 发现纸条，递归终止 [3]
            System.out.println("------放大象------");  // [1]
            a = 9527;  // 返回值 [2]
        } else
            a = f(n + 1) - 1;

        System.out.print("喊" + a);
        System.out.println(", 关门");

        return a;
    }

    public static void main(String[] args) {
        System.out.println(f(0));
    }
}








