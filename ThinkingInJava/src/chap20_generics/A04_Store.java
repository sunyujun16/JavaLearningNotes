package chap20_generics;

// Building a complex model using generic collections

import java.util.*;
import java.util.function.*;

import onjava.*;

class Product {
    private final int id;
    private String description;
    private double price;

    Product(int idNumber, String descr, double price) {
        id = idNumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description +
                ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Supplier<Product> generator =
            new Supplier<Product>() {
                private Random rand = new Random(47);

                @Override
                public Product get() {
                    return new Product(rand.nextInt(1000), "Test",
                            Math.round(
                                    rand.nextDouble() * 1000.0) + 0.99);
                }
            };
}

class Shelf extends ArrayList<Product> {
    Shelf(int nProducts) {
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        for (int i = 0; i < nShelves; i++)
            add(new Shelf(nProducts));
    }
}

class CheckoutStand {
}

class Office {
}

class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts =
            new ArrayList<>();
    private Office office = new Office();

    public Store(
            int nAisles, int nShelves, int nProducts) {
        for (int i = 0; i < nAisles; i++)
            add(new Aisle(nShelves, nProducts));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this)
            for (Shelf s : a)
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));

//        Random rand = new Random(47);
//        for (int i = 0; i < 1000; i++) {
//            double d = Math.round(
//                    rand.nextDouble() * 10.0) + 0.99;
//            System.out.println(d);
//        }
    }
}

public class A04_Store {
}
