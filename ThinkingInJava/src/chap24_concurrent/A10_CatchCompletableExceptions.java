package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

class CatchCompletableExceptions {
    static void handleException(int failcount) {
        // Call the Function only if there's an
        // exception, must produce same type as came in:
        CompletableExceptions
                .test("exceptionally007", failcount) // 返回CompletableFuture<Breakable>
                .exceptionally((ex) -> { // Function, 参数1st是Throwable
                    if (ex == null)
                        System.out.println("I don't get it yet");
                    return new Breakable(ex.getMessage(), 0);
                })
                .thenAccept(str ->  // 参数是在上一步被包装的返回值, 同输入类型
                        System.out.println("result: " + str));

        System.out.println("***************");
        // Create a new result (recover):
        CompletableExceptions
                .test("handle", failcount)
                .handle((result, fail) -> { // BiFunction
                    if (fail != null){
                        System.out.println(result+" 白日依山尽.");
                        return "Failure recovery object";
                    }
                    else
                        return result + " is good";
                })
                .thenAccept(str ->  // 参数即上一步的返回值
                        System.out.println("result: " + str));

        System.out.println("***************");
        // Do something but pass the same result through:
        CompletableExceptions
                .test("whenComplete", failcount)
                .whenComplete((result, fail) -> { // BiConsumer
                    if (fail != null){
                        System.out.println("It failed");
                        System.out.println(result+"  黄河入海流!");
                    }
                    else
                        System.out.println(result + " OK");
                }).thenAccept(r ->  // 为什么不执行??? 因为whenComplete没有返回值并且result是null.
                        System.out.println("- result: " + r));

        // 本想自己试试上一条注释的结论. 不让有返回值, 没法试.

//        new Nap(0.2); // 没并发, 你搁这等鸡毛呢?
    }

    public static void main(String[] args) {
        System.out.println("**** Failure Mode ****");
        handleException(2);
        System.out.println("\n**** Success Mode ****");
        handleException(0);
    }
}

public class A10_CatchCompletableExceptions {
}
