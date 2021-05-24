package chap15_exceptions;

class MyException12 extends Exception{
    private String s;

    public MyException12(String message) {
        // 显然, 此行省略时, 默认调用父类的无参构造方法.
//        super(message);
        this.s = message;
    }

    void show(){
        System.out.println(s);
    }
}

public class E04_Customize {
    public static void main(String[] args) {
        try{
            throw new MyException12("My exception 2");
        }catch(MyException12 me){
            me.show();
        }
    }


}
