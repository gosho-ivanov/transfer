package OOP_NEW_YEAR.Second_Term.Day_07;

import java.util.ArrayList;

public class Ads {
    private ArrayList<Automobile> ads;

    public Ads() {
        this.ads = new ArrayList<>();
    }

    public ArrayList<Automobile> getAdds() {
        return ads;
    }

    public void setAdds(ArrayList<Automobile> adds) {
        this.ads = adds;
    }

    public void addAd(Automobile newAd){
        boolean flag = true;
        for (Automobile ad: ads){
            if (ad.getEngineSerialNumber().equals(newAd.getEngineSerialNumber())){
                flag = false;
            }
        }
        if (flag) ads.add(newAd);
        else System.out.println("This ad already exists.");
    }

    public void removeAd(String serialNumber){
        for (Automobile ad: ads){
            if (ad.getEngineSerialNumber().equals(serialNumber)){
                ads.remove(ad);
                break;
            }
        }
    }

    public void getAdInfo(String brand, String model){
        if (brand.equals("") && model.equals("")){
            for (Automobile ad: ads){
                ad.getAutomobileInfo();
            }
        } else if (model.equals("")) {
            for (Automobile ad: ads){
                if (ad.getBrand().equals(brand)) ad.getAutomobileInfo();
            }
        } else if (brand.equals("")) {
            for (Automobile ad: ads){
                if (ad.getModel().equals(model)) ad.getAutomobileInfo();
            }
        } else {
            for (Automobile ad: ads){
                if (ad.getBrand().equals(brand) && ad.getModel().equals(model)) ad.getAutomobileInfo();
            }
        }
    }

    public void getMostExpensiveAd(){
        double maxPrice = 0;
        int index = -1;
        for (Automobile ad: ads){
            if (ad.getPrice() > maxPrice){
                maxPrice = ad.getPrice();
                index = ads.indexOf(ad);
            }
        }
        ads.get(index).getAutomobileInfo();
    }
}
