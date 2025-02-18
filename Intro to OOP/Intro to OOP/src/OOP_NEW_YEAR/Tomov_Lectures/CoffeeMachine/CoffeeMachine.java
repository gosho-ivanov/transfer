package OOP_NEW_YEAR.Tomov_Lectures.CoffeeMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);


    //FIELDS START HERE
    private double CoffeeAmount;
    private double WaterAmount;
    private double MilkAmount;
    private double sugarAmount;
    private double sugarContainerMax;
    private double[] changeCoins;
    private int[] changeCoinsAmount;
    private int[] changeCoinsMaxAmount;
    private double CoffeeBeansContainerMax;
    private double WaterTankMax;
    private double MilkTankMax;
    private ArrayList<Coffee> coffeesAvailable;
    //FIELDS END HERE


    //CONSTRUCTOR, GETTERS AND SETTERS START HERE

    public CoffeeMachine(double coffeeAmount, double coffeeBeansContainerMax, double milkAmount, double milkTankMax,
                         double sugarAmount, double sugarContainerMax, double waterAmount, double waterTankMax, ArrayList<Coffee> coffeesAvailable,
                         double[] changeCoins, int[] changeCoinsAmount, int[] changeCoinsMaxAmount) {
        this.CoffeeAmount = coffeeAmount;
        this.CoffeeBeansContainerMax = coffeeBeansContainerMax;
        this.MilkAmount = milkAmount;
        this.MilkTankMax = milkTankMax;
        this.sugarAmount = sugarAmount;
        this.sugarContainerMax = sugarContainerMax;
        this.WaterAmount = waterAmount;
        this.WaterTankMax = waterTankMax;
        this.coffeesAvailable = coffeesAvailable;
        this.changeCoinsAmount = changeCoinsAmount;
        this.changeCoinsMaxAmount = changeCoinsMaxAmount;
        this.changeCoins = changeCoins;
    }

    public double getCoffeeAmount() {
        return CoffeeAmount;
    }

    public void setCoffeeAmount(double coffeeAmount) {
        CoffeeAmount = coffeeAmount;
    }

    public double getCoffeeBeansContainerMax() {
        return CoffeeBeansContainerMax;
    }

    public void setCoffeeBeansContainerMax(double coffeeBeansContainerMax) {
        CoffeeBeansContainerMax = coffeeBeansContainerMax;
    }

    public double getMilkAmount() {
        return MilkAmount;
    }

    public void setMilkAmount(double milkAmount) {
        MilkAmount = milkAmount;
    }

    public double getMilkTankMax() {
        return MilkTankMax;
    }

    public void setMilkTankMax(double milkTankMax) {
        MilkTankMax = milkTankMax;
    }

    public double getSugarAmount() {
        return sugarAmount;
    }

    public void setSugarAmount(double sugarAmount) {
        this.sugarAmount = sugarAmount;
    }

    public double getSugarContainerMax() {
        return sugarContainerMax;
    }

    public void setSugarContainerMax(double sugarContainerMax) {
        this.sugarContainerMax = sugarContainerMax;
    }

    public double getWaterAmount() {
        return WaterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        WaterAmount = waterAmount;
    }

    public double getWaterTankMax() {
        return WaterTankMax;
    }

    public void setWaterTankMax(double waterTankMax) {
        WaterTankMax = waterTankMax;
    }

    public ArrayList<Coffee> getCoffeesAvailable() {
        return coffeesAvailable;
    }

    public void setCoffeesAvailable(ArrayList<Coffee> coffeesAvailable) {
        this.coffeesAvailable = coffeesAvailable;
    }

    public double[] getChangeCoins() {
        return changeCoins;
    }

    public void setChangeCoins(double[] changeCoins) {
        this.changeCoins = changeCoins;
    }

    public int[] getChangeCoinsAmount() {
        return changeCoinsAmount;
    }

    public void setChangeCoinsAmount(int[] changeCoinsAmount) {
        this.changeCoinsAmount = changeCoinsAmount;
    }

    public void setChangeCoinsAmountByIndex(int index, int amount){
        this.changeCoinsAmount[index] = amount;
    }

    public int[] getChangeCoinsMaxAmount() {
        return changeCoinsMaxAmount;
    }

    public void setChangeCoinsMaxAmount(int[] changeCoinsMaxAmount) {
        this.changeCoinsMaxAmount = changeCoinsMaxAmount;
    }

    public void setChangeCoinsMaxAmountByIndex(int index, int amount){
        this.changeCoinsMaxAmount[index] = amount;
    }
    //CONSTRUCTOR, GETTERS AND SETTERS END HERE



    //FUNCTIONALITY OF THE COFFEE MACHINE STARTS HERE
    public void addCoffeeToMachine(String name, int coffeeNeeded, int milkNeeded, int waterNeeded, double price){
        this.coffeesAvailable.add(new Coffee(coffeeNeeded, milkNeeded, name, price, waterNeeded));
    }

    public void fillCoffeeContainer(double amount) {
        if (this.getCoffeeAmount() + amount <= this.getCoffeeBeansContainerMax()) this.setCoffeeAmount(this.getCoffeeAmount() + amount);
        else {
            System.out.print("The coffee amount would be more than the coffee container can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setCoffeeAmount(this.getCoffeeBeansContainerMax());
            }
        }
    }

    public void fillWaterContainer(double amount){
        if (this.WaterAmount + amount <= this.getWaterTankMax()) this.setWaterAmount(this.getWaterAmount() + amount);
        else {
            System.out.print("The water amount would be more than the tank can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setWaterAmount(this.getWaterTankMax());
            }
        }
    }

    public void fillMilkContainer(double amount){
        if (this.getMilkAmount() + amount <= this.getMilkTankMax()) this.setMilkAmount(this.getMilkAmount() + amount);
        else {
            System.out.print("The milk amount would be more than the tank can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setMilkAmount(this.getMilkTankMax());
            }
        }
    }
    public void fillSugarContainer(double amount){
        if (this.getSugarAmount() + amount <= this.getSugarContainerMax()) this.setSugarAmount(this.getSugarAmount() + amount);
        else {
            System.out.print("The milk amount would be more than the tank can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setSugarAmount(this.getSugarContainerMax());
            }
        }
    }

    public double[][] makeCoffee(double money, String coffeeType){
        Coffee coffeeToMake = null;
        double change;
        double[][] changeInCoins = new double[2][6];


        for (Coffee selectedCoffee : this.getCoffeesAvailable()){
            if (selectedCoffee.getName().equals(coffeeType)){
                coffeeToMake = selectedCoffee;
                break;
            }
        }

        if (coffeeToMake == null){
            System.out.println("The coffee you have selected does not exist. Try with another one.");
        } else {
            useCoffee(coffeeToMake.getCoffeeNeeded());
            useMilk(coffeeToMake.getMilkNeeded());
            useWater(coffeeToMake.getWaterNeeded());
            this.sugarAmount -= addSugarToCoffee();
            change = money - coffeeToMake.getPrice();
            changeInCoins = returnChangeInCoins(change);
        }

        return changeInCoins;

    }

    private void useCoffee(double amount){
        if (this.getCoffeeAmount() - amount > 0) this.setCoffeeAmount(this.getCoffeeAmount() - amount);
        else{
            System.out.println("The coffee in the machine is not enough to make the coffee you have selected." +
                                " Please fill the container.");
            System.out.print("Enter the amount of coffee to be added ot the container: ");
            double addAmount = scanner.nextDouble();
            this.fillCoffeeContainer(addAmount);
        }
    }

    private void useMilk(double amount){
        if (this.getMilkAmount() - amount > 0) this.setMilkAmount(this.getMilkAmount() - amount);
        else{
            System.out.println("The milk in the machine is not enough to make the coffee you have selected." +
                    " Please fill the container.");
            System.out.print("Enter the amount of milk to be added ot the tank: ");
            double addAmount = scanner.nextDouble();
            this.fillMilkContainer(addAmount);
        }
    }

    private void useWater(double amount){
        if (this.getWaterAmount() - amount > 0) this.setWaterAmount(this.getWaterAmount() - amount);
        else{
            System.out.println("The water in the machine is not enough to make the coffee you have selected." +
                    " Please fill the container.");
            System.out.print("Enter the amount of water to be added ot the tank: ");
            double addAmount = scanner.nextDouble();
            this.fillWaterContainer(addAmount);
        }
    }

    private double[][] returnChangeInCoins(double change){
        double[] changeCoins = this.getChangeCoins();
        double[] coinsAmount = {0, 0, 0, 0, 0, 0};
        double[][] changeAndCoinsAmount = {changeCoins, coinsAmount};
        double coin;

        for (int i = 0; i < changeCoins.length; i++){
            coin = changeCoins[i];
            int count = (int) (change / coin);

            if (count > 0 && this.getChangeCoinsAmount()[i] - count > 0) {
                changeAndCoinsAmount[1][i] = count;
                this.setChangeCoinsAmountByIndex(i, this.getChangeCoinsAmount()[i] - count);
                change -= count * coin;
            } else if (count > 0){
                changeAndCoinsAmount[1][i] = this.getChangeCoinsAmount()[i];
                this.setChangeCoinsAmountByIndex(i, 0);
                change -= this.getChangeCoinsAmount()[i] * coin;
            }
        }

        return changeAndCoinsAmount;
    }


    public void checkCoinAvailability(){
        double[] changeCoins = {0.05, 0.10, 0.20, 0.50, 1, 2};
        boolean check = false;

        for (int i = 0; i < changeCoins.length; i++){
            if(this.getChangeCoinsAmount()[i] <= 0.2 * this.getChangeCoinsMaxAmount()[i]) {
                System.out.println("The following coins have low availability: " + changeCoins[i] + " and up.");
                check = true;
                break;
            }
        }

        if (!check){
            System.out.println("There are no coins with particularly low quality.");
        }
    }


    public void addCoins(double coinType, int amount){
        double[] changeCoins = this.getChangeCoins();
        double coin;
        int coinIndex = 0;

        for (int i = 0; i < this.getChangeCoins().length; i++){
            coin = changeCoins[i];

            if (coin == coinType){
                coinIndex = i;
            }
        }

        this.setChangeCoinsAmountByIndex(coinIndex, this.getChangeCoinsAmount()[coinIndex] + amount);
    }

    private static double addSugarToCoffee(){
        double sugarMax = 0.01;
        System.out.println("""
                Enter how much sugar you want in your coffee from the options below:
                1. 1 scoop
                2. 2 scoops
                3. 3 scoops
                4. 4 scoops
                5. 5 scoops
                6. No sugar.""");

        int choice = scanner.nextInt();
        while (choice > 6 || choice < 1){
            System.out.println("The choice you have selected is out of scope. Please enter a valid choice!");
            choice = scanner.nextInt();
        }

        switch (choice){
            case 1: sugarMax *= 0.2;
            case 2: sugarMax *= 0.4;
            case 3: sugarMax *= 0.6;
            case 4: sugarMax *= 0.8;
            case 5:
            case 6: sugarMax = 0;
        }
        return sugarMax;
    }
}
