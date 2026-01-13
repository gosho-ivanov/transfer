package Shami.PresentWeb.trolli;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("vuvedi broi producti");
        int broi = sc.nextInt();

        Producti[] pr = new Producti[broi];

        for (int i=0;i<broi;i++){
            System.out.println("vuvedi paramentri za product");
            int id = sc.nextInt();
           double price = sc.nextDouble();
           String size = sc.nextLine();
           String type =sc.nextLine();
           Producti product = new Producti(id, price, size, type );
           pr[i] = product;

        }

    }

}
