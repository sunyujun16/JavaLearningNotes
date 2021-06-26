package chap28_javadoc;

import java.util.*;

/**
 * The first On Java 8 example program.
 * Displays a String and today's date.
 *
 * @author Bruce Eckel
 * @author www.MindviewInc.com
 * @version 5.0
 */
public class HelloDateDoc {
    /**
     * Entry point to class & application.
     *
     * @param args array of String arguments
     * @throws \exceptions No exceptions thrown
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
    }
}
/* Output:
Hello, it's:
Tue May 09 06:07:27 MDT 2017
*/
