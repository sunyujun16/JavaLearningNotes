package chap18_strings;

import java.util.regex.*;
import java.nio.file.*;
import java.util.stream.*;

/*! Here's a block of text to use as input to
 the regular expression matcher. Note that we
   first extract the block of text by looking for
the special delimiters, then process the
extracted block. !*/

public class A06_TheReplacements {
    public static void main(String[] args) throws Exception {
        String s = Files.lines(
                Paths.get("A06_TheReplacements.java"))
                .collect(Collectors.joining("\n"));

        // Match specially commented block of text above:
        Matcher mInput = Pattern.compile(
                "/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find())
            s = mInput.group(1); // Captured by parentheses, 只获取组内内容!!

        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");

        // Replace 1+ spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);

        // you cannot turn sth into uppercase with replaceFirst().
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);

        // Process the find information as you perform the replacements:
        while (m.find())
            m.appendReplacement(
                    sbuf, m.group().toUpperCase());

        // Put in the remainder of the text:
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
