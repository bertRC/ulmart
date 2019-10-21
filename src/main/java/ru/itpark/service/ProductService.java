package ru.itpark.service;

import ru.itpark.repository.ProductRepository;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
}
