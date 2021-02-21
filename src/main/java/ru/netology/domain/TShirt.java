package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TShirt extends Product {
    private String producer;

    public TShirt() {
        super();
    }

    public TShirt(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }
}
