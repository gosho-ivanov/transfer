package OOP_NEW_YEAR.Day_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What figure do you want to make: ");
        String figure = s.nextLine().toLowerCase();
        switch (figure) {
            case "triangle" -> {
                System.out.println("Values for the 3 sides(a, b, c) and the height(h) of the triangle:");
                double a = s.nextDouble();
                double b = s.nextDouble();
                double c = s.nextDouble();
                double h = s.nextDouble();
                Triangle tri = new Triangle(a, b, c, h);
                System.out.println("What operation do you want?\n" +
                        "1. Get Are of triangle;\n" +
                        "2. Get Perimeter of triangle.");
                int option = s.nextInt();
                if (option == 1) System.out.println("The are of the triangle is: " + tri.getArea());
                else System.out.println("The perimeter of the triangle is: " + tri.getPerimeter());
            }
            case "rectangle" -> {
                System.out.println("Values for the 2 sides(a, b) of the rectangle:");
                double a = s.nextDouble();
                double b = s.nextDouble();
                Rectangle rec = new Rectangle(a, b);
                System.out.println("What operation do you want?\n" +
                        "1. Get Are of rectangle;\n" +
                        "2. Get Perimeter of rectangle.");
                int option = s.nextInt();
                if (option == 1) System.out.println("The are of the rectangle is: " + rec.getArea());
                else System.out.println("The perimeter of the rectangle is: " + rec.getPerimeter());
            }
            case "square" -> {
                System.out.println("Values for the side(a) of the square:");
                double a = s.nextDouble();
                Square sq = new Square(a);
                System.out.println("What operation do you want?\n" +
                        "1. Get Are of square;\n" +
                        "2. Get Perimeter of square.");
                int option = s.nextInt();
                if (option == 1) System.out.println("The are of the square is: " + sq.getArea());
                else System.out.println("The perimeter of the square is: " + sq.getPerimeter());
            }
            case "trapezoid" -> {
                System.out.println("values for the 4 sides(a, b, c -> 2 times) and the height(h) of the trapezoid:");
                double a = s.nextDouble();
                double b = s.nextDouble();
                double c = s.nextDouble();
                double h = s.nextDouble();
                Trapezoid tri = new Trapezoid(a, b, c, h);
                System.out.println("What operation do you want?\n" +
                        "1. Get Are of trapezoid;\n" +
                        "2. Get Perimeter of trapezoid.");
                int option = s.nextInt();
                if (option == 1) System.out.println("The are of the trapezoid is: " + tri.getArea());
                else System.out.println("The perimeter of the trapezoid is: " + tri.getPerimeter());
            }
            case "parallelogram" -> {
                System.out.println("values for the 2 sides(a, b) and the height(h) of the parallelogram:");
                double a = s.nextDouble();
                double b = s.nextDouble();
                double h = s.nextDouble();
                Parallelogram tri = new Parallelogram(a, b, h);
                System.out.println("What operation do you want?\n" +
                        "1. Get Are of parallelogram;\n" +
                        "2. Get Perimeter of parallelogram.");
                int option = s.nextInt();
                if (option == 1) System.out.println("The are of the parallelogram is: " + tri.getArea());
                else System.out.println("The perimeter of the parallelogram is: " + tri.getPerimeter());
            }
            default ->
                    System.out.println("The figure you selected either doesn't exist or it isn't defined within the program. :)");
        }
    }
}
