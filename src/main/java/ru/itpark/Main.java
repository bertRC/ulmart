package ru.itpark;

import ru.itpark.model.AbstractProduct;
import ru.itpark.model.Smartphone;

public class Main {
    public static void main(String[] args) {
        AbstractProduct smartphone = new Smartphone(1, "Смартфон", 5_000, 5.0, "красный", 7.0, 32);
        System.out.println(smartphone);
    }
}
