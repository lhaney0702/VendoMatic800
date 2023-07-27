package com.techelevator;

import java.math.BigDecimal;

public class PurchaseMenu extends MainMenu
{
    public PurchaseMenu()
    {
        System.out.println("placeholder for running balance");
        System.out.println();
        System.out.println("(1) Feed Money \n(2) Select Product \n(3) Finish Transaction ");
        String choice = userInput.nextLine();

        if (choice.equals("1"))
        {
            System.out.println("How much money would you like to add to your balance?");
            String amountToAdd = userInput.nextLine();
        }
        else if (choice.equals("2"))
        {
            // Take them to the purchase menu
        }
        else
        {
            System.out.println("Invalid input, please try again");
        }







    }




}
