package com.eybilal.esedminventoryservice.command.controller;

import com.eybilal.esedminventoryservice.core.command.CreateProductCommand;
import com.eybilal.esedminventoryservice.core.dto.ProductDto;
import com.eybilal.esedminventoryservice.core.entity.Category;
import com.eybilal.esedminventoryservice.core.entity.Product;
import com.eybilal.esedminventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping(InventoryRestCommandController.BASE_PATH)
public class InventoryRestCommandController {
    public static final String BASE_PATH = "/api/v2";

    private final InventoryService inventoryService;
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    /***************************************** Categories *****************************************/
    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody @Validated final Category category) {
        return inventoryService.createCategory(category);
    }

    @PutMapping(path = "/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody @Validated Category category) {
        return inventoryService.updateCategory(id, category);
    }


    /***************************************** Products *****************************************/
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> createProduct(@RequestBody @Valid final ProductDto productDto) {
        // We cannot use mapstruct, because Command must be immutable (created without setter, and mapstruct do create with setter)
        // The ONLY WAY to create command is the constructor or builder
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

        return commandGateway.send(createProductCommand);
    }

    @PutMapping(path = "/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody @Validated Product product) {
        return inventoryService.updateProduct(id, product);
    }

    /***************************************** Event Store *****************************************/
    @GetMapping(path = "products/event-store/{id}")
    public Stream eventStoreProduct(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }
}
