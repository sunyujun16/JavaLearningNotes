package chap18_strings;

import java.util.regex.*;

public class A06_Finding {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("(bitch)*\\w+")
                .matcher(
                        "Evening is full of the linnet's wings");
        while (m.find())
            System.out.print(m.group(0) + " ");

        System.out.println("\n--------------");

        int i = 0;
        while (m.find(i++)) {
            System.out.print(m.group() + " -- ");
            if (i % 5 == 0) System.out.println();
        }
    }
}