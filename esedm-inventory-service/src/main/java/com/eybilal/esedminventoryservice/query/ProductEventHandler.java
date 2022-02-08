package com.eybilal.esedminventoryservice.query;

import com.eybilal.esedminventoryservice.core.event.ProductCreatedEvent;
import com.eybilal.esedminventoryservice.core.entity.Product;
import com.eybilal.esedminventoryservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventHandler {
    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        Product product = Product.builder()
                .name(productCreatedEvent.getName())
                .description(productCreatedEvent.getDescription())
                .price(productCreatedEvent.getPrice())
                .quantity(productCreatedEvent.getQuantity())
                .build();

        // Product product = new Product();
        // BeanUtils.copyProperties(productCreatedEvent, product);

        productRepository.save(product);
    }
}
