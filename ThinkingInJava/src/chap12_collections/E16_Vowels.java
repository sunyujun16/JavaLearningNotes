package chap12_collections;

public class E16_Vowels {
    public static void main(String[] args) throws Exception {
        String[] a = new String[0]; // 可以生成没有长度的数组
//        a[0] = "1";  // 但是因为没有长度, 所以不能操作.
        A08_UniqueWords.main(a);
        System.out.println(a);
    }

}
