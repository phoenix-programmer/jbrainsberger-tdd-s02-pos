package org.shevek.pos;

import java.math.*;
import java.util.*;

public class Amount {

    private final String currency;
    private final BigDecimal amount;

    public Amount(String currency, BigDecimal amount) {
        if (currency == null || amount == null) {
            throw new IllegalArgumentException();
        }
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s", currency, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Amount amount1 = (Amount) o;
        return currency.equals(amount1.currency) && amount.equals(amount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
