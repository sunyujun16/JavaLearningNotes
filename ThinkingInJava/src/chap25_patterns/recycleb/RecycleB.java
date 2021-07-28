package chap25_patterns.recycleb;

import chap25_patterns.trash.*;

import java.util.*;

public class RecycleB {
    /** @noinspection Duplicates*/
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();

        // Fill up the Trash bin:
        ParseTrash.fillBin("trash", bin);

        List<Glass> glassBin = new ArrayList<>();
        List<Paper> paperBin = new ArrayList<>();
        List<Aluminum> alBin = new ArrayList<>();

        // 这段没写Cardboard的代码, 于是被忽略了. 但在bin里还是存在的.
        // 这意味着, 这里也是一段在添加新类型时需要修改的代码.
        // Sort the Trash:
        bin.forEach(t -> {
        // RTTI to discover Trash type:
            if (t instanceof Aluminum)
                alBin.add((Aluminum) t);
            if (t instanceof Paper)
                paperBin.add((Paper) t);
            if (t instanceof Glass)
                glassBin.add((Glass) t);
        });

        Trash.sumValue(alBin);
        Trash.sumValue(paperBin);
        Trash.sumValue(glassBin);

        Trash.sumValue(bin);
    }
}
