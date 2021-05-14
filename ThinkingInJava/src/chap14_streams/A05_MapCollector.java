package chap14_streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

class Pair {
    final Character c; //可以不是public
    public final Integer i;
    public static int n = 0;

    Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    public Character getC() {
        return c;
    }

    public Integer getI() {
        return i;
    }

    static public Pair getPair(){
        return new Pair('n', n++);
    }

    @Override
    public String toString() {
        return "Pair(" + c + ", " + i + ")";
    }
}

class RandomPair {
    Random rand = new Random(47);
    // An infinite iterator of random capital letters:
    Iterator<Character> capChars = rand.ints(65, 91)
            .mapToObj(i -> (char) i)
            .iterator();

    public Stream<Pair> stream() {
        // 这个判断是没用的,因为capChars这个迭代器是从流生成的, 它永远都hasNext.
        if (!capChars.hasNext()){
            System.out.println("Letters run out !!!");
            return null;
        }
        return rand.ints(100, 1000).distinct()
                .mapToObj(i -> new Pair(capChars.next(), i));
    }
}

public class A05_MapCollector {

    static Function<Pair,Integer> getIF(){
        return Pair::getI;
    }

    public static void main(String[] args) {
        Map<Integer, Character> map =
                new RandomPair().stream()
                        .limit(8)
                        .collect(
                                Collectors.toMap(Pair::getI, Pair::getC)); // 引用非静态方法, 注意被隐藏的this可能造成困惑
        System.out.println(map);

        // 以下试验Function调用方法引用时访问变量的原则. 补:实际上不需要考虑变量访问, 因为this的存在保证了i的存在.
        System.out.println();
        Pair[] pairs = new Pair[10];

        for (int i = 0; i < 10; i++) {
            pairs[i] = new Pair('a', i);
        }

        for (Pair pair : pairs) {
            System.out.println("" + getIF().apply(pair));
        }

        Stream<Pair> sp = Stream.generate(Pair::getPair);

        sp.limit(3).map(Pair::getI).forEach(System.out::println);




    }

}

