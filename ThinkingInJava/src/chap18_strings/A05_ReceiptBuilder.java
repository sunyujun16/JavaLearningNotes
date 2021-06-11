package chap18_strings;

import java.util.*;

public class A05_ReceiptBuilder {
    private double total = 0;
    private Formatter f = new Formatter(new StringBuilder());
    private static final int WIDTH = 15;

    public A05_ReceiptBuilder() {
        f.format("%-" + WIDTH + "s %5s %10s%n", "Item", "Qty", "Price");
        f.format("%-" + WIDTH + "s %5s %10s%n", "----", "---", "-----");
    }

    public void add(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f%n", name, qty, price);
        total += price * qty;
    }

    public String build() {
        // 还特么缴税, 太细了...
        f.format("%-15s %5s %10.2f%n", "Tax  ", "", total * 0.06);
        f.format("%-15s %5s %10s%n", "", "", "-----");
        f.format("%-15s %5s %10.2f%n", "Total", "", total * 1.06);
        return f.toString();
    }

    public static void main(String[] args) {
        A05_ReceiptBuilder receiptBuilder =
                new A05_ReceiptBuilder();
        receiptBuilder.add("Jack's Magic Beans", 4, 4.25);
        receiptBuilder.add("Princess Peas", 3, 5.1);
        receiptBuilder.add(
                "Three Bears Porridge", 1, 14.29);
        System.out.println(receiptBuilder.build());
    }
}
