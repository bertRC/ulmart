package ru.itpark.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TShirt extends AbstractProduct{
    private String color;
    private int size;

    public TShirt(String name, int price, int rating, String color, int size) {
        super(0, name, price, rating);
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", rating=" + super.getRating() +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean match(String productType) {
        return productType.toLowerCase().equals("tshirt");
    }
}
