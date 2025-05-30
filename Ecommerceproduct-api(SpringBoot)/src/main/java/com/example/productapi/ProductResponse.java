package com.example.productapi;

public class ProductResponse {
    private Long id;
    private String name;
    private double price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}