package chap18_strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07_09_Regex01 {
    private static String knights =
            "Then,     when you have found the shrubbery, " +
                    "you must cut down the mightiest tree in the " +
                    "forest...with... a herring!";

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^[A-Z].*.$");
        Matcher m  = p.matcher("A bitch is a bitch.");

        m.find();
        System.out.println(m.group());

        System.out.println(
                Arrays.toString(
                        knights.replaceAll("[aeiou]","_")
                        .split("(the)|(you)"))
                // 这俩冲突了嘿, 算了就这样吧.
        );

    }
}
