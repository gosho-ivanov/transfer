package OOP_NEW_YEAR.First_Term.Day_10;

import java.util.Scanner;

public class Device {
    private String maker;
    private String model;
    private double price;

    public Device(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    public static Device createDevice(Scanner scanner){
        System.out.println("Enter the maker of the device: ");
        String maker = scanner.next();
        System.out.println("Enter the model of the device: ");
        String model = scanner.next();
        System.out.println("Enter the price of the device: ");
        double price = scanner.nextDouble();
        return new Device(maker, model, price);
    }
}
