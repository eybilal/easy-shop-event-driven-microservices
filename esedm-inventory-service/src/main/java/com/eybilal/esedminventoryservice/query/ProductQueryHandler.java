package com.eybilal.esedminventoryservice.query;

import com.eybilal.esedminventoryservice.core.entity.Product;
import com.eybilal.esedminventoryservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ProductQueryHandler {
    private final ProductRepository productRepository;

    @QueryHandler
    public Collection<Product> findAllProducts(FindProductQuery findProductQuery) {
        return productRepository.findAll();
    }
}
