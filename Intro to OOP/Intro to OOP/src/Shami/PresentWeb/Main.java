package Shami.PresentWeb;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Present[] presents = new Present[10];
        Present present = null;
        for (int i= 0; i < 10; i++) {
            int id = scanner.nextInt();
            double price = scanner.nextDouble();
            String type = scanner.nextLine();
            String size = scanner.nextLine();
            present = new Present(id, price, size, type);
            presents[i] = present;
        }

        Present present1 = Present.getPresentByID(presents, 1);
        Present present2 = Present.getPresentByType(presents, "clothing");
        if (present1 != null) System.out.println(present1.toString());
        if (present2 != null) System.out.println(present2.toString());
    }


}
