package chap24_concurrent;

import onjava.Nap;
import onjava.Null;

import java.lang.reflect.Field;
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

        System.out.println("---------------");
        // Create a new result (recover):
        CompletableExceptions
                .test("handle", failcount)
                .handle((result, fail) -> { // BiFunction
                    if (fail != null) {
                        System.out.println(result + " 白日依山尽.");
                        return "Failure recovery object";
                    } else
                        return result + " is good";
                })
                .thenAccept(str ->  // 参数即上一步的返回值, // 并不是
                        System.out.println("result: " + str));
        // 上一步的返回值只是为handle所用而已, 用于包装成CompletableFuture<String>

        System.out.println("---------------");
        // Do something but pass the same result through:
        CompletableExceptions
                .test("whenComplete", failcount)
                .whenComplete((result, fail) -> { // BiConsumer
                    if (fail != null) {
                        System.out.println("It failed");
                        System.out.println(result + "  黄河入海流!"
                                + " : " + fail.getMessage());
                    } else
                        System.out.println(result + " OK");
                })
                .thenAccept(r ->  // 为什么不执行???
                        System.out.println("- result: " + r))
        ;

        // 本想自己试试上一条注释的结论. 不让有返回值, 没法试.
        testNull(null)
                .thenAccept(r -> System.out.println(
                        "我他妈就试试呢? :: " + r
                ));


        // 尝试访问源码的result成员变量, 但没有权限, 应该是涉及安全问题...
        // 算了, 放弃了...不要在这耽误时间了!!!!!!!!!!!!!!!!!!
//        try {
//            Field ob = CompletableExceptions
//                    .test("whenCompl------te", failcount)
//                    .whenComplete((result, fail) -> {
//                    })
//                    .getClass().getDeclaredField("result")
//                    ;
//            ob.setAccessible(true);
//            System.out.println(ob.getByte(new Object()));

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static <T> CompletableFuture<T> testNull(T s) {
        CompletableFuture<T> cf = CompletableFuture.completedFuture(s);
        return cf;
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
