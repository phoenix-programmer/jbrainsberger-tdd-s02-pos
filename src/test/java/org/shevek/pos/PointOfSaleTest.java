package org.shevek.pos;

import org.junit.jupiter.api.*;

import java.math.*;

import static java.util.Collections.singletonList;
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

    @Test
    @DisplayName("Existent Bar Code when just one product loaded")
    void existentBarCodeWhenJustOneProductLoaded() {
        LCDDisplay lcdDisplay = new LCDDisplay();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay, singletonList(new Product("123", "Hammer - Black & Decker", BigDecimal.valueOf(20.5))));
        pointOfSale.onBarCode("123");
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("20.5");
    }
}
