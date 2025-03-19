package OOP_NEW_YEAR.Tomov_Lectures.Triangle_exceptions;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the values for the 3 sides of the triangle:");
            System.out.print("a: ");
            float a = scanner.nextFloat();
            System.out.print("b: ");
            float b = scanner.nextFloat();
            System.out.print("c: ");
            float c = scanner.nextFloat();
            isRightTriangle(a, b, c);
        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void isRightTriangle(float a, float b, float c) throws TriangleException {
        if (c > a && c > b) {
            if (c * c != a * a + b * b) throw new TriangleException("The triangle does not have a 90 degree angle.");
            else {
                System.out.println("The triangle has a right angle.");
            }
        } else if (b > a && b > c) {
            if (b * b != c * c + a * a) throw new TriangleException("The triangle does not have a 90 degree angle.");
            else {
                System.out.println("The triangle has a right angle.");
            }
        } else if (a > c && a > b) {
            if (a * a != c * c + b * b) throw new TriangleException("The triangle does not have a 90 degree angle.");
            else {
                System.out.println("The triangle has a right angle.");
            }
        }
    }
}

