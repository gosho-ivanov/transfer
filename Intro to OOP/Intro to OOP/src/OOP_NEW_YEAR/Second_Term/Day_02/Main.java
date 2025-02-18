package OOP_NEW_YEAR.Second_Term.Day_02;

public class Main {
    public static void main(String[] args) {
        Ads olx = new Ads();
        olx.addCarAd(new Car("petrol", "Ford", "Fiesta", 16999.99, "12345678910", 2015));
        olx.addCarAd(new Car("diesel", "Mercedes-Benz", "C220", 7000.89, "10987654321", 2005));
        olx.addCarAd(new Car("gas", "Nissan", "Murano", 17999, "24681013579", 2009));

        olx.getMostExpensiveCarInfo();
        olx.getCarInfo("", "");
        olx.removeCarAd("24681013579");

    }
}
