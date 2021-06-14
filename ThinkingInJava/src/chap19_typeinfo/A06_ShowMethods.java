package chap19_typeinfo;

// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class
// {java ShowMethods ShowMethods}

import java.lang.reflect.*;
import java.util.regex.*;

//public
class A06_ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    // 匹配带点单词(即包名)
    private static Pattern p = Pattern.compile("\\w+\\.|final|native");

    // 非public类的默认构造器不是public
//    public A06_ShowMethods() {
//    }
//
//    public A06_ShowMethods(int n) {
//        System.out.println("FUCK.");
//    }

    // 第一个参数: 类名; 第二个参数: 筛选关键字.
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();

            if (args.length == 1) {
                for (Method method : methods)
                    System.out.println(
                            p.matcher(method.toString())
                                    .replaceAll("")
                    );
//                    try{
//                        Matcher m = p.matcher(method.toString());
//                        m.find();
//                        System.out.println(
//                                m.group());
////                                    .replaceAll("*")
//                    }catch(Exception e){
//                        System.out.println("nah....");
//                    }

                for (Constructor ctor : ctors)
                    System.out.println(
                            p.matcher(ctor.toString())
                                    .replaceAll("*")
                    );
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods)
                    if (method.toString().contains(args[1])) {
                        System.out.println(p.matcher(method.toString())
                                .replaceAll("*")
                        );
                        lines++;
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(ctor.toString())
                                .replaceAll("*")
                        );
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
