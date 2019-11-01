package ru.itpark.service;

import ru.itpark.model.AbstractProduct;
import ru.itpark.repository.ProductRepository;

import java.util.*;

public class ProductService {
    private final ProductRepository repository;
    public static final int minTextLength = 3;
    public static final int minRating = 0;
    public static final int maxRating = 5;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public List<AbstractProduct> searchByName(String text) {
        if (text.length() < minTextLength) {
            throw new IllegalArgumentException("text must contain at least 3 characters");
        }
        List<AbstractProduct> result = new LinkedList<>();
        for (AbstractProduct item : repository.getAll()) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                result.add(item);
            }
        }
        result.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return result;
    }

    public List<AbstractProduct> searchByType(String productType) {
        List<AbstractProduct> result = new LinkedList<>();
        for (AbstractProduct item : repository.getAll()) {
            if (item.match(productType)) {
                result.add(item);
            }
        }
        result.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return result;
    }

    public void add(Collection<AbstractProduct> items) {
        for (AbstractProduct item : items) {
            if (item.getId() != 0) {
                throw new IllegalArgumentException("id must be 0");
            }
            if (item.getPrice() <= 0) {
                throw new IllegalArgumentException("price must be greater than 0");
            }
            if (item.getRating() < minRating || item.getRating() > maxRating) {
                throw new IllegalArgumentException("rating must be in the range 0 through 5");
            }
            repository.save(item);
        }
    }

    public void add(AbstractProduct... items) {
        Collection<AbstractProduct> products = new LinkedList<>(Arrays.asList(items));
        add(products);
    }

    public boolean remove(int id) {
        return repository.delete(id);
    }

    public List<AbstractProduct> getSortedByPrice() {
        return getSortedBy((o1, o2) -> o1.getPrice() - o2.getPrice());
    }

    public List<AbstractProduct> getSortedByPriceDesc() {
        return getSortedBy((o1, o2) -> -(o1.getPrice() - o2.getPrice()));
    }

    public List<AbstractProduct> getSortedByRating() {
        return getSortedBy((o1, o2) -> o1.getRating() - o2.getRating());
    }

    public List<AbstractProduct> getSortedByName() {
        return getSortedBy((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    private List<AbstractProduct> getSortedBy(Comparator<AbstractProduct> comparator) {
        List<AbstractProduct> result = new LinkedList<>(repository.getAll());
        result.sort(comparator);
        return result;
    }

    public List<AbstractProduct> getSubList(int pageNumber, int amountPerPage, List<AbstractProduct> items) {
        return items.subList((pageNumber - 1) * amountPerPage, Math.min(pageNumber * amountPerPage, items.size()));
    }
}
