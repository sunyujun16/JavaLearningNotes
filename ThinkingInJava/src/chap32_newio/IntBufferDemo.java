package chap32_newio;

// Manipulating ints in a ByteBuffer with an IntBuffer

import java.nio.*;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();

        // Store an array of int:
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});

        // Absolute location read and write:
        System.out.println(ib.get(3) + "got.");
        ib.put(3, 1811);

        // Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }
    }
}
