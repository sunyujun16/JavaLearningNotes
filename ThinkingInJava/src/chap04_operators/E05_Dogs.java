package chap04_operators;

public class E05_Dogs {
    private String name;
    private String says;

    private E05_Dogs() {
    }

    private E05_Dogs(String name, String says){
        this.name = name;
        this.says = says;
    }

    // Auto generated.
//    private E05_Dogs(String name, String says) {
//        this.name = name;
//        this.says = says;
//    }

    private void showInfo(){
        System.out.println("name: " + name + "\nsays: " + says);
    }

    /** @noinspection ConstantConditions, UnnecessaryLocalVariable */
    public static void main(String[] args) {
        E05_Dogs d1 = new E05_Dogs("spot","haha");
        E05_Dogs d2 = new E05_Dogs();
        E05_Dogs d3 = d1;
        d2.name = "screw";
        d2.says = "fuck";

        d1.showInfo();
        d2.showInfo();

        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
        System.out.println(d1 == d3);
        System.out.println(d1.equals(d3));

    }

}
