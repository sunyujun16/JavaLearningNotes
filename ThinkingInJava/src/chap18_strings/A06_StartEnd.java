package chap18_strings;

import java.util.regex.*;

public class A06_StartEnd {
    public static String input =
            "As long as there is injustice, whenever a\n" +
                    "Targathian baby cries out, wherever a distress\n" +
                    "signal sounds among the stars " +
                    "... We'll be there.\n" +
                    "This fine ship, and this fine crew ...\n" +
                    "Never give up! Never surrender!";

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println("regex: " + regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display("find() '" + m.group() +
                    "' start = " + m.start() + " end = " + m.end());
        if (m.lookingAt()) // No reset() necessary
            d.display("lookingAt() start = "
                    + m.start() + " end = " + m.end());
        if (m.matches()) // No reset() necessary
            d.display("matches() start = "
                    + m.start() + " end = " + m.end());
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        for (String in : input.split("\n")) { // 把字符串按行拆分

            System.out.println("* * input : " + in);

            // 在行内, 对每个正则进行匹配
            for (String regex :
                    new String[]{
                            "\\w*ere\\w*",
                            "\\w*ever",
                            "T\\w+",
                            "Never.*?!"})  // 非贪婪
                examine(in, regex);
        }
    }
}
