package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Inventory
{
    Product productValues = new Product("", "", BigDecimal.valueOf(0.0), 0);
    Map<String, Product> productInfo = new HashMap<>();
    public Inventory()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("main.csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null)
            {
                String[] item = currentLine.split(",");


            }

        } catch (Exception e)
        {
        System.out.println("File not found");
        }











    }








}
