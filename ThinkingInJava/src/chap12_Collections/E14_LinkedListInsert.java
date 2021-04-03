package chap12_Collections;

import java.util.*;

public class E14_LinkedListInsert {

    private static ListIterator<Integer> getIt(List<Integer> integers){
        if (integers.size() == 0) return integers.listIterator(0);
        return integers.listIterator(integers.size() >> 1);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> integers = new LinkedList<>();


        for (int i = 0; i < 10; i++) {
            ListIterator<Integer> it = getIt(integers); // 玛了隔壁的, 左值接受类型不对又耽误半天.

            // 对于为初始化的链表, 这2个方法不可用, 原因如下,
//            it.next();  // 源码自动调用hasNext(), 判断(nextIndex < size), 不能满足, 抛出异常.
//            it.set(i);  // 由于源码的lastReturned为null, 抛出异常
            it.add(i);
            System.out.println(integers);
        }

    }
}
