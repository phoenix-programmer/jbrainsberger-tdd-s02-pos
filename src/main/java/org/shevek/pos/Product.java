package org.shevek.pos;

public class Product {

    private final String barCode;
    private final String name;
    private final Amount price;

    public Product(String barCode, String name, Amount price) {
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public Amount getPrice() {
        return price;
    }
}
