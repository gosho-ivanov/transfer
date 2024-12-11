package OOP_NEW_YEAR.Day_03;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        printIntroduction();

        Scanner s = new Scanner(System.in);
        float BMI = getBMI(s);
        String status = getStatus(BMI);
        ReportResults(1, BMI, status);
    }

    public static void printIntroduction(){
        System.out.println("This program is used for calculating a person's body mass index(BMI).");
    }

    public static float getBMI(Scanner s){
        System.out.print("Please enter your height in inches: ");
        float height = s.nextFloat();
        System.out.print("PLease enter your weight in pounds: ");
        float weight = s.nextFloat();
        System.out.println();

        return bmiFor(height, weight);
    }

    public static float bmiFor(float height, float weight){
        float bmi = weight*703/ (height*height);
        return bmi;
    }

    public static String getStatus(float bmi){
        if (bmi <= 18.5){
            return "underweight";
        } else if (bmi <= 25) {
            return "normal";
        } else if (bmi <= 30){
            return "overweight";
        } else {
            return "obese";
        }
    }

    public static void ReportResults(int index, float bmi, String status){
        System.out.printf("Person No. %d has s Body Mass Index of %f, therefore he is %s", index, Math.round(bmi*100)/100 %.2f, status);
    }
}
