package ru.itpark.repository;

import ru.itpark.model.AbstractProduct;

import java.util.Collection;
import java.util.LinkedList;

public class ProductRepository {
    private final Collection<AbstractProduct> products = new LinkedList<>();
    private long nextId = 1;

    public void save(AbstractProduct item) {
        item.setId(nextId++);
        products.add(item);
    }

    public boolean delete(int id) {
        boolean deleted = products.removeIf(abstractProduct -> abstractProduct.getId() == id);
        if (deleted) {
            nextId--;
            if (id < nextId) {
                for (AbstractProduct product : products) {
                    if (product.getId() > id) {
                        product.setId(product.getId() - 1);
                    }
                }
            }
        }
        return deleted;
    }

    public Collection<AbstractProduct> getAll() {
        return products;
    }
}
