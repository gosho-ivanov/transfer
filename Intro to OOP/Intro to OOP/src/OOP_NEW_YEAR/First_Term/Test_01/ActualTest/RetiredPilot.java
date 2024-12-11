package OOP_NEW_YEAR.First_Term.Test_01.ActualTest;

import java.util.Scanner;

public class RetiredPilot extends Pilot{
    private static Scanner s = new Scanner(System.in);
    private int yearOFRetirement;

    public RetiredPilot(double flyingHours, String id, String name, int yearOfBirth, int yearOFRetirement) {
        super(flyingHours, id, name, yearOfBirth);
        this.yearOFRetirement = yearOFRetirement;
    }

    public int getYearOFRetirement() {
        return yearOFRetirement;
    }

    public void setYearOFRetirement(int yearOFRetirement) {
        this.yearOFRetirement = yearOFRetirement;
    }

    @Override
    public String toString() {
        return "RetiredPilot{" +
                "flyingHours=" + this.getFlyingHours() +
                ", name='" + this.getName() + '\'' +
                ", id='" + this.getId() + '\'' +
                ", yearOfBirth=" + this.getYearOfBirth() +
                ", yearOFRetirement=" + this.getYearOFRetirement() +
                '}';
    }

    public static RetiredPilot retireAPilot(Pilot pilot){
        System.out.print("Enter the year of retirement of the pilot: ");
        int yearOfRetirement = s.nextInt();
        return new RetiredPilot(pilot.getFlyingHours(), pilot.getId(), pilot.getName(), pilot.getYearOfBirth(), yearOfRetirement);
    }
}
