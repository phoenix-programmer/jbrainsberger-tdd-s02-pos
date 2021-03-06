package org.shevek.pos;

import org.junit.jupiter.api.*;

import java.math.*;
import java.util.*;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

public class SellOneItemTest {

    private static final Product BLACK_AND_DECKER_HAMMER = Product.builder()
            .barCode("123")
            .name("Hammer - Black & Decker")
            .price(new Amount("USD", BigDecimal.valueOf(20.5)))
            .build();
    private static final Product GENERIC_PHILLIPS_SCREWDRIVER = Product.builder()
            .barCode("776")
            .name("Generic Phillips Screwdriver")
            .price(new Amount("USD", BigDecimal.valueOf(5.8)))
            .build();

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
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay, singletonList(BLACK_AND_DECKER_HAMMER));
        pointOfSale.onBarCode("123");
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("USD 20.5");
    }

    @Test
    @DisplayName("Inexistent Bar Code when there are products")
    void inexistentBarCodeWhenThereAreProducts() {
        LCDDisplay lcdDisplay = new LCDDisplay();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay, singletonList(BLACK_AND_DECKER_HAMMER));
        pointOfSale.onBarCode("567");
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("Product Not Found");
    }

    @Test
    @DisplayName("Existent Bar Code when there are several products")
    void existentBarCodeWhenThereAreSeveralProducts() {
        LCDDisplay lcdDisplay = new LCDDisplay();
        PointOfSale pointOfSale = new PointOfSale(lcdDisplay, List.of(BLACK_AND_DECKER_HAMMER, GENERIC_PHILLIPS_SCREWDRIVER));
        pointOfSale.onBarCode("776");
        assertThat(lcdDisplay.lastDisplayedText()).isEqualTo("USD 5.8");
    }
}
