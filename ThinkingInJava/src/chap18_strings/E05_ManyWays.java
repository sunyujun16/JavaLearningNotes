package chap18_strings;

import java.util.Calendar;
import java.util.Formatter;

public class E05_ManyWays {
    public static void main(String[] args) {
        Formatter fmt = new Formatter(System.out);

        fmt.format("%s -- %d -- %n -- %f -- %e -- %x -- %h --\n",
                "fuck", 12, 1.22, 2123.123145, 1024, "asdf");

        fmt.format("%s - %b - %c\n","here", 1,'g');

        fmt.format("today is : %1$tY-%1$tm-%1$td \n",
                Calendar.getInstance());

        System.out.println(Calendar.getInstance());


    }


}
