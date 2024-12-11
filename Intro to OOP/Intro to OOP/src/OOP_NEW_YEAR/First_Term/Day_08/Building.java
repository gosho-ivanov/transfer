package OOP_NEW_YEAR.First_Term.Day_08;

import java.util.Scanner;

public class Building {
    private static Scanner scanner = new Scanner(System.in);

    private int height;
    private double area;
    private String address;

    public Building(int height, double area, String address) {
        this.height = height;
        this.area = area;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public static Building addBuilding(){
        System.out.print("Enter the height of the building(it should be an integer): ");
        int height = scanner.nextInt();
        System.out.print("Enter the area that the building occupies(floating point number): ");
        double area = scanner.nextDouble();
        System.out.print("Enter the address of the building: ");
        String address = scanner.nextLine();

        return new Building(height, area, address);
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", height=" + height +
                ", area=" + area +
                '}';
    }
}
