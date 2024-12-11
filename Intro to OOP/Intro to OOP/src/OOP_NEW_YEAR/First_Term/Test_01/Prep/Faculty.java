package OOP_NEW_YEAR.First_Term.Test_01.Prep;

import java.util.Scanner;

public class Faculty extends Student{
    private int yearOfGraduation;

    public Faculty(int yearOfBirth, String facNum, double gpa, String name, int yearOfGraduation) {
        super(yearOfBirth, facNum, gpa, name);
        this.yearOfGraduation = yearOfGraduation;

    }


    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "yearOfGraduation=" + this.getYearOfGraduation() + '\'' +
                "dateOfBirth='" + this.getYearOfBirth() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", facNum='" + this.getFacNum() + '\'' +
                ", gpa=" + this.getGpa() +
                '}';
    }

    public static Faculty graduateStudent(Scanner scanner, Student student){
        System.out.print("Enter the year of graduation of the student: ");
        int year = scanner.nextInt();
        return new Faculty(student.getYearOfBirth(), student.getFacNum(), student.getGpa(), student.getName(), year);
    }
}
