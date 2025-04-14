package OOP_NEW_YEAR.Second_Term.Day_07;

public class Main {
    public static void main(String[] args) {
        try {
            Automobile car1 = new Automobile("Honda", "1234567890", "diesel", "Civic", 5_000, 1995);
            Automobile car2 = new Automobile("Mercedes-Benz", "2345678901", "petrol", "C220", 5_999.99, 2006);
            Automobile car3 = new Automobile("Daewoo", "3456789012", "gas", "Damas", 599.99, 1991);
            Ads carAds = new Ads();
            carAds.addAd(car1);
            carAds.addAd(car2);
            carAds.addAd(car3);
            carAds.getMostExpensiveAd();
            carAds.getAdInfo("Honda", "");
            carAds.getAdInfo("", "");
            carAds.getAdInfo("", "C220");
            carAds.removeAd("1234567890");
            Automobile car4 = new Automobile("Honda", "4567890123", "gas", "Civic", -1000, 1994);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
