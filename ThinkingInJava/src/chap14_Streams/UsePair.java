package chap14_Streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

//class Pair {
//    public final Integer i;
//    public static int n = 0;
//
//    Pair(Integer i) {
//        this.i = i;
//    }
//
//    // 这个非静态方法表面上没有参数，但实际上在它的参数列表中，隐含了一个this，也就是指向对象的引用，其类型为Pair.
//    // 所以这个方法的接收和返回类型分别是：Pair, Integer。
//    public Integer getI() {
//        return i;
//    }
//
//    static public Pair getPair(){  // 这个方法将被Supplier引用，故必须是static，以避免参数列表中“this”的存在。
//        return new Pair(n++);
//    }
//}
//
//public class UsePair {
//    static Function<Pair,Integer> getIF(){  // 这里如果泛型的类型不匹配，就会报错。第一个类型是Pair，因为getI的参数"this"是Pair类型.
//        return Pair::getI;
//    }
//
//    public static void main(String[] args) {
//        // 不使用stream版本, 对应的函数式接口为Function。
//        Pair[] pairs = new Pair[3];
//        for (int i = 0; i < 3; i++) {
//            pairs[i] = new Pair(i);
//        }
//        for (Pair pair : pairs) {
//            System.out.println("" + getIF().apply(pair));
//        }
//
//        // 使用stream版，对应的函数式接口为Supplier和Function.
//        Stream<Pair> sp = Stream.generate(Pair::getPair);
//        // 流的创建方式之一，generate的参数接收Supplier类型。
//        // 如果这里直接引用Pair::new，则报错，因为Pair的构造器有参，而Supplier的抽象方法无参。
//
//        // 这里就是我一开始困惑的点（简化版），因为我忽略了this的存在。所以，此处对于“成员变量i”的获取方式，使我产生了疑惑。
//        sp.limit(3)
//                .map(Pair::getI)  // map接收的是Function，此处为Function<Pair, Integer>，完美对应了getI。
//                .forEach(System.out::println);
//    }
//}
