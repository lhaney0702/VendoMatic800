package com.techelevator;

import java.math.BigDecimal;

public class PurchaseMenu extends VendingMachineCLI
{
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

    public PurchaseMenu()
    {
        System.out.println("Current Money Provided: ");
        System.out.println();
        String choice = getPurchaseMenuChoice();

        if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY))
        {
            System.out.println("How much money would you like to add to your balance?");
            String amountToAdd = userInput.nextLine();
        }
        else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT))
        {
            // Take them to the purchase menu
        }
        else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION))
        {

        }
        else
        {
            System.out.println("Invalid choice, please try again.");
        }

    }

    private String getPurchaseMenuChoice()
    {
        for (int i = 0; i < PURCHASE_MENU_OPTIONS.length; i++)
        {
            System.out.println("(" + (i + 1) + ") " + PURCHASE_MENU_OPTIONS[i]);
        }

        String choice = userInput.nextLine();
        int choiceNumber = Integer.parseInt(choice);

        if (choiceNumber < PURCHASE_MENU_OPTIONS.length)
        {
            return "";
        }

        return PURCHASE_MENU_OPTIONS[choiceNumber - 1];
    }


}
