// onjava/atunit/AtUnit.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// An annotation-based unit-test framework
// {java onjava.atunit.AtUnit}
package onjava.atunit;

import java.lang.reflect.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

import onjava.*;

// 这是截至目前读得最费劲的源码了, 呼~, 还好没放弃.
public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<>();
    static long testsRun = 0;
    static long failures = 0;

    public static void main(String[] args) throws Exception {
        args = new String[]{
                "ThinkingInJava/src/chap23_annotations/AtUnitExample1",
                "ThinkingInJava/src/chap23_annotations/AUExternalTest",
                "ThinkingInJava/src/chap23_annotations/AtUnitExample2",
        };

        ClassLoader.getSystemClassLoader()
                .setDefaultAssertionStatus(true); // Enable assert
        new ProcessFiles(new AtUnit(), "class").start(args);
        // 在这一步, AtUnit对象作为一个strategy被传入ProcessFiles. 并在其start()
        // 内部被调用strategy.process()方法. 这应该是一个设计模式...装饰器!!!

//        System.out.println("什么鬼????????????");
//        System.out.println("改完没JB编译, 什么什么鬼, 傻逼.....");

        System.out.println("Final results 如下:");
        if (failures == 0)
            System.out.println("OK (" + testsRun + " tests)");
        else {
            System.out.println("(" + testsRun + " tests)");
//            System.out.println("我就它么不信了呢........");
            System.out.println(
                    "\n>>> " + failures + " FAILURE" + // 真TM严谨...
                            (failures > 1 ? "S" : "") + " <<<");
            for (String failed : failedTests)
                System.out.println("  " + failed);
        }
    }

    @Override
    public void process(File cFile) { //cFile其实就是从传入start()的args中获取的
        try {
            String cName = ClassNameFinder.thisClass(
                    Files.readAllBytes(cFile.toPath()));
            System.out.println(cName + " 在这里~在这里!");
            if (!cName.startsWith("public:"))
                return;
            cName = cName.split(":")[1];
            if (!cName.contains("."))
                return; // Ignore unpackaged classes
            testClass = Class.forName(cName); // 终于获取要测试类的Class对象
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        TestMethods testMethods = new TestMethods();
        Method creator = null;
        Method cleanup = null;
        // 对方法进行遍历和分类。
        for (Method m : testClass.getDeclaredMethods()) {
            // 把需要测试的方法找出来保存好.
            testMethods.addIfTestMethod(m);
            // 找到两种类型的方法，存入这两个变量, 这里显然两种方法都只有一个.
            if (creator == null)
                creator = checkForCreatorMethod(m);
            if (cleanup == null)
                cleanup = checkForCleanupMethod(m);
        }
        // 在没有creator时，判断构造器是否是public.
        if (testMethods.size() > 0) {
            if (creator == null)
                try {
                    if (!Modifier.isPublic(testClass
                            .getDeclaredConstructor()
                            .getModifiers())) {
                        System.out.println("Error: " + testClass +
                                " zero-argument constructor must " +
                                "be public");
                        System.exit(1);
                    }
                } catch (NoSuchMethodException e) {
                    // Synthesized zero-argument constructor; OK
                }
            System.out.println(testClass.getName());
        }
        // 现在生成对象的方法有了, 测试方法也找到了. 下面开始调用要测试的方法
        for (Method m : testMethods) {
            System.out.print("  . " + m.getName() + " ");
            try {
                // creator是null的情况被创建createTestObject在内部解决了.
//                creator = null;
//                System.out.println("现在使用creator...........");
                Object testObject = createTestObject(creator);
                boolean success = false;
                try {
                    if (m.getReturnType().equals(boolean.class))
                        success = (Boolean) m.invoke(testObject);
                    else {
                        m.invoke(testObject);
                        success = true; // If no assert fails
                    }
                } catch (InvocationTargetException e) {
                    // Actual exception is inside e:
                    System.out.println(e.getCause());
                }
                System.out.println(success ? "" : "(failed)");
                testsRun++;
                if (!success) {
                    failures++;
                    failedTests.add(testClass.getName() +
                            ": " + m.getName());
                }
                if (cleanup != null)
                    cleanup.invoke(testObject, testObject);
            } catch (IllegalAccessException |
                    IllegalArgumentException |
                    InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class TestMethods extends ArrayList<Method> {
        void addIfTestMethod(Method m) {
            if (m.getAnnotation(Test.class) == null)
                return;
            if (!(m.getReturnType().equals(boolean.class) ||
                    m.getReturnType().equals(void.class)))
                throw new RuntimeException("@Test method" +
                        " must return boolean or void");
            m.setAccessible(true); // If it's private, etc.
            add(m);
        }
    }

    // 针对@TestObjectCreated注解, 使用该注解的方法应该用于创建对象.
    private static Method checkForCreatorMethod(Method m) {
        if (m.getAnnotation(TestObjectCreate.class) == null)
            return null;
        if (!m.getReturnType().equals(testClass))
            throw new RuntimeException("@TestObjectCreate " +
                    "must return instance of Class to be tested");
        if ((m.getModifiers() &
                java.lang.reflect.Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCreate " +
                    "must be static.");
        m.setAccessible(true);
        return m;
    }

    private static Method checkForCleanupMethod(Method m) {
        if (m.getAnnotation(TestObjectCleanup.class) == null)
            return null;
        if (!m.getReturnType().equals(void.class))
            throw new RuntimeException("@TestObjectCleanup " +
                    "must return void");
        if ((m.getModifiers() &
                java.lang.reflect.Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCleanup " +
                    "must be static.");
        if (m.getParameterTypes().length == 0 ||
                m.getParameterTypes()[0] != testClass)
            throw new RuntimeException("@TestObjectCleanup " +
                    "must take an argument of the tested type.");
        m.setAccessible(true);
        return m;
    }

    private static Object createTestObject(Method creator) {
        // 如果定义了creator，就使用creator.
        if (creator != null) {
            try {
                return creator.invoke(testClass);
            } catch (IllegalAccessException |
                    IllegalArgumentException |
                    InvocationTargetException e) {
                throw new RuntimeException("Couldn't run " +
                        "@TestObject (creator) method.");
            }
        }
        // 如果没有定义creator，就使用无参构造器
        else { // Use the zero-argument constructor:
            try {
                return testClass
                        .getConstructor().newInstance();
            } catch (InstantiationException |
                    NoSuchMethodException |
                    InvocationTargetException |
                    IllegalAccessException e) {
                throw new RuntimeException(
                        "Couldn't create a test object. " +
                                "Try using a @TestObject method.");
            }
        }
    }
}
