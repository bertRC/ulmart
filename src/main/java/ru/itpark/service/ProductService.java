package ru.itpark.service;

import ru.itpark.model.AbstractProduct;
import ru.itpark.repository.ProductRepository;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void add(AbstractProduct item) {
        if (item.getId() != 0) {
            throw new IllegalArgumentException("id must be 0");
        }
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("price must be greater than 0");
        }
        if (item.getRating() < 0 || item.getRating() > 5) {
            throw new IllegalArgumentException("rating must be in the range 0 through 5");
        }
        repository.save(item);
    }
}
