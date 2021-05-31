package chap18_strings;

// A very simple version of the "grep" program
// {java JGrep
// WhitherStringBuilder.java 'return|for|String'}

import java.util.regex.*;
import java.nio.file.*;
import java.util.stream.*;

public class A06_JGrep {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println(
                    "Usage: java JGrep file regex");
            System.exit(0);
        }
        System.out.println("args1: " + args[1]);

        // "j\\w+"直接放这里生效, 但放在命令行就不起作用, 解决: 命令行参数用单\斜杠.
        Pattern p0 = Pattern.compile("j\\w+");
        String s = "asdf javaishere hahaha.";
        Matcher m0 = p0.matcher(s);
        m0.find();
        System.out.println(m0.group());

        Pattern p = Pattern.compile(args[1]);

        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");

        for (String line :
                Files.readAllLines(Paths.get(args[0]))) {
//            System.out.println(line);
            m.reset(line);
            // 很傻逼的一行, 直接find一次导致结果丢失了, 草.
//            if (! m.find()) System.out.println("-nothing-");
            while (m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }
}
