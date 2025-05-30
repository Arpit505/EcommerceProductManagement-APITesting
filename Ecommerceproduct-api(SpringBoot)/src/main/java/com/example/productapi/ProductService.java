package com.example.productapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductResponse> getAll() {
        return repo.findAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    public ProductResponse getById(Long id) {
        Product product = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponse(product);
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return new ProductResponse(repo.save(product));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}