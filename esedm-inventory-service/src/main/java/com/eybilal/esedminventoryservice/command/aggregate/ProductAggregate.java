package com.eybilal.esedminventoryservice.command.aggregate;

import com.eybilal.esedminventoryservice.core.command.CreateProductCommand;
import com.eybilal.esedminventoryservice.core.event.ProductCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor  // Required by Axon (constructor without params)
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;

    // Required by Axon (constructor with params)
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        // Validation done with @valid in controller

        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder()
                .id(createProductCommand.getId())
                .name(createProductCommand.getName())
                .description(createProductCommand.getDescription())
                .price(createProductCommand.getPrice())
                .quantity(createProductCommand.getQuantity())
                .build();

        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        this.id = productCreatedEvent.getId();
        this.name = productCreatedEvent.getName();
        this.description = productCreatedEvent.getDescription();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
    }
}
