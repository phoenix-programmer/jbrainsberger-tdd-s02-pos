package org.shevek.pos;

import java.math.*;

public class Product {

    private final String barCode;
    private final String name;
    private final BigDecimal price;

    public Product(String barCode, String name, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }
}
