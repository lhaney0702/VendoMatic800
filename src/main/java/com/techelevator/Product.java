package com.techelevator;

import java.math.BigDecimal;

public class Product
{
    String name;
    String sound;
    String slotIdentifier;
    BigDecimal price;
    String productType;
    int stock;

    public Product(String slotIdentifier, String name, BigDecimal price, String productType, int stock)
    {
        this.slotIdentifier = slotIdentifier;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.stock = stock;
    }

    public String getSlotIdentifier()
    {
        return slotIdentifier;
    }

    public String getName()
    {
        return name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public String getProductType()
    {
        return productType;
    }

    public int getStock()
    {
        return stock;
    }

    public String getSound()
    {
        return sound;
    }






}
