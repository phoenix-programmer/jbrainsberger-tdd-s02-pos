package org.shevek.pos;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class PointOfSaleTest {

    @Test
    @DisplayName("Null input should result with Invalid Input message")
    void nulllInputShouldResultWithInvalidInputMessage() {
        LCDDisplay lcdDisplay = new LCDDisplay();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay);
        pointOfSale.onBarCode(null);
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("Invalid input");
    }

    @Test
    @DisplayName("Empty String should result with Invalid Input message")
    void emptyStringShouldResultWithInvalidInputMessage() {
        LCDDisplay lcdDisplay = new LCDDisplay();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay);
        pointOfSale.onBarCode("");
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("Invalid input");
    }

    @Test
    @DisplayName("Inexistent product should result with Product Not Found message")
    void inexistentProductShouldResultWithProductNotFoundMessage() {
        LCDDisplay lcdDisplay = new LCDDisplay();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay);
        pointOfSale.onBarCode("123");
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("Product Not Found");
    }
}
