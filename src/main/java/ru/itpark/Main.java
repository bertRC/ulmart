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
        collection.add(new Computer("Нереальный компьютер", 200_000, 0, "Эльбрус-4С", 24, "1 ТБ"));
        collection.add(new Smartphone("Смартфон Redmi Note 7", 13_990, 4, "blue", 6.3, 32));
        collection.add(new Computer("аОфисный компьютер MXP", 29_990, 0, "Intel Core i3", 8, "1 ТБ"));
        service.add(collection);

//        System.out.println(service.getRepository().getAll());
//        System.out.println(service.remove(2));
//        System.out.println(service.getRepository().getAll());

//        System.out.println(service.searchByName("КОМП"));
//        System.out.println(service.searchByType("Computer"));
//        System.out.println(service.getSortedByPriceDesc());
        System.out.println(service.getSortedByRating());
    }
}
