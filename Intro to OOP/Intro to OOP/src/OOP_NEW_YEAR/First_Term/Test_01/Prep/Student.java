package OOP_NEW_YEAR.Test_01.Prep;

import java.util.Scanner;

public class Student {
    private String name;
    private String facNum;
    private int yearOfBirth;
    private double gpa;

    public Student(int yearOfBirth, String facNum, double gpa, String name) {
        this.yearOfBirth = yearOfBirth;
        this.facNum = facNum;
        this.gpa = gpa;
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getFacNum() {
        return facNum;
    }

    public void setFacNum(String facNum) {
        this.facNum = facNum;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dateOfBirth='" + yearOfBirth + '\'' +
                ", name='" + name + '\'' +
                ", facNum='" + facNum + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public static Student addStudent(Scanner scanner){
        System.out.print("Enter the name of the student: ");
        String name = scanner.nextLine();
        System.out.print("\nEnter the faculty number of the student: ");
        String facNum = scanner.nextLine();
        System.out.print("\nEnter the year of birth of the student: ");
        int year = scanner.nextInt();
        System.out.println("\nEnter the gpa of the student: ");
        double gpa = scanner.nextDouble();
        System.out.println();
        return new Student(year, facNum, gpa, name);
    }

    public int yearOldInYear(int year){
        return year - this.yearOfBirth;
    }



}
