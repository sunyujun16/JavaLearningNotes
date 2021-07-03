package chap37_serialization;

// Demonstrates object serialization

import java.io.*;
import java.util.*;

class Data implements Serializable {
    private int n;

    Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next; // null by default.
    private char c;

    // Value of i == number of segments
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x + 1));
    }

    public Worm() {
        System.out.println("No-arg constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d)
            result.append(dat);
        result.append(")");
        if (next != null) // 凡是涉及链表, 立刻就该想到类似这种的判断.
            result.append(next);
        return result.toString();
    }

    public static void main(String[] args)
            throws ClassNotFoundException,IOException {
        Worm w = new Worm(6, 'n');
        System.out.println("w = " + w);
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream("ThinkingInJava/src/" +
                                "chap37_serialization/worm.dat"))
        ) {
            out.writeObject("Worm storage\n"); // 对使用者而言, 这行会不会太烦人了.
            out.writeObject("我就试试");
            out.writeObject(w);
        }
        // then read it.
        try (
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream("ThinkingInJava/src/" +
                                "chap37_serialization/worm.dat"))
        ) {
            String s = (String) in.readObject(); //是自动识别类型, 还是识别写入行为?
            // 答案是: 识别写入行为.如果读写行为不一致: ClassCastException
            String ss = (String) in.readObject();
            Worm w2 = (Worm) in.readObject();
            System.out.println(s + "w2 = " + w2);
        }

        // sth. else
        try (
                ByteArrayOutputStream bout =
                        new ByteArrayOutputStream();
                ObjectOutputStream out2 =
                        new ObjectOutputStream(bout) // 用out2往bout里面写.
        ) {
            out2.writeObject("Worm storage\n");
            out2.writeObject(w);
            out2.flush();
            try (
                    ObjectInputStream in2 = new ObjectInputStream(
                            new ByteArrayInputStream(
                                    bout.toByteArray()))
            ) {
                String s = (String) in2.readObject();
                Worm w3 = (Worm) in2.readObject();
                System.out.println(s + "w3 = " + w3);
            }
        }
    }
}
