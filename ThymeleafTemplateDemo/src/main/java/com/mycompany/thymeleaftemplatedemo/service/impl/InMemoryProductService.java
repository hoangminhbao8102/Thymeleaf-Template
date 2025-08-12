/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thymeleaftemplatedemo.service.impl;

import com.mycompany.thymeleaftemplatedemo.model.Product;
import com.mycompany.thymeleaftemplatedemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author 20113
 */
@Service
public final class InMemoryProductService implements ProductService {

    private final Map<Long, Product> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public InMemoryProductService() {
        // Seed dữ liệu
        Product a = new Product();
        a.setName("Mechanical Keyboard");
        a.setDescription("Hot-swap, RGB");
        a.setPrice(new BigDecimal("79.90"));
        a.setStock(15);
        create(a);

        Product b = new Product();
        b.setName("Wireless Mouse");
        b.setDescription("Low-latency");
        b.setPrice(new BigDecimal("29.50"));
        b.setStock(40);
        create(b);
    }

    @Override
    public List<Product> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparing(Product::getId))
                .toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Product create(Product p) {
        long id = seq.incrementAndGet();
        p.setId(id);
        store.put(id, p);
        return p;
    }

    @Override
    public Product update(Long id, Product p) {
        if (!store.containsKey(id)) throw new NoSuchElementException("Product not found");
        p.setId(id);
        store.put(id, p);
        return p;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }
}
