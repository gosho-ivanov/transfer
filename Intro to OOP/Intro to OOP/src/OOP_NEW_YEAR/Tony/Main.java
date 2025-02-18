package OOP_NEW_YEAR.Tony;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.setIngredients();

        boolean running = true;
        while (running) {

            System.out.println("Welcome to the Coffee Machine!");
            System.out.println("1: Make Coffee");
            System.out.println("2: Check Ingredient Status and Profit");
            System.out.println("3: Refill Ingredients");
            System.out.println("4: Exit");
            System.out.print("Select an option: ");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    coffeeMachine.makeCoffee();
                    break;
                case 2:
                    coffeeMachine.get_status_of_the_Ingredients();
                    break;
                case 3:
                    coffeeMachine.setIngredients();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting... Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scan.close();
    }
}
