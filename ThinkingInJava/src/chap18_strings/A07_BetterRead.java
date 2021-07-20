package chap18_strings;

import java.util.*;

public class A07_BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("What is your name?");

        String name = stdin.nextLine();
        System.out.println(name);
        System.out.println(
                "How old are you?");
        System.out.println("(input: <age>)");
        int age = stdin.nextInt();

        System.out.println(
                "What is your favorite double?");
        System.out.println("(input: <double>)");
        double favorite = stdin.nextDouble();

        System.out.println(age);
        System.out.println(favorite);
        System.out.format("Hi %s.%n", name);
        System.out.format("In 5 years you will be %d.%n",
                age + 5);
        System.out.format("My favorite double is %f.",
                favorite / 2);
    }
}
