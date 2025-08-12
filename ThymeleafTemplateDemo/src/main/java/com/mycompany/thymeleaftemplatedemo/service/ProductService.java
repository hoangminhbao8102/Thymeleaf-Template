/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thymeleaftemplatedemo.service;

import com.mycompany.thymeleaftemplatedemo.model.Product;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 20113
 */
public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product create(Product p);
    Product update(Long id, Product p);
    void delete(Long id);
}
