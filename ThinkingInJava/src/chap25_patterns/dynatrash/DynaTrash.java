package chap25_patterns.dynatrash;
// Using a Map of Lists and RTTI to automatically
// sort trash into Lists. This solution, despite
// the use of RTTI, is extensible.

import chap25_patterns.trash.*;

import java.util.*;
import java.util.stream.*;

// Generic TypeMap works in any situation:
class TypeMap<T> {
    private Map<Class, List<T>> t = new HashMap<>();

    public void add(T o) {
        Class type = o.getClass();
        if (t.containsKey(type))
            t.get(type).add(o);
        else {
            List<T> v = new ArrayList<>();
            v.add(o);
            t.put(type, v);
        }
    }

    public Stream<List<T>> values() {
        return t.values().stream();
    }
}

// Adapter class for callbacks
// from ParseTrash.fillBin():
class TypeMapAdapter implements Fillable {
    TypeMap<Trash> map;

    TypeMapAdapter(TypeMap<Trash> tm) {
        map = tm;
    }

    @Override
    public void addTrash(Trash t) {
        map.add(t);
    }
}

public class DynaTrash {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        TypeMap<Trash> bin = new TypeMap<>();
        ParseTrash.fillBin(
                "trash", new TypeMapAdapter(bin));

        bin.values().forEach(Trash::sumValue);
    }
}
