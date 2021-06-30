package chap32_newio;

import java.nio.*;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(
                new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        System.out.print("Byte Buffer ");
        while (bb.hasRemaining())
            System.out.print(
                    bb.position() + " -> " + bb.get() + ", ");
        System.out.println();

        // java的char是16位字节.
        CharBuffer cb =
                ((ByteBuffer) bb.rewind()).asCharBuffer();
        System.out.print("Char Buffer ");
        while (cb.hasRemaining())
            System.out.print(
                    cb.position() + " -> " + cb.get() + ", ");
        System.out.println();

        // 32位
        FloatBuffer fb =
                ((ByteBuffer) bb.rewind()).asFloatBuffer();
        System.out.print("Float Buffer ");
        while (fb.hasRemaining())
            System.out.print(
                    fb.position() + " -> " + fb.get() + ", ");
        System.out.println();

        // 32位
        IntBuffer ib =
                ((ByteBuffer) bb.rewind()).asIntBuffer();
        System.out.print("Int Buffer ");
        while (ib.hasRemaining())
            System.out.print(
                    ib.position() + " -> " + ib.get() + ", ");
        System.out.println();

        // 64位
        LongBuffer lb =
                ((ByteBuffer) bb.rewind()).asLongBuffer();
        System.out.print("Long Buffer ");
        while (lb.hasRemaining())
            System.out.print(
                    lb.position() + " -> " + lb.get() + ", ");
        System.out.println();

        // 16位
        ShortBuffer sb =
                ((ByteBuffer) bb.rewind()).asShortBuffer();
        System.out.print("Short Buffer ");
        while (sb.hasRemaining())
            System.out.print(
                    sb.position() + " -> " + sb.get() + ", ");
        System.out.println();

        // 64位
        DoubleBuffer db =
                ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        System.out.print("Double Buffer ");
        while (db.hasRemaining())
            System.out.print(
                    db.position() + " -> " + db.get() + ", ");
    }
}
