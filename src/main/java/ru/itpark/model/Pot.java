package ru.itpark.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pot extends AbstractProduct {
    private String color;
    private String dimensions;
    private int volume;

    public Pot(String name, int price, int rating, String color, String dimensions, int volume) {
        super(0, name, price, rating);
        this.color = color;
        this.dimensions = dimensions;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Pot{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", rating=" + super.getRating() +
                ", color='" + color + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", volume=" + volume +
                '}';
    }

    @Override
    public boolean match(String productType) {
        return productType.toLowerCase().equals("pot");
    }
}
