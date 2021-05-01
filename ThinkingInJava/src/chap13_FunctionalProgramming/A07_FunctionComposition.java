package chap13_FunctionalProgramming;

import java.util.function.*;

public class A07_FunctionComposition {

    static Function<String, String>
            f1 = s -> {
        System.out.println(s);
        return s.replace('1', '2');
    },
//            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase();


    static Function<Integer, String>
            f2 = d -> d.toString().substring(3),
            f4 = f1.compose(f2).andThen(f3);
            // 首先, f1.compose(f2) 将两者行为结合为一. 形成一个匿名的行为对象, 该匿名对象的apply的
            // 参数类型, 取决于f2的参数类型, 故为: <Integer, String>.
            // 然后, 这个匿名对象又通过其andThen方法结合了f3. 而结合之后的整体被赋予给f4. 故此时
            // f4的apply亦为<Integer, String>.
            // 而最后面的这个String, 不要和最初的String混淆, 它是不是String完全取决于f3的心情.

    public static void main(String[] args) {
        System.out.println( f4.apply(111111) );
                // 结果中第一行是取自于f1中的那部分代码的副作用, 第二行是f4的返回值. 修改之后看不出小写效果了.
    }
}

// default Function<s, s> compose(Function<s, s> before){
//     Object.RequireNotNull(before);
//     return str -> apply( before.apply(str) );
// }
