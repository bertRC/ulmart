package ru.itpark.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TV extends AbstractProduct {
    private int diagonal;
    private String color;
    private String hdFormat;

    public TV(String name, int price, int rating, int diagonal, String color, String hdFormat) {
        super(0, name, price, rating);
        this.diagonal = diagonal;
        this.color = color;
        this.hdFormat = hdFormat;
    }

    @Override
    public String toString() {
        return "TV{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", rating=" + super.getRating() +
                ", diagonal=" + diagonal +
                ", color='" + color + '\'' +
                ", hdFormat='" + hdFormat + '\'' +
                '}';
    }

    @Override
    public boolean match(String productType) {
        return productType.toLowerCase().equals("tv");
    }
}
