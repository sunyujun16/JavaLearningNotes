package chap18_strings;

import java.util.regex.*;

public class A06_TestRegularExpression {
    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.out.println(
//                    "Usage:\njava A06_TestRegularExpression " +
//                            "characterSequence regularExpression+");
//            System.exit(0);
//        }
//        System.out.println("Input: \"" + args[0] + "\"");

        // 修改了一下, 省去命令行传参的麻烦.
        args = new String[]{"abcabcabcdefabc", "abc+", "(abc)+"};

        for (String arg : args) {
            System.out.println(
                    "\nRegular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                System.out.println(
                        "Match \"" + m.group() + "\" at positions " +
                                m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
