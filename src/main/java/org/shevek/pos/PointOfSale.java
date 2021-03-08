package org.shevek.pos;

import java.util.*;

public class PointOfSale {

    private static final String INVALID_INPUT = "Invalid input";
    private static final String PRODUCT_NOT_FOUND = "Product Not Found";
    private final LCDDisplay lcdDisplay;
    private final List<Product> products;

    public PointOfSale(LCDDisplay lcdDisplay) {
        this(lcdDisplay, Collections.emptyList());
    }

    public PointOfSale(LCDDisplay lcdDisplay, List<Product> products) {
        this.lcdDisplay = lcdDisplay;
        this.products = products;
    }

    public void onBarCode(String barCode) {
        if (barCode == null || barCode.isEmpty()) {
            lcdDisplay.setText(INVALID_INPUT);
            return;
        }
        if (products.isEmpty()) {
            lcdDisplay.setText(PRODUCT_NOT_FOUND);
            return;
        }
        lcdDisplay.setText(products.get(0).getPrice().toString());
    }
}
