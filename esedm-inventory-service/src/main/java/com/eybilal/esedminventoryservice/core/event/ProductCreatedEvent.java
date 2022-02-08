package com.eybilal.esedminventoryservice.core.event;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
public class ProductCreatedEvent extends BaseEvent<String> {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int quantity;
}
