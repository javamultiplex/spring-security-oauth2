package com.javamultiplex.controller;

import com.javamultiplex.model.Product;
import com.javamultiplex.model.Provider;
import com.javamultiplex.proxies.ProviderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Rohit Agarwal on 21/01/21 7:15 pm
 * @copyright www.javamultiplex.com
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProviderProxy providerProxy;

    private List<Product> products = Stream.of(
            new Product(1, "Product1", 1),
            new Product(2, "Product1", 1),
            new Product(3, "Product1", 2)
    ).collect(Collectors.toList());


    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getDetails(@PathVariable int id) {
        Optional<Product> optionalProduct = products
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst();
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product product = optionalProduct.get();
        Provider provider = providerProxy.getDetails(product.getProviderId());
        product.setProvider(provider);
        return ResponseEntity.ok(product);
    }
}
