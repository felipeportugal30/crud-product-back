package com.bd.crud_product.repository;

import com.bd.crud_product.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Mapeamento do banco para um objeto Product
    private final RowMapper<Product> productRowMapper = (rs, rowNum) -> new Product(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getDouble("price"),  // Alterado de BigDecimal para Double (conforme seu modelo)
            rs.getString("type"),
            rs.getInt("stock")      // Alterado de getLong para getInt
    );

    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products", productRowMapper);
    }

    public Optional<Product> findById(Long id) {
        List<Product> products = jdbcTemplate.query("SELECT * FROM products WHERE id = ?", productRowMapper, id);
        return products.stream().findFirst();
    }

    public int save(Product product) {
        return jdbcTemplate.update(
                "INSERT INTO products (name, price, type, stock) VALUES (?, ?, ?, ?)",
                product.getName(), product.getPrice(), product.getType(), product.getStock()
        );
    }

    public int update(Long id, Product product) {
        return jdbcTemplate.update(
                "UPDATE products SET name = ?, price = ?, type = ?, stock = ? WHERE id = ?",
                product.getName(), product.getPrice(), product.getType(), product.getStock(), id
        );
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
    }
}
