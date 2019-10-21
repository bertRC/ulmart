package ru.itpark.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Computer extends AbstractProduct{
    private String cpu;
    private int ram;
    private String hdd;

    public Computer(long id, String name, int price, double rating, String cpu, int ram, String hdd) {
        super(id, name, price, rating);
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", rating=" + super.getRating() +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", hdd='" + hdd + '\'' +
                '}';
    }
}
