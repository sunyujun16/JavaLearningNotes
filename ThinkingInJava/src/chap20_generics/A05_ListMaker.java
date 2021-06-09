package chap20_generics;

import java.util.*;

class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> stringList = stringMaker.create();
    }
}

public class A05_ListMaker {
}
