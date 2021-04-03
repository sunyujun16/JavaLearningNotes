package chap04_Operators;

import static net.mindview.util.Print.*;

/** The code below sucks.
 *  But I ain't gonna fix it.
 */
public class E04_Speed {
    private int distance = 100;
    private int tm = 5;

    private int speed() {
        if (tm <= 0) {
            System.out.println("wrong time");
            return 0;
        }
        return this.distance / this.tm;
    }

    private int dblspeed() {
        if (tm <= 0) {
            System.out.println("wrong time");
            return 0;
        }
        return 2 * this.distance / this.tm;
    }


    public static void main(String[] args) {
        print("\n");
        E04_Speed e = new E04_Speed();
        System.out.println(e.speed());
        System.out.println(e.dblspeed());
    }
}
