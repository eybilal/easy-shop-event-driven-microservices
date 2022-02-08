package com.eybilal.esedminventoryservice.query.rest;

import com.eybilal.esedminventoryservice.core.entity.Category;
import com.eybilal.esedminventoryservice.core.entity.Product;
import com.eybilal.esedminventoryservice.query.FindProductQuery;
import com.eybilal.esedminventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping(InventoryRestQueryController.BASE_PATH)
public class InventoryRestQueryController {
    public static final String BASE_PATH = "/api/v2";

    private final InventoryService inventoryService;
    private final QueryGateway queryGateway;

    /***************************************** Categories *****************************************/
    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Category> findAllCategories(
            @RequestParam(required = false) String name
    ) {
        return inventoryService.findAllCategories(name);
    }

    @GetMapping(path = "/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category findCategoryById(@PathVariable Long id) {
        return inventoryService.findCategoryById(id);
    }

    @GetMapping(path = "/categories/{id}/products")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Product> findCategoryProductsById(@PathVariable Long id) {
        return inventoryService.findCategoryProductsById(id);
    }

    /***************************************** Products *****************************************/
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Product> findAllProducts(
            @RequestParam(required = false) String name
    ) {
        FindProductQuery findProductQuery = new FindProductQuery();
        return queryGateway.query(findProductQuery, ResponseTypes.multipleInstancesOf(Product.class)).join();
        // return inventoryService.findAllProducts(name);
    }

    @GetMapping(path = "/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProductById(@PathVariable Long id) {
        return inventoryService.findProductById(id);
    }
}
