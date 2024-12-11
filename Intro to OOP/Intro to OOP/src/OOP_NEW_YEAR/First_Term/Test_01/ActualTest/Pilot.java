package OOP_NEW_YEAR.First_Term.Test_01.ActualTest;

import java.util.Scanner;

public class Pilot {
    private static Scanner s = new Scanner(System.in);
    private String name;
    private String id;
    private int yearOfBirth;
    private double flyingHours;

    public Pilot(double flyingHours, String id, String name, int yearOfBirth) {
        this.flyingHours = flyingHours;
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public double getFlyingHours() {
        return flyingHours;
    }

    public void setFlyingHours(double flyingHours) {
        this.flyingHours = flyingHours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "flyingHours=" + flyingHours +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public static Pilot createPilot(){
        System.out.print("Enter the name of the pilot: ");
        String name = s.next();
        System.out.print("Enter the year of birth of the pilot: ");
        int yearOfBirth = s.nextInt();
        System.out.print("Enter the id of the pilot: ");
        String id = s.next();
        System.out.print("Enter the amount of hours the pilot has flown(can be both an integer and a floating point number): ");
        double flyingHours = s.nextDouble();
        return new Pilot(flyingHours, id, name, yearOfBirth);
    }

    public int returnAgeOfPilot(int currentYear){
        return currentYear - this.yearOfBirth;
    }
}
