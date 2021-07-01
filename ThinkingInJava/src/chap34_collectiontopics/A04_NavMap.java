package chap34_collectiontopics;

// NavigableMap produces pieces of a Map

import java.util.*;
import java.util.concurrent.*;

import static onjava.HTMLColors.*;

class NavMap {
    public static final
    NavigableMap<Integer, String> COLORS =
            new ConcurrentSkipListMap<>(MAP); // upcast.

    public static void main(String[] args) {
        show(COLORS.firstEntry());
        border();
        show(COLORS.lastEntry());
        border();
        NavigableMap<Integer, String> toLime =
                COLORS.headMap(rgb("Lime"), true);
        show(toLime);
        border();
        show(COLORS.ceilingEntry(rgb("DeepSkyBlue") - 1));
        border();
        show(COLORS.floorEntry(rgb("DeepSkyBlue") - 1));
        border();
        show(toLime.descendingMap());
        border();
        show(COLORS.tailMap(rgb("MistyRose"), true));
//        show(COLORS.tailMap(rgb("Lime"), true));
        border();
        show(COLORS.subMap(
                rgb("Orchid"), true,
                rgb("DarkSalmon"), false));
    }
}
