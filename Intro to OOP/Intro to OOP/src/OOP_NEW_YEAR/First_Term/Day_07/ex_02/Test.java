package OOP_NEW_YEAR.First_Term.Day_07.ex_02;

public class Test {
    public static void main(String[] args) {
        Books b1 = new Books(21.99, 1, "Frank Herbert", "Dune");
        TV t1 = new TV(299.99, 2, "Sony", "Bravia", 450);
        int bookSalePercentage = 15;
        int TVSalePercentage = 9;

        b1.setPrice(b1.checkPromo(bookSalePercentage));
        t1.setPrice(t1.checkPromo(TVSalePercentage));
    }
}
