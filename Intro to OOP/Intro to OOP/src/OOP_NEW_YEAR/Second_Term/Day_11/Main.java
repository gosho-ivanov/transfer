package OOP_NEW_YEAR.Second_Term.Day_11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean loggedIn = false;

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("Choose an option:\n" +
                        "1. Registration\n" +
                        "2. Login");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                if (choice < 1 || choice > 2) {
                    throw new RuntimeException("Your choice is invalid.");
                } else if (choice == 1) {
                    users.add(createUser());
                } else {
                    loggedIn = logIn();
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Bye bye.");
        }
    }

    public static User createUser() throws WrongUserException, WrongPhoneNumberException{
        System.out.print("Enter the username you would like to use(0nly small letters, numbers, '-' & '_' are allowed): ");
        String username = scanner.next();
        System.out.print("Enter your password(Only letters; minimum 11 chars long): ");
        String password = scanner.next();
        System.out.print("Enter your password again: ");
        String password2 = scanner.next();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.next();
        System.out.println("\n");

        for (User user: users){
            if (user.getUsername().equals(username)){
                throw new WrongUserException("There is already a user with the same username.");
            }
        }

        if (UsernameValidation.validateUsername(username) && PasswordValidation.validatePassword(password)
                && ValidatePhone.validatePhoneNumber(phoneNumber) && password2.equals(password)){
            return new User(password, phoneNumber, username);
        } else if (!UsernameValidation.validateUsername(username)){
            throw new WrongUserException("The username you have entered is invalid.");
        } else if (!PasswordValidation.validatePassword(password)){
            throw new WrongUserException("You password is invalid.");
        } else {
            throw new WrongUserException("Your password doesn't match.");
        }
    }

    public static boolean logIn(){
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        boolean loggedIn = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Welcome back, " + user.getUsername());
                    loggedIn = true;
                }
            }
        }
        return loggedIn;
    }
}
