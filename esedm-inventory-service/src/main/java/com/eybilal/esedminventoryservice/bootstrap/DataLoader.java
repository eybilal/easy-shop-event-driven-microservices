package com.eybilal.esedminventoryservice.bootstrap;

import com.eybilal.esedminventoryservice.entity.Category;
import com.eybilal.esedminventoryservice.repository.CategoryRepository;
import com.eybilal.esedminventoryservice.repository.ProductRepository;
import com.eybilal.esedminventoryservice.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initProducts();
    }

    private void initProducts() {
        Category category = categoryRepository.save(
                Category.builder()
                        .name("Health")
                        .build()
        );

        productRepository.save(
                Product.builder()
                       .name("Propolis Kapseln 30 St., 9,7 g")
                       .description("")
                       .category(category)
                       .build()
        );

        productRepository.save(
                Product.builder()
                       .name("Gelée Royale Abwehr plus Kapseln 30 St., 12 g")
                       .description("")
                       .category(category)
                       .build()
        );
    }
}
