package chap32_newio;

// Locking portions of a mapped file

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFFF; // 128 MB
    static FileChannel fc;

    public static void main(String[] args) throws Exception {
        fc = new RandomAccessFile("ThinkingInJava/src/"
                + "chap32_newio/test.dat", "rw")
                .getChannel();
        MappedByteBuffer out = fc.map(
                FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++)
            out.put((byte) 'x');

        new LockAndModify(out, 0, 0 + LENGTH / 3);
        new LockAndModify(
                out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buff = mbb.slice();
            start();
        }

        @Override
        public void run() {
            try {
                // Exclusive lock with no overlap:
                FileLock fl = fc.lock(start, end, false);
                System.out.println(
                        "Locked: " + start + " to " + end);
                // Perform modification:
                while (buff.position() < buff.limit() - 1)
                    buff.put((byte) (buff.get() + 1));//执行一次走两步,但无所谓,
                // 因为buff.position()时刻把控着界限.
                fl.release();
                System.out.println(
                        "Released: " + start + " to " + end);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
