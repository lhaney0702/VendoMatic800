package com.techelevator;

import java.math.BigDecimal;

public class Product
{
    String name;
    String sound;
    String slotIdentifier;
    BigDecimal price;
    int stock;
    public Product(String slotIdentifier, String name, BigDecimal price, int stock)
    {
        this.slotIdentifier = slotIdentifier;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public BigDecimal getPrice() {
        return price;
    }


}
