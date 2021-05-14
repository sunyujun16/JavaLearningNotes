package chap10_interface;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

class StringGenerator {
    private int size;
    private char[] lib = "abcddasdflkhajgsdljhjsadf".toCharArray();
    private char[] word;

    private Random rand = new Random(47);

    StringGenerator(int size) {
        this.size = size;
        word = new char[size];
    }

    char[] getWord() {
        for (int i = 0; i < size; i++) {
            word[i] = lib[rand.nextInt(20)];
        }
//        System.out.println(Arrays.toString(word));
        return word;
    }
}

// 适配器, 以现有类作为成员变量(也可以作为构造方法的参数传入), 并通过实现Readable接口来链接Scanner.
public class E16_Adapter implements Readable {
    private int count;
    private StringGenerator sg = new StringGenerator(10);

    E16_Adapter(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;

        for (int i = 0; i < sg.getWord().length; i++) {
            cb.append(sg.getWord()[i]);
        }
        cb.append('\n');

        return 1;
    }

    public static void main(String[] args) {
//        StringGenerator sg = new StringGenerator(10);
//        sg.getWord();
        int k = 0;

        Scanner sc = new Scanner(new E16_Adapter(5));
        while (sc.hasNext()) {
            System.out.println(sc.next()); //很奇怪这里不会自动打印\n.
            k++;
        }
        System.out.println(k);
    }
}
