package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

class CatchCompletableExceptions {
    static void handleException(int failcount) {
        // Call the Function only if there's an
        // exception, must produce same type as came in:
        CompletableExceptions
                .test("exceptionally007", failcount) // 返回CompletableFuture
                .exceptionally((ex) -> { // Function, 参数是Exception
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
                    if (fail != null)
                        return "Failure recovery object";
                    else
                        return result + " is good";
                })
                .thenAccept(str ->  // 参数是在上一步被包装的返回值, 任意类型
                        System.out.println("result: " + str));

        System.out.println("***************");
        // Do something but pass the same result through:
        CompletableExceptions
                .test("whenComplete", failcount)
                .whenComplete((result, fail) -> { // BiConsumer
                    if (fail != null)
                        System.out.println("It failed");
                    else
                        System.out.println(result + " OK");
                }).thenAccept(r ->  // 为什么不执行??? 已经compete了??? 接不到参数???
                        System.out.println("- result: " + r));

        new Nap(0.2);
    }

    public static void main(String[] args) {
        System.out.println("**** Failure Mode ****");
        handleException(2);
        System.out.println("**** Success Mode ****");
        handleException(0);
    }
}

public class A10_CatchCompletableExceptions {
}
