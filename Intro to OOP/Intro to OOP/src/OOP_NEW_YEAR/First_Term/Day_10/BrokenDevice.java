package OOP_NEW_YEAR.First_Term.Day_10;

import java.util.Scanner;

public class BrokenDevice extends Device{
    public String problem;
    public int daysToRepare;

    public BrokenDevice(String maker, String model, double price, int daysToRepare, String problem) {
        super(maker, model, price);
        this.daysToRepare = daysToRepare;
        this.problem = problem;
    }

    public int getDaysToRepare() {
        return daysToRepare;
    }

    public void setDaysToRepare(int daysToRepare) {
        this.daysToRepare = daysToRepare;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "BrokenDevice{" +
                "maker='" + this.getMaker() + '\'' +
                ", model='" + this.getModel() + '\'' +
                ", price=" + this.getPrice() +
                ", daysToRepare=" + this.getDaysToRepare() +
                ", problem='" + this.getProblem() + '\'' +
                '}';
    }

    public static BrokenDevice createBrokenDevice(Scanner scanner){
        Device device = Device.createDevice(scanner);
        System.out.println("Enter the problem of the device: ");
        String problem = scanner.next();
        System.out.println("Enter the days needed for the repair: ");
        int days = scanner.nextInt();
        return new BrokenDevice(device.getMaker(), device.getModel(), device.getPrice(), days, problem);
    }
}
