package com.demo.db.config;

import com.demo.db.dto.Product;
import com.demo.db.repo.ProductRepository;

import java.util.List;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DummyDataLoader {

    private final ProductRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public DummyDataLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        System.out.println("✅ ACTUAL DB: " + mongoTemplate.getDb().getName());
        
mongoTemplate.getCollectionNames()
        .forEach(collection -> System.out.println("📦 Collection: " + collection));

        System.out.println("✅ ACTUAL DB Collection : " +mongoTemplate.getCollectionName(Product.class));

        
        System.out.println("🚀 DummyDataLoader started...");

        try {
            // clear old data
            repository.deleteAll();

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("data/products.json");

            if (is == null) {
                System.out.println("❌ ERROR: products.json not found");
                return;
            }

            List<Product> products = mapper.readValue(
                    is, new TypeReference<List<Product>>() {}
            );

            System.out.println("✅ Loaded JSON records: " + products.size());

            repository.saveAll(products);

            System.out.println("✅ Inserted count: " + repository.count());

        } catch (Exception e) {
            System.out.println("❌ ERROR loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}