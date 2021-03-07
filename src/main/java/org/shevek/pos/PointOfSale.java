package org.shevek.pos;

public class PointOfSale {

    private final LCDDisplay lcdDisplay;

    public PointOfSale(LCDDisplay lcdDisplay) {
        this.lcdDisplay = lcdDisplay;
    }

    public void onBarCode(String barCode) {
        if (barCode != null && !barCode.isEmpty()) {
            lcdDisplay.setText(barCode);
        }
    }
}
