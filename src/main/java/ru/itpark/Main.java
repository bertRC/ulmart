package ru.itpark;

import ru.itpark.model.AbstractProduct;
import ru.itpark.model.Computer;

public class Main {
    public static void main(String[] args) {
        AbstractProduct product = new Computer(1, "Компьютер", 1_000, 4.9, "i3", 4, "HDD 1ТБ");
        System.out.println(product);
    }
}
