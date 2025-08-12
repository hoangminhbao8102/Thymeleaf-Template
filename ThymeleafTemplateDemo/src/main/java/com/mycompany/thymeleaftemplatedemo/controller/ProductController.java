/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thymeleaftemplatedemo.controller;

import com.mycompany.thymeleaftemplatedemo.model.Product;
import com.mycompany.thymeleaftemplatedemo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author 20113
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // LIST
    @GetMapping
    public String list(Model model,
                       @RequestParam(value = "msg", required = false) String msg) {
        model.addAttribute("products", service.findAll());
        model.addAttribute("pageTitle", "Product List");
        if (msg != null) model.addAttribute("msg", msg);
        return "products/list";
    }

    // CREATE - form
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Create Product");
        return "products/form";
    }

    // CREATE - submit
    @PostMapping
    public String create(@Valid @ModelAttribute("product") Product product,
                         BindingResult result,
                         Model model,
                         RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Create Product");
            return "products/form";
        }
        service.create(product);
        ra.addFlashAttribute("msg", "Created successfully.");
        return "redirect:/products";
    }

    // DETAIL
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Product p = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("product", p);
        model.addAttribute("pageTitle", "Product Detail");
        return "products/detail";
    }

    // EDIT - form
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Product p = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("product", p);
        model.addAttribute("pageTitle", "Edit Product");
        return "products/form";
    }

    // EDIT - submit
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("product") Product product,
                         BindingResult result,
                         Model model,
                         RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Edit Product");
            return "products/form";
        }
        service.update(id, product);
        ra.addFlashAttribute("msg", "Updated successfully.");
        return "redirect:/products";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ra) {
        service.delete(id);
        ra.addFlashAttribute("msg", "Deleted successfully.");
        return "redirect:/products";
    }
}
