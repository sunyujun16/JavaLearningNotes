package chap09_Interface;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;

class StringGenerator{
    private int size;
    char[] lib = "abcddasdflkhajgsdljhjsadf".toCharArray();
    char[] word;

    Random rand = new Random(47);

    StringGenerator(int size) {
        this.size = size;
        word = new char[size];
    }

    char[] getWord(){
        for(int i = 0; i < size; i++){
            word[i] = lib[rand.nextInt(20)];
        }
        return word;
    }
}

public class E16_Adapter implements Readable {
    private int count;
    StringGenerator sg = new StringGenerator(10);

    public E16_Adapter(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {



        return 0;
    }
}
