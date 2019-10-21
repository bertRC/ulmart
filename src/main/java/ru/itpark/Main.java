package ru.itpark;

import ru.itpark.model.AbstractProduct;
import ru.itpark.model.Computer;
import ru.itpark.model.Smartphone;
import ru.itpark.repository.ProductRepository;
import ru.itpark.service.ProductService;

import java.util.Collection;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        final ProductService service = new ProductService(new ProductRepository());
        Collection<AbstractProduct> collection = new LinkedList<>();
        collection.add(new Smartphone("Смартфон Redmi Note 7", 13_990, 4.0, "blue", 6.3, 32));
        collection.add(new Computer("Офисный компьютер MXP", 29_990, 0.0, "Intel Core i3", 8, "1 ТБ"));
        service.add(collection);
        service.add(new Smartphone("Xiaomi Redmi 7A", 7_990, 0.0, "black", 5.45, 32));

        System.out.println(service.getRepository().getAll());

        System.out.println(service.getRepository().delete(2));

        System.out.println(service.getRepository().getAll());
    }
}
