package OOP_NEW_YEAR.First_Term.Day_09;

import java.util.Scanner;

public class BlackFriday {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Electronics[] electronicsArr = makeArrOfElectronic(5, s);
        Book[] booksArr = makeArrOfBooks(5, s);

        System.out.println("The promotional price of the electronic" + electronicsArr[3].getModel() + "is: " + electronicsArr[3].getPromotionalPrice());
        System.out.println("Could we sell to you the book" + booksArr[4].getTitle() + ": " + booksArr[4].sellProduct(6));
    }

    public static Electronics[] makeArrOfElectronic(int n, Scanner scanner){
        Electronics[] electronicsArr = new Electronics[n];
        String inventoryNumber;
        double price;
        int quantity;
        String name;
        String phoneNumber;
        Provider provider;
        String manufacturer;
        String model;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the inventory number: ");
            inventoryNumber = scanner.next();
            System.out.println("Enter the price of the electronic device: ");
            price = scanner.nextDouble();
            System.out.println("Enter the quantity of the electronic device: ");
            quantity = scanner.nextInt();
            System.out.println("Enter the name of the provider: ");
            name = scanner.next();
            System.out.println("Enter the phone number of the provider: ");
            phoneNumber = scanner.next();
            provider = new Provider(name , phoneNumber);
            System.out.println("Enter the manufacturer of the electronic device: ");
            manufacturer = scanner.next();
            System.out.println("Enter the model of the electronic device: ");
            model = scanner.next();
            electronicsArr[i] = new Electronics(inventoryNumber, price, provider, quantity, manufacturer, model);
        }
        return electronicsArr;
    }

    public static Book[] makeArrOfBooks(int n, Scanner scanner){
        Book[] booksArr = new Book[n];
        String inventoryNumber;
        double price;
        int quantity;
        String name;
        String phoneNumber;
        Provider provider;
        String author;
        String title;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the inventory number: ");
            inventoryNumber = scanner.next();
            System.out.println("Enter the price of the book: ");
            price = scanner.nextDouble();
            System.out.println("Enter the quantity of the book: ");
            quantity = scanner.nextInt();
            System.out.println("Enter the name of the provider: ");
            name = scanner.next();
            System.out.println("Enter the phone number of the provider: ");
            phoneNumber = scanner.next();
            provider = new Provider(name , phoneNumber);
            System.out.println("Enter the author of the book: ");
            author = scanner.next();
            System.out.println("Enter the title of the book: ");
            title = scanner.next();
            booksArr[i] = new Book(inventoryNumber, price, provider, quantity, author, title);
        }
        return booksArr;
    }
}
