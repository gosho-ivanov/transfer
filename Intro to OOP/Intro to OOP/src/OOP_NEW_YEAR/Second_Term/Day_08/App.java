package OOP_NEW_YEAR.Second_Term.Day_08;

public class App {
    public static void main(String[] args) {
        try {
            Provider p = new Provider("Ivan", "0893478049");
            //Provider e = new Provider("Gosho", "+359877070361");
            Electronics el = new Electronics(1, 15, p, 20, "iPhone 13", "Apple");
            Book b = new Book(2, 20, p, 20, "George Bush", "Something");
            System.out.println(el.getPromotionalPrice());
            System.out.println(b.getPromotionalPrice());
            el.sellProduct(20);
            b.sellProduct(20);
            b.sellProduct(1);
            el.sellProduct(1);
        }
        catch (WrongPhoneNumberException e) {
            System.out.println(e.getMessage());
        }
        catch (NoMoreProductsException e) {
            System.out.println(e.getMessage());
        }
    }
}
