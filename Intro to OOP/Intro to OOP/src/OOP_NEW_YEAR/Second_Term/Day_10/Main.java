package OOP_NEW_YEAR.Second_Term.Day_10;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static Worker[] workers = new Worker[10];

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 2; i++) {
                workers[i] = createWorker();
            }

            System.out.println(getTotalHours());
            System.out.println(getAvgHours());
            System.out.println(getTotalSalaries());
            System.out.println(getAvgSalaries());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }



    public static Worker createWorker(){
        System.out.print("Enter the name of the worker: ");
        String name = s.next();
        System.out.print("Enter the hourly wage of the worker: ");
        float hourlyWage = s.nextFloat();
        System.out.print("Enter the hours the worker has worked this week: ");
        float hours  = s.nextFloat();
        System.out.print("Enter the work the worker did this week: ");
        String work = s.next();

        System.out.print("\nIs the worker a salaried worker (true or false): ");
        boolean flag = s.nextBoolean();
        System.out.println();
        if (flag) return new SalariedWorker(hourlyWage, name, hours, work);
        else return new HourlyWorker(hourlyWage, name, hours, work);
    }

    public static float getTotalHours(){
        float totalHours = 0;
        for (Worker w: workers) {
            if (w != null) {
                totalHours += w.getHours();
            }
        }

        return totalHours;
    }

    public static float getAvgHours(){
        float totalHours = getTotalHours();
        int amountOfWorkers = 0;
        for (Worker w: workers){
            if (w != null){
                amountOfWorkers += 1;
            }
        }

        return totalHours/amountOfWorkers;
    }

    public static float getTotalSalaries(){
        float totalSalaries = 0;

        for (Worker w: workers){
            if (w != null){
                totalSalaries += w.getWeeklySalary();
            }
        }

        return totalSalaries;
    }

    public static float getAvgSalaries(){
        float totalSalaries = getTotalSalaries();
        int amountOfWorkers = 0;
        for (Worker w: workers){
            if (w != null){
                amountOfWorkers += 1;
            }
        }

        return totalSalaries / amountOfWorkers;
    }
}
