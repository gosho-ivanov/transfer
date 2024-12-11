package OOP_NEW_YEAR.First_Term.Day_08;

import java.util.Scanner;

public class House extends Building{
    private static Scanner scanner = new Scanner(System.in);

    private int floors;
    private String homeOwner;
    private String phoneNumber;

    public House(int height, double area, String address, int floors, String homeOwner, String phoneNumber) {
        super(height, area, address);
        this.floors = floors;
        this.homeOwner = homeOwner;
        this.phoneNumber = phoneNumber;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getHomeOwner() {
        return homeOwner;
    }

    public void setHomeOwner(String homeOwner) {
        this.homeOwner = homeOwner;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", homeOwner='" + homeOwner + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static House addHouse(){
        System.out.print("Enter the height of the house(it should be an integer): ");
        int height = scanner.nextInt();
        System.out.print("Enter the area that the house occupies(floating point number): ");
        double area = scanner.nextDouble();
        System.out.print("Enter the address of the house: ");
        String address = scanner.next();
        System.out.print("Enter the floors that the house has: ");
        int floors = scanner.nextInt();
        System.out.print("Enter the name of the owner of the house: ");
        String name = scanner.next();
        System.out.print("Enter his phone number: ");
        String phone = scanner.next();

        return new House(height, area, address, floors, name, phone);
    }

    public static House findBiggestHouse(House[] houses){
        double biggestHeightPerFloor = 0;
        House biggestHouse = null;
        double heightPerFloor;

        for (House h : houses){
            heightPerFloor = (double) h.getHeight() / h.getFloors();
            if (heightPerFloor > biggestHeightPerFloor){
                biggestHouse = h;
                biggestHeightPerFloor = heightPerFloor;
            }
        }

        return biggestHouse;
    }
}
