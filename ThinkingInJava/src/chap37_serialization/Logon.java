package chap37_serialization;

// Demonstrates the "transient" keyword

import java.util.concurrent.*;
import java.io.*;
import java.util.*;

import onjava.Nap;

public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    // 如果有这两, password会得以恢复.
//    private void writeObject(ObjectOutputStream stream)
//            throws IOException {
//        stream.defaultWriteObject();
//        stream.writeObject(password);
//    }
//
//    private void readObject(ObjectInputStream stream)
//            throws IOException, ClassNotFoundException {
//        stream.defaultReadObject();
//        password = (String) stream.readObject();
//    }


    @Override
    public String toString() {
        return "logon info: \n username: " +
                username + "\n date: " + date +
                "\n password: " + password;
    }

    public static void main(String[] args) {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println("logon a = " + a);
        try (
                ObjectOutputStream o =
                        new ObjectOutputStream(
                                new FileOutputStream("ThinkingInJava/src/" +
                                        "chap37_serialization/Logon.dat"))
        ) {
            o.writeObject(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Nap(2); // date字段没变.

        // Now get them back:
        try (
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream("ThinkingInJava/src/" +
                                "chap37_serialization/Logon.dat"))
        ) {
            System.out.println(
                    "Recovering object at " + new Date());
            a = (Logon) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logon a = " + a); // String password变成了"null".
    }
}
