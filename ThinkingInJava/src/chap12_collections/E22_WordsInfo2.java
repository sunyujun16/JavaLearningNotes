package chap12_collections;

import java.util.*;

import net.mindview.util.*;

class WordCounter {
    // used in l.sort in main().
    public static final
    Comparator<WordCounter> CASE_INSENSITIVE_ORDER =
            new Comparator<WordCounter>() {
                public int compare(WordCounter o1, WordCounter o2) {
                    return o1.word.compareToIgnoreCase(o2.word);
                }
            };

    private final String word;
    private int frequency;

    WordCounter(String word) {
        this.word = word;
        frequency = 1;
    }

    void incFrequency() {
        ++frequency;
    }

    String getWord() {
        return word;
    }

    int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof WordCounter &&
                word.equals(((WordCounter) o).word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}

public class E22_WordsInfo2 {
    private static void
    updateStat(Iterator<WordCounter> it, WordCounter wc) {
        while (it.hasNext()) {
            WordCounter currentWC = it.next();
            if (currentWC.equals(wc))
                currentWC.incFrequency();
        }
    }

    public static void main(String[] args) {
        Set<WordCounter> stat = new HashSet<>();
        for (String word : new TextFile("ThinkingInJava/src/chap12_collections" +
                "/A08_SetOperations.java", "\\W+")) {
            WordCounter wc = new WordCounter(word);
            if (stat.contains(wc))  // 这里不懂,contains如何辨别刚刚new出来的wc是否在stat集合中?
                                    // 引用肯定是不一样的, 那么我猜是contains底层调用了equals.
                                    // 并不是, 关键在于我们自定义的哈希函数, 使用了word来计算哈希值.
                updateStat(stat.iterator(), wc); // 对每个wc, 都要把stat遍历一遍.
            else
                stat.add(wc);
        }
        List<WordCounter> l = new ArrayList<>(stat);
        l.sort(WordCounter.CASE_INSENSITIVE_ORDER);
        for (WordCounter wc : l)
            System.out.println(wc.getWord() + " => "
                    + wc.getFrequency());
    }
}
