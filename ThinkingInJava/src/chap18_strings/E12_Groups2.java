package chap18_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12_Groups2 {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    /**
     * @noinspection Duplicates
     */
    public static void main(String[] args) {
        System.out.println(POEM + "\n啥jb用词,词典都没翻译....\n");

        Matcher m = Pattern.compile(
//                "(?m)\\b([a-z]\\w+)") // 也行.
                "(?m)\\W([a-z]\\w+)")
                .matcher(POEM);
        int count = 0;
        while (m.find()) {
//            for (int j = 0; j <= m.groupCount(); j++)
            System.out.println("[" + m.group(1) + "]" + ++count);

        }
    }
}
