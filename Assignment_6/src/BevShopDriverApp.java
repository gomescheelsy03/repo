/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: The 'BevShopDriverApp' class is a console application for managing beverage orders, including creating orders, adding beverages, and displaying order summaries.
 * Due: 12/04/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Chelsy Gomes________
*/

import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        while (true) {
            System.out.println("Start please a new order:");
            System.out.println("Would you like to start a new order? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();

            if (!"yes".equals(response)) {
                break;
            }

            System.out.println("Please enter the order time (hour in 24-hour format):");
            int time = scanner.nextInt();
            System.out.println("Please enter the day of the week (1 for Monday, 2 for Tuesday, etc.):");
            int dayOfWeek = scanner.nextInt();
            Day day = Day.values()[dayOfWeek - 1];
            scanner.nextLine(); // Consume the newline

            System.out.println("Would you please enter your name:");
            String customerName = scanner.nextLine().trim();
            System.out.println("Would you please enter your age:");
            int customerAge = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            bevShop.startNewOrder(time, day, customerName, customerAge);
            System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

            while (true) {
                System.out.println("Would you please add a beverage to your order? (Coffee/Alcohol/Smoothie/No)");
                String bevType = scanner.nextLine().trim().toLowerCase();

                if ("no".equals(bevType)) {
                    break;
                }

                if (bevType.equals("alcohol") && customerAge < BevShopInterface.MIN_AGE_FOR_ALCOHOL) {
                    System.out.println("Your Age is not appropriate for alcohol drink!!");
                    continue; // Skip the rest of the loop and ask again
                }

                System.out.println("Please enter the beverage name:");
                String bevName = scanner.nextLine().trim();
                System.out.println("Please enter the beverage size (Small/Medium/Large):");
                Size size = Size.valueOf(scanner.nextLine().trim().toUpperCase());

                switch (bevType) {
                    case "coffee":
                        System.out.println("Would you like an extra shot? (yes/no)");
                        boolean extraShot = "yes".equals(scanner.nextLine().trim().toLowerCase());
                        System.out.println("Would you like extra syrup? (yes/no)");
                        boolean extraSyrup = "yes".equals(scanner.nextLine().trim().toLowerCase());
                        bevShop.processCoffeeOrder(bevName, size, extraShot, extraSyrup);
                        break;
                    case "alcohol":
                        bevShop.processAlcoholOrder(bevName, size);
                        break;
                    case "smoothie":
                        System.out.println("How many fruits would you like to add? (Maximum " + bevShop.getMaxNumOfFruits() + ")");
                        int numOfFruits = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        if (numOfFruits > bevShop.getMaxNumOfFruits()) {
                            System.out.println("You reached a Maximum number of fruits.");
                            continue;
                        }
                        System.out.println("Would you like to add protein? (yes/no)");
                        boolean addProtein = "yes".equals(scanner.nextLine().trim().toLowerCase());
                        bevShop.processSmoothieOrder(bevName, size, numOfFruits, addProtein);
                        break;
                    default:
                        System.out.println("Invalid beverage type.");
                        continue;
                }

                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

                if (bevType.equals("alcohol") && bevShop.getNumOfAlcoholDrink() >= BevShopInterface.MAX_ORDER_FOR_ALCOHOL) {
                    System.out.println("You have reached the maximum alcohol drinks for this order.");
                    break;
                }
            }

            System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
            System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
            System.out.println("#------------------------------------#");
        }

        System.out.println("Finalizing orders...");
        bevShop.sortOrders();

        System.out.println("\nAll Orders:");
        for (Order order : bevShop.getOrders()) {
            System.out.println(order);
            System.out.println("Total Price: " + order.calcOrderTotal() + "\n");
        }

        System.out.println("Total Monthly Sales: " + bevShop.totalMonthlySale());
        scanner.close();
    }
}
