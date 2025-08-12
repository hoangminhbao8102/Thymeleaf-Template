/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thymeleaftemplatedemo.model;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/**
 *
 * @author 20113
 */
public class Product {
    private Long id;

    @NotBlank(message = "{product.name.notBlank}")
    @Size(max = 100, message = "{product.name.size}")
    private String name;

    @Size(max = 255, message = "{product.desc.size}")
    private String description;

    @NotNull(message = "{product.price.notNull}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{product.price.min}")
    private BigDecimal price;

    @NotNull(message = "{product.stock.notNull}")
    @Min(value = 0, message = "{product.stock.min}")
    private Integer stock;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
