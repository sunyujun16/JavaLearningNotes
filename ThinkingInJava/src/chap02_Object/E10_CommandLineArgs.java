package chap02_Object;

public class E10_CommandLineArgs {
    public static void main(String[] args) {
        int i =0;
        for (String s: args){
            System.out.println(s);
            i++;
            System.out.println(i);
        }
    }
}
