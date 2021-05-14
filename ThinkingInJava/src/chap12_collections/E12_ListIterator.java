package chap12_collections;

import java.util.*;

public class E12_ListIterator {
    public static void main(String[] args) {
        int n = 4;

        List<Integer> ints = new ArrayList<>(n);

        Random rand = new Random(47);
        for (int i = 0; i < n; i++) {
            ints.add(rand.nextInt(10));
        }
        System.out.println(ints);
//        System.out.println(ints);

        ListIterator<Integer> it1 = ints.listIterator();
        ListIterator<Integer> it2 = ints.listIterator(ints.size());

        System.out.println(it2.hasPrevious()); // Why??? Because it2 was not given a param.

//        while (it1.hasNext()){
//            it2.previous();
//            it2.set(it1.next());
//        }
        // 8 5 5 8, 想想为啥.

        for (int i = 0; i < ints.size() >> 1; i++) {
            int temp = it1.next();
            it1.set(it2.previous());
            it2.set(temp);
        }

        // 其他方式: 先存到一个中间集合中, 再逐个读取. 需要空间相同, 时间加倍.

        System.out.println(ints);
//        System.out.println(ints);

    }
}
