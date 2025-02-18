package OOP_NEW_YEAR.Second_Term.Day_02;

import java.util.ArrayList;

public class Ads {
    private Car[] carAds;

    public Ads() {
        carAds = new Car[10];
    }

    public Car[] getCarAds() {
        return carAds;
    }

    public void setCarAds(Car[] carAds) {
        this.carAds = carAds;
    }

    public void addCarAd(Car car){
        for (int i = 0; i < carAds.length; i++) {
            Car carAd = carAds[i];
            if (carAd != null) {
                if (carAd.getVinNumber().equals(car.getVinNumber())) {
                    System.out.println("This car is already for sale.");
                    break;
                }
            } else {
                carAds[i] = car;
                break;
            }
        }

    }

    public void removeCarAd(String vin){
        for (int i = 0; i < carAds.length; i++){
            if (vin.equals(carAds[i].getVinNumber())) {
                carAds[i] = null;
                break;
            }
        }
    }

    public void getCarInfo(String manufacturer, String model){
        if (manufacturer.equals("") && model.equals("")){
            for (Car carAd: carAds) if (carAd != null) System.out.println(carAd.toString());
        } else {
            for (Car carAd: carAds){
                if (manufacturer.equals(carAd.getManufacturer()) && model.equals(carAd.getModel())) {
                    System.out.println(carAd.toString());
                }
            }
        }
    }

    public void getMostExpensiveCarInfo(){
        double maxPrice = 0.0;
        int mostExpensiveCarIndex = 0;
        for (int i = 0; i < carAds.length; i++ ){
            if (carAds[i] != null) {
                if (carAds[i].getPrice() > maxPrice) {
                    mostExpensiveCarIndex = i;
                    maxPrice = carAds[i].getPrice();
                }
            }
        }
        if (carAds[mostExpensiveCarIndex] != null) {
            System.out.println(carAds[mostExpensiveCarIndex].toString());
        }
    }
}
