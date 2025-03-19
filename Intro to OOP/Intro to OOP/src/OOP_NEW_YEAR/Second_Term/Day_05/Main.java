package OOP_NEW_YEAR.Second_Term.Day_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventLog eventLog = new EventLog();
        int commandInput;
        System.out.println("Hello to the Event Log program!\n" +
                           "Here are the different commands you can perform on the event log:\n" +
                           "1. Add an event.\n" +
                           "2. Edit an event in the existing log.\n" +
                           "3. Remove an event from the log.\n" +
                           "4. Print all of the events at once.\n" +
                           "5. Exit.");
        System.out.print("What would you like to do: ");
        commandInput = scanner.nextInt();
        try {
            while (true) {
                if (commandInput < 1 || commandInput > 5) {
                    throw new CommandInputException();
                }
                if (commandInput == 1) {
                    System.out.print("Enter the event you would like to register to the event log: ");
                    String event = scanner.nextLine();
                    eventLog.addEvent(event);
                } else if (commandInput == 2) {
                    System.out.print("Enter the index you would like to modify: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter the edited event you would like to register to the event log: ");
                    String event = scanner.nextLine();
                    eventLog.editEvent(index, event);
                } else if (commandInput == 3) {
                    System.out.print("Enter the index you would like to modify: ");
                    int index = scanner.nextInt();
                    eventLog.removeEvent(index);
                } else if (commandInput == 4) eventLog.print();
                else {
                    System.out.println("Bye bye!");
                    break;
                }
            }
        } catch (CommandInputException | IndexException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The program finished with exit code 1.");
            scanner.close();
        }
    }
}
