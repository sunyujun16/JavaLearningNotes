package chap18_strings;

import java.util.regex.*;
import java.util.*;

public class A06_SplitDemo {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";

        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input)));

        // Only do the first three:
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input, 2)));
    }
}
