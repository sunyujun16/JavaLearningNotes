package chap25_patterns.doubledispatch;

import chap25_patterns.trash.*;

import java.util.*;

public class TypedBin {
    List<Trash> v = new ArrayList<>();

    protected boolean addIt(Trash t) {
        v.add(t);
        return true;
    }

    // 行不通, 因为Java的擦除效应.你不能妄想用T来覆写方法.
//    public <T extends Trash> boolean add(T t) {
//        return false;
//    }

    public boolean add(Aluminum a) {
        return false;
    }

    public boolean add(Paper a) {
        return false;
    }

    public boolean add(Glass a) {
        return false;
    }

    public boolean add(Cardboard a) {
        return false;
    }
}
