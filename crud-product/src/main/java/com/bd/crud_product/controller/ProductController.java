package com.bd.crud_product.controller;

import com.bd.crud_product.model.Product;
import com.bd.crud_product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/listAll")
    public List<Product> listAll() {
        return productService.listAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        try {
            Product update  = productService.update(id, product);
            return ResponseEntity.ok(update);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
