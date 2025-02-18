package OOP_NEW_YEAR.Tony;

import java.util.Scanner;

public class CoffeeMachine {
    private int ml_of_water;
    private int grams_of_milkPowder;
    private int grams_of_coffeePowder;
    private int cupsQuantity;
    private int stirrerQuantity;
    private int sugar;
    private double money;

    public CoffeeMachine() {
        this.ml_of_water = 0;
        this.grams_of_coffeePowder = 0;
        this.cupsQuantity = 0;
        this.grams_of_milkPowder = 0;
        this.stirrerQuantity = 0;
        this.sugar = 0;
        this.money = 0;


    }

    public void setIngredients() {
        this.ml_of_water = 1000;
        this.grams_of_coffeePowder = 500;
        this.cupsQuantity = 50;
        this.grams_of_milkPowder = 500;
        this.stirrerQuantity = 60;
        this.sugar = 250;


    }

    public void get_status_of_the_Ingredients() {
        System.out.println("Current Ingredient Levels:");
        System.out.println("Water: " + ml_of_water + " ml");
        System.out.println("Coffee Powder: " + grams_of_coffeePowder + " grams");
        System.out.println("Milk Powder: " + grams_of_milkPowder + " grams");
        System.out.println("Cups: " + cupsQuantity);
        System.out.println("Stirrers: " + stirrerQuantity);
        System.out.println("Sugar: " + sugar + " grams");
        System.out.printf("Money Earned: $%.2f\n", money);
    }

    private void extraSugar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1: extra sugar - 0.20$ \n 0: To continue ");
        int sugarToAdd = scan.nextInt();
        if (sugarToAdd == 1) {
            if (sugar >= 5) {
                sugar -= 5;
                stirrerQuantity -= 1;
                money += 0.20;
                System.out.println("Extra sugar added.");

            }
            else {
                System.out.println("Not enough sugar to add extra sugar.");
            }
        } else {
            System.out.println("No extra sugar added.");
        }
    }
    private void BlackCoffee(){
        if (ml_of_water >= 200 && grams_of_coffeePowder >= 20 && cupsQuantity > 0) {
            ml_of_water -= 200;
            grams_of_coffeePowder -= 20;
            cupsQuantity -= 1;
            money += 1;
            extraSugar();
            System.out.println("Enjoy your coffee");

        } else {
            System.out.println("Not enough ingredients....");

        }

    }
    private void MilkCoffee(){
        if (ml_of_water >= 200 && grams_of_coffeePowder >= 20 && grams_of_milkPowder >= 20 && cupsQuantity > 0) {
            ml_of_water -= 200;
            grams_of_coffeePowder -= 20;
            grams_of_milkPowder -= 20;
            cupsQuantity -= 1;
            money += 1.5;
            extraSugar();
            System.out.println("Enjoy your coffee");

        } else {
            System.out.println("Not enough ingredients....");

        }

    }

    private void Cappuccino(){
        if (ml_of_water >= 200 && grams_of_coffeePowder >= 20 && grams_of_milkPowder >= 20 && sugar >= 5 && cupsQuantity > 0) {
            ml_of_water -= 200;
            grams_of_coffeePowder -= 20;
            grams_of_milkPowder -= 20;
            cupsQuantity -= 1;
            sugar -= 5;
            money += 2.0;
            extraSugar();
            System.out.println("Enjoy your coffee");

        } else {
            System.out.println("Not enough ingredients....");
        }

    }


    public void makeCoffee() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select Type: \n|1: Black Coffee - 1.00$ \n|2: Milk Coffee - 1.50$  \n|3: Cappuccino - 2.00$ \n|0: to Discard ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                BlackCoffee();
                break;
            case 2:
                MilkCoffee();
                break;

            case 3:
                Cappuccino();
                break;
            case 4:
                System.out.println("Have a nice day:");
                break;
        }
    }
}
