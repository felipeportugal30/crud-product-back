package com.bd.crud_product.service;

import com.bd.crud_product.model.Product;
import com.bd.crud_product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        logger.info("Tentando salvar o produto: {}", product);
        int rowsAffected = productRepository.save(product);
        if (rowsAffected > 0) {
            return product;
        } else {
            throw new RuntimeException("Erro ao salvar produto");
        }
    }

    public Product update(Long id, Product productUpdate) {
        int rowsAffected = productRepository.update(id, productUpdate);
        if (rowsAffected > 0) {
            return productUpdate;
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    public void delete(Long id) {
        int rowsAffected = productRepository.delete(id);
        if (rowsAffected == 0) {
            throw new RuntimeException("Produto não encontrado");
        }
    }
}
