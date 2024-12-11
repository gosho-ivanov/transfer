package OOP_NEW_YEAR.Tomov_Lectures.CoffeeMachine;

import java.util.ArrayList;

public class CoffeeMachineTest {
    public static void main(String[] args) {
        // Define coins and initial amounts
        double[] changeCoins = {1, 1, 0.5, 0.2, 0.1, 0.05};
        int[] changeCoinsAmount = {50, 50, 50, 50, 50, 50};
        int[] changeCoinsMaxAmount = {100, 100, 100, 100, 100, 100};

        // Define initial machine settings
        double coffeeAmount = 1000; // grams
        double waterAmount = 5000; // ml
        double milkAmount = 2000; // ml
        double sugarAmount = 500; // grams

        double coffeeContainerMax = 2000; // grams
        double waterTankMax = 8000; // ml
        double milkTankMax = 3000; // ml
        double sugarContainerMax = 1000; // grams

        // Create initial coffee options
        ArrayList<Coffee> coffeesAvailable = new ArrayList<>();
        coffeesAvailable.add(new Coffee(20, 10, "Espresso", 1.5, 30));
        coffeesAvailable.add(new Coffee(20, 50, "Latte", 2.5, 100));
        coffeesAvailable.add(new Coffee(20, 30, "Cappuccino", 2.0, 80));

        // Initialize the CoffeeMachine
        CoffeeMachine coffeeMachine = new CoffeeMachine(
                coffeeAmount, coffeeContainerMax, milkAmount, milkTankMax, sugarAmount, sugarContainerMax,
                waterAmount, waterTankMax, coffeesAvailable, changeCoins, changeCoinsAmount, changeCoinsMaxAmount
        );

        // Show available coffees
        System.out.println("Available Coffees:");
        for (Coffee coffee : coffeeMachine.getCoffeesAvailable()) {
            System.out.println("- " + coffee.getName() + ": $" + coffee.getPrice());
        }

        // Simulate making a coffee
        System.out.println("\nMaking a Latte...");
        double[][] change = coffeeMachine.makeCoffee(3.0, "Latte");

        System.out.println("Change returned:");
        for (int i = 0; i < change[0].length; i++) {
            if (change[1][i] > 0) {
                System.out.printf("Coin: $%.2f, Amount: %.0f%n", change[0][i], change[1][i]);
            }
        }

        // Simulate refilling the water tank
        System.out.println("\nRefilling the water tank...");
        coffeeMachine.fillWaterContainer(2000);

        // Check coin availability
        System.out.println("\nChecking coin availability...");
        coffeeMachine.checkCoinAvailability();

        // Add a new coffee type
        System.out.println("\nAdding a new coffee type...");
        coffeeMachine.addCoffeeToMachine("Mocha", 25, 40, 120, 3.0);
        System.out.println("New coffee type added: Mocha");

        // Show updated list of coffees
        System.out.println("\nUpdated Coffees:");
        for (Coffee coffee : coffeeMachine.getCoffeesAvailable()) {
            System.out.println("- " + coffee.getName() + ": $" + coffee.getPrice());
        }
    }
}
