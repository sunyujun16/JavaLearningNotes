package chap37_serialization;

// Reconstructing an externalizable object

import java.io.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s; // No initialization

    public Blip3() {
        System.out.println("Blip3 Constructor");
        // s, i not initialized
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a) --");
        s = x;
        i = a;
        // s & i initialized only in non-no-arg constructor.
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip3.writeExternal");
        // tips: 如果有基类, 那么得先调用基类的方法, 保证先把基类的数据恢复到正确状态.
        // You must do this:
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // You must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) {
        System.out.println("\nConstructing objects:");
        Blip3 b3 = new Blip3("啊~斯坠鹰 ", 47);
        System.out.println(b3);

        try (
                ObjectOutputStream o = new ObjectOutputStream(
                        new FileOutputStream("ThinkingInJava/src/" +
                                "chap37_serialization/Blip3.serialized"))
        ) {
            System.out.println("\nSaving object:");
            o.writeObject(b3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Now get it back:
        System.out.println("\nRecovering b3:");
        try (
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream("ThinkingInJava/src/" +
                                "chap37_serialization/Blip3.serialized"))
        ) {
            b3 = (Blip3) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println(b3);
    }
}
