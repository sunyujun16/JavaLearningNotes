package chap32_newio;

// Getting different representations from a ByteBuffer

import java.nio.*;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);

// Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                System.out.println("nonzero"); // no output
        System.out.println("i = " + i); // 1025
        bb.rewind();

// Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c + " "); // H o w d y !
        System.out.println();
        bb.rewind();

// Store and read a short: short是16位
        bb.asShortBuffer().put((short) 471142); // 字节截断
        // 0000 0000 0000 0111 0011 0000 0110 0110, 后16位正好是12390
        // 这里貌似是低位优先, 也就是0011 0000 0110 0110 0000 0000 0000 0111
        System.out.println(bb.getShort()); // 为啥是低位优先呢?
//        System.out.println(bb.getShort()); // 111
        bb.rewind();

// Store and read an int:
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        bb.rewind();

// Store and read a long:
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        bb.rewind();

// Store and read a float:
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        bb.rewind();

// Store and read a double:
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
    }
}
