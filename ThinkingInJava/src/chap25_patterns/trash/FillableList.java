package chap25_patterns.trash;
// Adapter that makes a List Fillable

import java.util.*;

public class FillableList<T extends Trash>
        implements Fillable<T> {
    private List<T> v;

    public FillableList(List<T> vv) {
        v = vv;
    }

    @Override
    public void addTrash(T t) {
        v.add(t);
    }
}
