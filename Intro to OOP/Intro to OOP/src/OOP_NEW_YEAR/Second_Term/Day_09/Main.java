package OOP_NEW_YEAR.Second_Term.Day_09;

import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            while (true) {
                Buyable[] array = new Buyable[10];
                int curr_index = 0;
                System.out.println("Options:\n" +
                        "1. Enter the information for a new product.\n" +
                        "2. Search for a product by name.\n" +
                        "3. Exit.");
                System.out.print("Enter your choice: ");
                int input = s.nextInt();
                if (input < 1 || input > 3){
                    throw new InvalidNumberException("The input must be a number between 1 and 3.");
                } else if (input == 1) {
                    createBuyableAndAddToArray(array, curr_index);
                } else if (input == 2){
                    searchBuyablesByName(array);
                } else {
                    System.out.println("Bye bye");
                    break;
                }
            }
        } catch (InvalidNumberException e){
            System.err.println(e.getMessage());
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
    }

    public static void createBuyableAndAddToArray(Buyable[] array, int current_index) throws InvalidNumberException{
        System.out.println("Would you like to create an object of class:\n" +
                "1. Product.\n" +
                "2. BetterProduct.\n");
        System.out.print("Your choice: ");
        int choice = s.nextInt();

        System.out.print("Enter the id of the product: ");
        int id = s.nextInt();
        System.out.print("Enter the name of the product: ");
        String name = s.next();
        System.out.print("Enter the quantity of the product: ");
        int quantity = s.nextInt();
        if (choice == 1) array[current_index] = new Product(id, name, quantity);
        else if (choice == 2) array[current_index] = new BetterProduct(id, name, quantity);
        else {
            throw new InvalidNumberException("The input must be a number between 1 and 2.");
        }
    }

    public static void searchBuyablesByName(Buyable[] array){
        System.out.print("Enter the name of the buyable you want search for: ");
        String name = s.next();

        for (Buyable pr: array){
            if (pr.getName().equals(name)){
                System.out.println(pr.toString());
            }
        }
    }
}