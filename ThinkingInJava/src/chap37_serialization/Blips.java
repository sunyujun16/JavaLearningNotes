package chap37_serialization;

// Simple use of Externalizable & a pitfall

import java.io.*;

class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    public Blip2() {
        System.out.println("Blip2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        try (
                ObjectOutputStream o = new ObjectOutputStream(
                        new FileOutputStream("ThinkingInJava/src/" +
                                "chap37_serialization/Blips.serialized"))
        ) {
            System.out.println("\nSaving objects:");
            o.writeObject(b1);
            o.writeObject(b2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Now get them back:
        System.out.println("\nRecovering b1:");
        try (
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream("ThinkingInJava/src/" +
                                "chap37_serialization/Blips.serialized"))
        ) {
            b1 = (Blip1) in.readObject();
            System.out.println("\nRecovering b2:");
            b2 = (Blip2)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // in 已经关闭了个鸡儿的了, 还in个粑粑...
        // 妈的中计了...try-resource 只是掩人耳目...这作者太坏了, 太他妈坏了, 呸!
        // OOPS! Throws an exception:
//        System.out.println("\nRecovering b2:");
//        b2 = (Blip2)in.readObject();
    }
}
