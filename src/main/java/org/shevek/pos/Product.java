package org.shevek.pos;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
public class Product {

    private final String barCode;
    private final String name;
    private final Amount price;

}
