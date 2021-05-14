//: chap03_object/HelloDate

package chap03_object;
import java.util.*;

/** The first Thinking in Java example program.
 * Display a string and today's date.
 * @author sun
 * @author sunyujun16@163.com
 * @version 1.0
 */
public class HelloDate {
    /**
     * Entry point to class & application.
     * @param args array of string arguments.
     * //@throws Exception No exceptions thrown;
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
    }
} /* Output: (55% match)
Hello, it's:
2005! that's 16 years ago when I was 11, jesus, just about when I moved to Dalian.
And I did not even know what a computer is and had never met one yet.
Too much to catch up with...
 *///:~
