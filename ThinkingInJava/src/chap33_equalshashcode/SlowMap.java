package chap33_equalshashcode;

// A Map implemented with ArrayLists

import java.util.*;

import onjava.*;

public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    public V get(Object key) { // key: type Object, not K, 'cause Overriding.
        if (!keys.contains(key))
            return null;
//        Collections.binarySearch(keys,(K)key); // 无法确定K是Comparable,报错
        return values.get(keys.indexOf(key)); // linear searching.
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<>(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(8)); // 模板方法信不信? 肯定的, 赌十块钱的.
        // 赢了.
        m.forEach((k, v) ->
                System.out.println(k + "=" + v));
        System.out.println("--------------------");
        System.out.println(m.get("BENIN"));
        System.out.println("--------------------");

        m.entrySet().forEach(System.out::println);
    }
}
/*
    {"ALGERIA", "Algiers"},
    {"ANGOLA", "Luanda"},
    {"BENIN", "Porto-Novo"},
    {"BOTSWANA", "Gaberone"},
    {"BURKINA FASO", "Ouagadougou"},
    {"BURUNDI", "Bujumbura"},
    {"CAMEROON", "Yaounde"},
    {"CAPE VERDE", "Praia"},
*/
