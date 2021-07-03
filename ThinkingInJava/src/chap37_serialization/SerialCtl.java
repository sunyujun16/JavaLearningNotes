package chap37_serialization;

// Controlling serialization by adding your own
// writeObject() and readObject() methods

import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream)
            throws IOException {
        stream.defaultWriteObject(); // default保证了非transient数据的恢复
        stream.writeObject(b); // 而transient数据则需要手动写入和恢复.
    }

    private void readObject(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);
        try (
                ByteArrayOutputStream buf =
                        new ByteArrayOutputStream();
                ObjectOutputStream o =
                        new ObjectOutputStream(buf);
        ) {
            o.writeObject(sc);

            // Now get it back:
            try (
                    ObjectInputStream in =
                            new ObjectInputStream(
                                    new ByteArrayInputStream(
                                            buf.toByteArray()));
            ) {
                SerialCtl sc2 = (SerialCtl) in.readObject();
                System.out.println("After:\n" + sc2);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
