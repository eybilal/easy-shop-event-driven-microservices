package com.eybilal.esedminventoryservice.core.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private String id;

    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @Min(value=0, message = "Price cannot be lower than zero")
    private BigDecimal price;

    @Min(value=0, message = "Quantity cannot be lower than one")
    private int quantity;
}
