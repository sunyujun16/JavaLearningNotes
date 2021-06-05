package chap18_strings;


import java.util.regex.*;

public class E00_TryRegex01 {
    public static void main(String[] args) {
//        Pattern pt = Pattern.compile("(?s)((第\\d{1,2}章).*(\\*{6})){1}");
//        Matcher m = pt.matcher(
//                "\n\n\n## 第1章  哈哈(*&%*$()哈哈哈\n哈啊哈哈,?:'哈哈\n******\n" +
//                "## 第2章  哈哈(*&%*$()哈哈哈\n哈啊哈哈,?:'哈哈\n******##");
//
//        m.find();
//        System.out.println(m.group());

        Matcher m2 = Pattern.compile("(a(.*?)c)").matcher("ab  bb cab caa as kj c");
        m2.find();
        System.out.println(m2.group().replaceAll(" +", "_"));

        Matcher m3 = Pattern.compile("(a\\w+c)").matcher("abbbcc");
        m3.find();
        System.out.println(m3.group());

    }
}
