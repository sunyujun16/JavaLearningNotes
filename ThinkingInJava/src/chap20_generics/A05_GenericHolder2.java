package chap20_generics;

class GenericHolder2<T> {
    private T obj;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public static void main(String[] args) {
        GenericHolder2<String> holder = new GenericHolder2<>();
        holder.set("Item");
        String s = holder.get();
    }
}

public class A05_GenericHolder2 {
}
/*
public void set(java.lang.Object);
0: aload_0
1: aload_1
2: putfield #2; //Field obj:Object;
5: return
public java.lang.Object get();
0: aload_0
1: getfield #2; //Field obj:Object;
4: areturn
public static void main(java.lang.String[]);
0: new #3; //class GenericHolder2
3: dup
4: invokespecial #4; //Method "<init>":()V
7: astore_1
8: aload_1
9: ldc #5; //String Item
11: invokevirtual #6; //Method set:(Object;)V
14: aload_1
15: invokevirtual #7; //Method get:()Object;
18: checkcast #8; //class java/lang/String
21: astore_2
22: return
*/