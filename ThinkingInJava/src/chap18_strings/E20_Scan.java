package chap18_strings;

import java.util.Scanner;

public class E20_Scan {
    private int i;
    private long l;
    private double d;
    private float f;
    private String s;

    E20_Scan(String ss){
        Scanner scanner = new Scanner(ss);
        while (scanner.hasNext()){
            i = scanner.nextInt();
            l = scanner.nextLong();
            d = scanner.nextDouble();
            f = scanner.nextFloat();
            s = scanner.next();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("+");
        sb.append(l);
        sb.append("+");
        sb.append(d);
        sb.append("+");
        sb.append(f);
        sb.append("+");
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        E20_Scan scan = new E20_Scan("12 4567 12.034 2.56 沙漠");
        System.out.println(scan);
    }
}
