package chap20_generics;

import java.util.*;

class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
// 阿这...直接TM用ArrayList得了呗...,
// 复习补充: 不一样, 这种方式"缩小"了接口. 它只提供两个可用的方法.

public class A06_ListOfGenerics {
}
