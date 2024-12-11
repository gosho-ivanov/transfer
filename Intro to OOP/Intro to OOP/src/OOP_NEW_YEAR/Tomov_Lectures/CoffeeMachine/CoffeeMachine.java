package lecture.CoffeeMachine;

import java.util.HashMap;
import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner scanner = new Scanner(System.in);


    //FIELDS START HERE
    private double CoffeeAmount;
    private double WaterAmount;
    private double MilkAmount;
    private double sugarAmount;
    private double sugarContainerMax;
    private HashMap<String, String> CoffeeTypeAndProductsAmount;
    private HashMap<String, Double> CoffeeTypeAndPrice;
    private HashMap<Double, Integer> ChangeTypeAndAmount;
    private HashMap<Double, Integer> ChangeTypeAndMaxAmount;
    private double CoffeeBeansContainerMax;
    private double WaterTankMax;
    private double MilkTankMax;
    //FIELDS END HERE


    //CONSTRUCTOR, GETTERS AND SETTERS START HERE
    public CoffeeMachine(double coffeeAmount, double coffeeBeansContainerMax, HashMap<String, Double> coffeeTypeAndPrice,
                         double milkAmount, double milkTankMax, double waterAmount, double waterTankMax,
                         HashMap<Double, Integer> ChangeTypeAndAmount, HashMap<String, String> CoffeeTypeAndProductsAmount,
                         HashMap<Double, Integer> ChangeTypeAndMaxAmount, double sugarAmount, double sugarContainerMax) {
        this.CoffeeAmount = coffeeAmount;
        this.CoffeeBeansContainerMax = coffeeBeansContainerMax;
        this.CoffeeTypeAndPrice = coffeeTypeAndPrice;
        this.MilkAmount = milkAmount;
        this.MilkTankMax = milkTankMax;
        this.WaterAmount = waterAmount;
        this.WaterTankMax = waterTankMax;
        this.ChangeTypeAndAmount = ChangeTypeAndAmount;
        this.CoffeeTypeAndProductsAmount = CoffeeTypeAndProductsAmount;
        this.ChangeTypeAndMaxAmount = ChangeTypeAndMaxAmount;
        this.sugarAmount = sugarAmount;
        this.sugarContainerMax = sugarContainerMax;
    }

    public double getSugarAmount() {
        return this.sugarAmount;
    }

    public void setSugarAmount(double sugarAmount) {
        this.sugarAmount = sugarAmount;
    }

    public double getSugarContainerMax() {
        return this.sugarContainerMax;
    }

    public void setSugarContainerMax(double sugarContainerMax) {
        this.sugarContainerMax = sugarContainerMax;
    }

    public double getCoffeeAmount() {
        return this.CoffeeAmount;
    }

    public void setCoffeeAmount(double coffeeAmount) {
        this.CoffeeAmount = coffeeAmount;
    }

    public double getCoffeeBeansContainerMax() {
        return this.CoffeeBeansContainerMax;
    }

    public void setCoffeeBeansContainerMax(double coffeeBeansContainerMax) {
        this.CoffeeBeansContainerMax = coffeeBeansContainerMax;
    }

    public HashMap<String, Double> getCoffeeTypeAndPrice() {
        return this.CoffeeTypeAndPrice;
    }

    public void setCoffeeTypeAndPrice(HashMap<String, Double> coffeeTypeAndPrice) {
        this.CoffeeTypeAndPrice = coffeeTypeAndPrice;
    }

    public double getMilkAmount() {
        return this.MilkAmount;
    }

    public void setMilkAmount(double milkAmount) {
        this.MilkAmount = milkAmount;
    }

    public double getMilkTankMax() {
        return this.MilkTankMax;
    }

    public void setMilkTankMax(double milkTankMax) {
        this.MilkTankMax = milkTankMax;
    }

    public double getWaterAmount() {
        return this.WaterAmount;
    }

    public void setWaterAmount(double waterAmount) {
        this.WaterAmount = waterAmount;
    }

    public double getWaterTankMax() {
        return this.WaterTankMax;
    }

    public void setWaterTankMax(double waterTankMax) {
        this.WaterTankMax = waterTankMax;
    }

    public HashMap<Double, Integer> getChangeTypeAndAmount() {
        return this.ChangeTypeAndAmount;
    }

    public void setChangeTypeAndAmount(HashMap<Double, Integer> changeTypeAndAmount) {
        this.ChangeTypeAndAmount = changeTypeAndAmount;
    }

    public HashMap<String, String> getCoffeeTypeAndProductsAmount() {
        return this.CoffeeTypeAndProductsAmount;
    }

    public void setCoffeeTypeAndProductsAmount(HashMap<String, String> coffeeTypeAndProductsAmount) {
        this.CoffeeTypeAndProductsAmount = coffeeTypeAndProductsAmount;
    }

    public HashMap<Double, Integer> getChangeTypeAndMaxAmount() {
        return this.ChangeTypeAndMaxAmount;
    }

    public void setChangeTypeAndMaxAmount(HashMap<Double, Integer> changeTypeAndMaxAmount) {
        this.ChangeTypeAndMaxAmount = changeTypeAndMaxAmount;
    }
    //CONSTRUCTOR, GETTERS AND SETTERS END HERE



    //FUNCTIONALITY OF THE COFFEE MACHINE STARTS HERE
    public void addCoffeeTypeAndPrice(String coffeeType, double price){
        this.CoffeeTypeAndPrice.put(coffeeType, price);
    }

    public void addCoffee(double amount) {
        if (this.getCoffeeAmount() + amount <= this.getCoffeeBeansContainerMax()) this.setCoffeeAmount(this.getCoffeeAmount() + amount);
        else {
            System.out.print("The coffee amount would be more than the coffee container can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setCoffeeAmount(this.getCoffeeBeansContainerMax());
            }
        }
    }

    public void addWater(double amount){
        if (this.WaterAmount + amount <= this.getWaterTankMax()) this.setWaterAmount(this.getWaterAmount() + amount);
        else {
            System.out.print("The water amount would be more than the tank can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setWaterAmount(this.getWaterTankMax());
            }
        }
    }

    public void addMilk(double amount){
        if (this.getMilkAmount() + amount <= this.getMilkTankMax()) this.setMilkAmount(this.getMilkAmount() + amount);
        else {
            System.out.print("The milk amount would be more than the tank can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setMilkAmount(this.getMilkTankMax());
            }
        }
    }
    public void addSugar(double amount){
        if (this.getSugarAmount() + amount <= this.getSugarContainerMax()) this.setSugarAmount(this.getSugarAmount() + amount);
        else {
            System.out.print("The milk amount would be more than the tank can handle. Would you like to fill it the max? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                this.setSugarAmount(this.getSugarContainerMax());
            }
        }
    }

    public HashMap<Double, Integer> makeCoffee(double money, String coffeeType){
        String[] productsNeeded = this.CoffeeTypeAndProductsAmount.get(coffeeType).split(" ");
        double coffeeNeeded = (double) Integer.parseInt(productsNeeded[0]) / 1000;
        double waterNeeded = (double) Integer.parseInt(productsNeeded[1]) / 1000;
        double milkNeeded = (double) Integer.parseInt(productsNeeded[2]) / 1000;
        useCoffee(coffeeNeeded);
        useMilk(milkNeeded);
        useWater(waterNeeded);
        this.sugarAmount -= addSugarToCoffee();
        double priceCoffee = this.getCoffeeTypeAndPrice().get(coffeeType);
        double change = money - priceCoffee;
        return this.returnChangeInCoins(change);
    }

    private void useCoffee(double amount){
        if (this.getCoffeeAmount() - amount > 0) this.setCoffeeAmount(this.getCoffeeAmount() - amount);
        else{
            System.out.println("The coffee in the machine is not enough to make the coffee you have selected." +
                                " Please fill the container.");
            System.out.print("Enter the amount of coffee to be added ot the container: ");
            double addAmount = scanner.nextDouble();
            this.addCoffee(addAmount);
        }
    }

    private void useMilk(double amount){
        if (this.getMilkAmount() - amount > 0) this.setMilkAmount(this.getMilkAmount() - amount);
        else{
            System.out.println("The milk in the machine is not enough to make the coffee you have selected." +
                    " Please fill the container.");
            System.out.print("Enter the amount of milk to be added ot the tank: ");
            double addAmount = scanner.nextDouble();
            this.addMilk(addAmount);
        }
    }

    private void useWater(double amount){
        if (this.getWaterAmount() - amount > 0) this.setWaterAmount(this.getWaterAmount() - amount);
        else{
            System.out.println("The water in the machine is not enough to make the coffee you have selected." +
                    " Please fill the container.");
            System.out.print("Enter the amount of water to be added ot the tank: ");
            double addAmount = scanner.nextDouble();
            this.addWater(addAmount);
        }
    }

    private HashMap<Double, Integer> returnChangeInCoins(double change){
        double[] changeCoins = {0.05, 0.10, 0.20, 0.50, 1, 2};
        //
        HashMap<Double, Integer> ChangeInCoins = new HashMap<>();
        double coin;
        for (int i = changeCoins.length - 1; i > -1; i--){
            if (this.getChangeTypeAndAmount().get(changeCoins[i]) > 0) {
                coin = changeCoins[i];
                int count = (int) (change / coin);
                if (count > 0 && this.getChangeTypeAndAmount().get(coin) - count != 0) {
                    ChangeInCoins.put(coin, count);
                    change -= count * coin;
                } else {
                    ChangeInCoins.put(coin, this.getChangeTypeAndAmount().get(coin));
                    change -= this.getChangeTypeAndAmount().get(coin) * coin;
                }
            }
        }
        return ChangeInCoins;
    }


    public void checkCoinAvailability(){
        double[] changeCoins = {0.05, 0.10, 0.20, 0.50, 1, 2};
        for (int i = changeCoins.length - 1; i > -1; i--){
            if(this.getChangeTypeAndAmount().get(changeCoins[i]) <= 0.2* this.getChangeTypeAndMaxAmount().get(changeCoins[i])){
                System.out.println("The following coins have low availability: " + this.getChangeTypeAndAmount().get(changeCoins[i]) + " and up.");
            }
        }
    }

    public void addCoins(double coinType, int amount){
        this.getChangeTypeAndAmount().replace(coinType, this.getChangeTypeAndAmount().get(coinType) + amount);
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
