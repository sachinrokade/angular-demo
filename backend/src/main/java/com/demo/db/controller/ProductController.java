package com.demo.db.controller;

import com.demo.db.dto.Product;
import com.demo.db.repo.ProductRepository;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@CrossOrigin(origins = "https://redesigned-orbit-4j4xvgg99xrh7779-4200.app.github.dev/")
@RequestMapping("/")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/load/data")
    public String addBulkData() throws StreamWriteException, DatabindException, IOException {
    //     List<Map<String, Object>> products = new ArrayList<>();

    //     // Generate 490 more products
    //     for (int i = 11; i <= 500; i++) {
    //         int price = 1000 + (i * 37) % 50000; // Generate varied prices
    //         addProduct(products, "Product " + i, price);
    //     }
    //    productRepository.saveAll(products.stream().map([/]));

        return "✅ Generated  products in products.json";
    }

    private static void addProduct(List<Map<String, Object>> products, String name, int price) {
        Map<String, Object> product = new HashMap<>();
        product.put("name", name);
        product.put("price", price);
        products.add(product);
    }

}
