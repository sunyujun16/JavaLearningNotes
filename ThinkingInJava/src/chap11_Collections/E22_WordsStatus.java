package chap11_Collections;

import java.nio.file.*;
import java.util.*;

public class E22_WordsStatus {
    private Set<WordInfo> wordInfos = new LinkedHashSet<>();

    private class WordInfo {
        private String name;
        private int count;

        public WordInfo(String name, int count) {
            this.name = name;
            this.count = count;
        }

        void updateCount(int n) {
            count = n;
        }

        String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return " " + name + "=" + count;
        }
    }

    void appendWord(WordInfo wordInfo) {
        wordInfos.add(wordInfo);
    }

    WordInfo getWordInfo(String name, int count){
        return new WordInfo(name, count);
    }

    Set<WordInfo> getWordInfos() {
        return wordInfos;
    }

    public static void main(String[] args) throws Exception {

        List<String> lines = Files.readAllLines(
                Paths.get("ThinkingInJava/src/chap11_Collections/E09_Sequence.java")
        );
        LinkedHashMap<String, Integer> lmWords = new LinkedHashMap<>();
        Set<String> processedWords = new HashSet<>();

        // 得到单词Map.
        for (String line : lines) {
            for (String word : line.split("\\W+")) {
//                System.out.println(word);
                lmWords.put(word, lmWords.get(word) == null ? 1 : lmWords.get(word) + 1);
            }
        }
        System.out.println(lmWords); // 里面有空格, 是为啥类?

        // 获取键列表, 排序.
        List<String> keys = new ArrayList<>(lmWords.keySet());
        keys.sort(String.CASE_INSENSITIVE_ORDER);

        // 用于接受排序后的新Map.
        LinkedHashMap<String, Integer> new_lmWords = new LinkedHashMap<>();

        // 根据排序后的键列表, 获取其值, 并添加到新Map.
        for (String word : keys) {
            new_lmWords.put(word, lmWords.get(word));
        }

        E22_WordsStatus ews = new E22_WordsStatus();
        // 根据新Map, 生成WorInfo对象, 并添加到E22对象中.
        for (Map.Entry<String, Integer> entry : new_lmWords.entrySet()) {
            ews.appendWord(ews.getWordInfo(entry.getKey(), entry.getValue()));
        }

        // 打印最终保存WordInfo对象们的Set.
        System.out.println(ews.getWordInfos());

    }
}
