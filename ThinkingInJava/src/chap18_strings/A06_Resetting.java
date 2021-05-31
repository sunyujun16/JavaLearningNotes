package chap18_strings;

import java.util.regex.*;

public class A06_Resetting {
    public static void main(String[] args) throws Exception {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();

        // pattern不变, change一个字符串, 没有参数则将匹配位置复位到最开始处.
        m.reset("fix the rig with rags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();
    }
}
