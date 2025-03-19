package OOP_NEW_YEAR.Second_Term.Day_06;

public class Main {
    public static void main(String[] args) {
        try{
            TV tv1 = new TV(150, 1, "Sony", "Bravia", 15);
            Book b1 = new Book(14, 2, "King", "Clown");
            System.out.println(tv1.checkPromo());
            System.out.println(tv1.getPowerConsumption(4));

            Client cl1 = new Client("Sofia, bl.112", "abvg","21504@uktc-bg.com", "Georgi");
            cl1.addToBasket(tv1);
            cl1.addToBasket(b1);
            cl1.removeFromBasket(tv1);
            cl1.placeOrder();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
