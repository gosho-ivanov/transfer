package dimitrov.interactiveProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Robot> robots = new ArrayList<>();
        while (true) {
            System.out.println("Here are the commands which can be utilised:");
            System.out.println("1. Create a new robot.\n2. Show all created robots.\n3. Search for a robot by it's name/maker.\n4. Stop the program.");
            System.out.print("Enter a number of a command: ");
            int input = s.nextInt();
            System.out.println();
            if (input == 1) {
                Robot myRobot = new Robot();
                System.out.println("Enter the name of the robot: ");
                myRobot.Name = s.next();

                System.out.println("Enter the code of the robot: ");
                myRobot.Code = s.nextInt();

                System.out.println("Enter the maker of the robot: ");
                myRobot.Maker = s.next();

                System.out.println("Enter the type of the robot (e.g., humanoid, industrial, etc.): ");
                myRobot.Type = s.next();
                robots.add(myRobot);
                System.out.println();
            } else if (input == 2) {
                for (Robot robot: robots){
                    System.out.println(robot.toString());

                }
                System.out.println();
            } else if (input == 3) {
                boolean isFound = false;
                System.out.println("Enter the name of the robot you are searching for: ");
                String command = s.next();
                for (Robot robot: robots){
                    if (Objects.equals(robot.Name, command)) {
                        System.out.print("Here is a robot with the same name: ");
                        System.out.println(robot);
                        isFound = true;
                    }
                }
                if (!isFound) {
                    System.out.println("There are no robots that meet your criteria.");
                }
                System.out.println();
            } else if (input == 4) {
                break;
            } else {
                System.out.println("Invalid command.");
                System.out.println();
            }

        }
    }
}
