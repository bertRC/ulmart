package ru.itpark.repository;

import ru.itpark.model.AbstractProduct;

import java.util.Collection;
import java.util.LinkedList;

public class ProductRepository {
    private final Collection<AbstractProduct> products = new LinkedList<>();
    private long nextId = 1;
}
