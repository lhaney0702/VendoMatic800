package com.techelevator;

import java.math.BigDecimal;

public class PurchaseMenu extends VendingMachineCLI
{
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
    private BigDecimal currentMoney = BigDecimal.valueOf(0.00);

    public PurchaseMenu()
    {

    }

    public void runPurchaseMenu(Inventory inventory)
    {
        while (true)
        {
            System.out.println("Current Money Provided: $" + currentMoney);
            System.out.println();
            String choice = getPurchaseMenuChoice();

            if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY))
            {
                handleFeedMoney();
            }
            else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT))
            {
                //Display available items
                inventory.displayInventory();
                System.out.println("Enter product code to select item: ");
                String itemCodeInput = userInput.nextLine();

                dispensingAnItem(itemCodeInput, inventory);
            }
            else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION))
            {
                finishingTransaction();

                //Returns to main menu
                break;
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleFeedMoney()
    {
        System.out.println("How much money would you like to add to your balance?");
        String amountToAddInput = userInput.nextLine();
        double moneyAdded = Double.parseDouble(amountToAddInput); //Convert input String to double
        BigDecimal amountToAdd = BigDecimal.valueOf(moneyAdded);  //Convert double to BigDecimal

        //Adds given money to current amount
        currentMoney = currentMoney.add(amountToAdd);
    }

    private String getPurchaseMenuChoice()
    {
        //Prints out options in purchase array
        for (int i = 0; i < PURCHASE_MENU_OPTIONS.length; i++)
        {
            System.out.println("(" + (i + 1) + ") " + PURCHASE_MENU_OPTIONS[i]);
        }

        //What user puts in converted to int
        String choice = userInput.nextLine();
        int choiceNumber = Integer.parseInt(choice);

        //Verify choice number is within array bounds
        if (choiceNumber > PURCHASE_MENU_OPTIONS.length)
        {
            return "";
        }

        return PURCHASE_MENU_OPTIONS[choiceNumber - 1];
    }

    private void dispensingAnItem(String itemCodeInput, Inventory inventory)
    {
        if (inventory.products.containsKey(itemCodeInput))
        {
            Product currentProduct = inventory.products.get(itemCodeInput);
            if (currentProduct.getStock() > 0)
            {
                currentMoney = currentMoney.subtract(currentProduct.getPrice());
                System.out.println("Item: " + currentProduct.getName()
                        + "Price: $" + currentProduct.getPrice()
                        + "Money Remaining: $" + currentMoney);

                System.out.println(currentProduct.dispensingMessage());

                //Update stock
                currentProduct.setStock(currentProduct.getStock() - 1);
            }
            else
            {
                System.out.println("SOLD OUT. Please select different option.");
            }
        }
        else
        {
            System.out.println("Invalid product code. Please try again.");
        }

        //TODO: Add August discount
    }

    private void finishingTransaction()
    {
        //Return change

        
        //Update current balance to 0

    }
}
