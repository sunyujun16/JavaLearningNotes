package chap22_enums;

import java.util.*;

import static chap22_enums.AlarmPoints.*;

class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty
        points.add(BATHROOM);
        System.out.println(points);

        points.addAll(
                EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(
                EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points.removeAll(
                EnumSet.range(OFFICE1, OFFICE4)); //两边包括
        System.out.println(points);

        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}

public class A08_EnumSets {
}
