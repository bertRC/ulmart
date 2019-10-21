package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractProduct {
    private long id;
    private String name;
    private int price;
    private double rating;
}
