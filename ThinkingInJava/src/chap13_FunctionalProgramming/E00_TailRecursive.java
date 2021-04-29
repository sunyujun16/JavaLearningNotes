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
/*

 */

class E00_Recursive {
    private static int a;

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


//
//    int a;  // 如果变量定义在方法内部，那么每层递归都将建立一个新变量，造成很大开销。
//    int f (int n) {
//        芝麻开门；跺脚；开门；  // 执行开门动作
//
//        // 开始寻找返回值（找纸条）
//        if （n == 250）{  // 发现纸条，递归终止 [3]
//            放大象；      // [1]
//            a = 9527；   // 返回值 [2]
//        }
//	else   // 没纸条，向下一层冰箱找。
//        a =  f（n + 1）-1；  // f(n + 1)的值取决于它内部返回的a值，以此类推；
//
//        大喊a; 关门； // 执行关门动作
//        return a;
//    }
//// 调用f(0)，递归开始，最后获取返回值9277；调用f(x)则可以获取第x层冰箱时的返回值。
//// 注：当x > 250时会发生无限递归的问题，此处不做修改了。






