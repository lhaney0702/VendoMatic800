package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory
{
    Map<String, Product> products = new HashMap<>();
    private static final int STARTING_STOCK = 5;

    public Inventory()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("main.csv"));

            String currentLine;
            while ((currentLine = reader.readLine()) != null)
            {
                String[] item = currentLine.split(",");
                String slotLocation = item[0];
                String productName = item[1];
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(item[2]));
                String productType = item[3];
                Product currentProduct = new Product(slotLocation, productName, price, productType,STARTING_STOCK);
                products.put(slotLocation, currentProduct);
            }
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found.");
        }
    }


    public void displayInventory()
    {
        for (Map.Entry<String, Product> currentProduct : products.entrySet())
        {
            System.out.print("Slot: " + currentProduct.getValue().getSlotIdentifier()
                    + " Item: " + currentProduct.getValue().getName()
                    + " Price: $" + currentProduct.getValue().getPrice()
                    + " Quantity Remaining: ");

            if (currentProduct.getValue().getStock() == 0)
            {
                System.out.println("SOLD OUT");
            }
            else
            {
                System.out.println(currentProduct.getValue().getStock());
            }
        }
    }
}
