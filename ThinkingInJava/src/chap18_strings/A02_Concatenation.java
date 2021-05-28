package chap18_strings;

public class A02_Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
/* 精简的JVM字节码
public static void main(java.lang.String[]);
 Code:
  Stack=2, Locals=3, Args_size=1
  0: ldc #2; //String mango
  2: astore_1
  3: new #3; //class StringBuilder
  6: dup
  7: invokespecial #4; //StringBuilder."":()
  10: ldc #5; //String abc
  12: invokevirtual #6; //StringBuilder.append:(String)
  15: aload_1
  16: invokevirtual #6; //StringBuilder.append:(String)
  19: ldc #7; //String def
  21: invokevirtual #6; //StringBuilder.append:(String)
  24: bipush 47
  26: invokevirtual #8; //StringBuilder.append:(I)
  29: invokevirtual #9; //StringBuilder.toString:()
  32: astore_2
  33: getstatic #10; //Field System.out:PrintStream;
  36: aload_2
  37: invokevirtual #11; //PrintStream.println:(String)
  40: return
*/