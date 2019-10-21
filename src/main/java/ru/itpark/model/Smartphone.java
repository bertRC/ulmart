package ru.itpark.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Smartphone extends AbstractProduct {
    private String color;
    private double diagonal;
    private int memoryInGB;

    public Smartphone(String name, int price, int rating, String color, double diagonal, int memoryInGB) {
        super(0, name, price, rating);
        this.color = color;
        this.diagonal = diagonal;
        this.memoryInGB = memoryInGB;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", rating=" + super.getRating() +
                ", color='" + color + '\'' +
                ", diagonal=" + diagonal +
                ", memoryInGB=" + memoryInGB +
                '}';
    }

    @Override
    public boolean match(String productType) {
        return productType.toLowerCase().equals("smartphone");
    }
}
