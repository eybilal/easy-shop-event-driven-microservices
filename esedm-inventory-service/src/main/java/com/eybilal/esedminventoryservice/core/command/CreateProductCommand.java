package com.eybilal.esedminventoryservice.core.command;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
public class CreateProductCommand extends BaseCommand<String> {
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final int quantity;
}
