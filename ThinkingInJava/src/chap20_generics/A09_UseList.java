package chap20_generics;

import java.util.*;

class UseList<W, T> {
//    void f(List<T> v) {
//    }

    void f(List<W> v) {
    }
}

// 必须不重名
class UseList2<W, T> {
    void f1(List<T> v) {
    }

    void f2(List<W> v) {
    }
}

public class A09_UseList {
}
