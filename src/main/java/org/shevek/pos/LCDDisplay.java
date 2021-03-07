package org.shevek.pos;

public class LCDDisplay {

    private String text;

    public String lastDisplayedText() {
        return text == null ? "Invalid input" : "Product Not Found";
    }

    public void setText(String text) {
        this.text = text;
    }
}
