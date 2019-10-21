package ru.itpark;

import ru.itpark.model.*;
import ru.itpark.repository.ProductRepository;
import ru.itpark.service.ProductService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final ProductService service = new ProductService(new ProductRepository());
        Collection<AbstractProduct> collection = new LinkedList<>();
        collection.add(new Smartphone("Смартфон Redmi Note 7", 13_990, 4, "blue", 6.3, 32));
        collection.add(new Computer("Нереальный компьютер", 200_000, 0, "Эльбрус-4С", 24, "1 ТБ"));
        collection.add(new Smartphone("Смартфон Xiaomi Redmi 7A", 7_990, 0, "black", 5.45, 32));
        collection.add(new Computer("Офисный компьютер MXP", 29_990, 0, "Intel Core i3", 8, "1 ТБ"));
        service.add(collection);

        service.add(
                new TV("Телевизор Витязь 43LF0207", 12_590, 5, 43, "black", "1080p"),
                new TV("Телевизор Prestigio Grace 1", 9_890, 5, 32, "black", "720p"),
                new TShirt("Футболка J-Design, Джокер", 640, 0, "black", 44),
                new TShirt("Футболка J-Design, белый", 430, 0, "white", 50),
                new Pot("Горшок с поддоном ГазонCity Roma", 519, 0, "green", "34.8 х 26.5 см", 15),
                new Pot("Горшок с поддоном MXP", 209, 5, "gray", "25.4 х 19.4 см", 6)
        );

        service.remove(2);

        System.out.println(service.searchByName("MXP"));
        System.out.println();

        System.out.println(service.searchByType("Computer"));
        System.out.println();

        List<AbstractProduct> result = service.getSortedByPrice();
        System.out.println(service.getSubList(1,3, result));
        System.out.println();
        System.out.println(service.getSubList(2,3, result));
    }
}
