package chap29_references;

// Tests cloning to see if reference
// destinations are also cloned
class Snake implements Cloneable {
    private Snake next;
    private char c;

    // Value of i == number of segments
    public Snake(int i, char x) {
        c = x;
        if (--i > 0)
            next = new Snake(i, (char) (x + 1));
    } // 构造器尾递归, 第一次出现.

    public void increment() {
        c++;
        if (next != null)
            next.increment();
    }

    @Override
    public String toString() {
        String s = ":" + c;
        if (next != null)
            s += next.toString();
        return s;
    }

    @Override
    public Snake clone() {
        try {
//            Snake ss = (Snake) super.clone();
//            if (next != null)
//                ss.next = next.clone(); // 线性递归.
//            return ss;
            return (Snake) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Snake s = new Snake(5, 'a');
        System.out.println("s = " + s);

        Snake s2 = s.clone();
        System.out.println("s2 = " + s2);

        s.increment();

        System.out.println(
                "after s.increment, s2 = " + s2);
    }
}

public class A02_Snake {
}
