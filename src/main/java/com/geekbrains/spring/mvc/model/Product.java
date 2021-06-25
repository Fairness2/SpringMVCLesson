package com.geekbrains.spring.mvc.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Product {
    private UUID uuid;
    private String title;
    private int cost;


    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Product) {
            return this.uuid.equals(((Product) anObject).uuid);
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Product: {%nUUID: %s%nTitle: %s%nCost: %s%n}%n", uuid, title, cost);
    }

}
