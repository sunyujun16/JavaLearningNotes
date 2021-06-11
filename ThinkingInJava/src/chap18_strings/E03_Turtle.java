package chap18_strings;


import java.io.*;
import java.util.*;

public class E03_Turtle {
    private String name;
    private Formatter f;

    public E03_Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)%n",
                name, x, y);
    }

    /** @noinspection Duplicates*/
    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        A05_Turtle tommy = new A05_Turtle("Tommy",
                new Formatter(System.err));
        A05_Turtle terry = new A05_Turtle("Terry",
                new Formatter(outAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(3, 4);
        terry.move(2, 5);
        tommy.move(3, 3);
        terry.move(3, 3);
    }
}