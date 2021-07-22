package chap22_enums;

// Analyzing enums using reflection

import java.lang.reflect.*;
import java.util.*;
//import java.lang.Enum;

import onjava.*;

enum Explore {HERE, THERE}

class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println(
                "_____ Analyzing " + enumClass + " _____");

        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces())
            System.out.println(t);

        System.out.println(
                "Base: " + enumClass.getSuperclass());

        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);

        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods =
                analyze(Explore.class);

        Set<String> enumMethods = analyze(Enum.class);

        System.out.println(
                "Explore.containsAll(Enum)? " +
                        exploreMethods.containsAll(enumMethods));

        System.out.print("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods); // 剩下一个values()方法嘿.
        System.out.println(exploreMethods);

        // Decompile the code for the enum:
        OSExecute.command(
                "javap -cp out/production/" +
                        "ThinkingInJava/chap22_enums Explore");
    }
}

public class A04_Reflection {
}
