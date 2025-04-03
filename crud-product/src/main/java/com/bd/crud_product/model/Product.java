package com.bd.crud_product.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private String type;
    private int stock;

    // Construtor vazio
    public Product() {
    }

    // Construtor completo
    public Product(Long id, String name, Double price, String type, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
