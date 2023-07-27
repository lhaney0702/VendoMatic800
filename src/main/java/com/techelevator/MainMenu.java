package com.techelevator;

import java.util.Scanner;

public class MainMenu
{
  Scanner userInput = new Scanner(System.in);

  public MainMenu()
  {


    System.out.println("Welcome, please select the number that corresponds with your desired action");
    System.out.println("(1) Display Vending Machine Items \n(2) Purchase \n(3) Exit");
    String choice = userInput.nextLine();

    while (!choice.equals("3"))
    {
      if (choice.equals("1"))
      {
        //Print a map of the entire inventory of items including
        // code, name, price, and how many are in stock
      }
      else if (choice.equals("2"))
      {

      }
      else
      {
        System.out.println("Invalid input, please try again");
      }


    }


  }
}