package com.techelevator;

import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI
{
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	static final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args)
	{
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run()
	{
		Inventory inventory = new Inventory();

		while (true)
		{
			String choice = getMainMenuChoice();

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS))
			{

				for (Product currentProduct : inventory.products)
				{
					System.out.print("Slot: " + currentProduct.getSlotIdentifier()
							+ "Item: " + currentProduct.getName()
							+ "Price: $" + currentProduct.getPrice()
							+ "Quantity Remaining: ");

					if (currentProduct.getStock() == 0)
					{
						System.out.println("SOLD OUT");
					}
					else
					{
						System.out.println(currentProduct.getStock());
					}
				}

			}
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE))
			{

				// do purchase

			}
			else if (choice.equals(MAIN_MENU_OPTION_EXIT))
			{
				System.exit(1);
			}
			else
			{
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private String getMainMenuChoice()
	{
		System.out.println("Welcome, please select the number that corresponds with your desired action: ");

		for (int i = 0; i < MAIN_MENU_OPTIONS.length; i++)
		{
			System.out.println("(" + (i + 1) + ") " + MAIN_MENU_OPTIONS[i]);
		}

		String choice = userInput.nextLine();
		int choiceNumber = Integer.parseInt(choice);

		if (choiceNumber < MAIN_MENU_OPTIONS.length)
		{
			return "";
		}

		return MAIN_MENU_OPTIONS[choiceNumber - 1];
	}
}
