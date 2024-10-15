package OOP_NEW_YEAR;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Въведете вашето първо име: ");
        String fName = s.nextLine();

        System.out.println("Въведете вашата фамилия: ");
        String lName = s.nextLine();

        System.out.println("Къде сте родени: ");
        String birthPlace = s.nextLine();

        System.out.println("На колко години сте: ");
        String age = s.nextLine();

        System.out.println("Какво образование имате: ");
        String qualification = s.nextLine();

        System.out.println("Къде работите: ");
        String workPlace = s.nextLine();

        System.out.println("Кой е вашият любим музикален изпълнител");
        String favPerformer = s.nextLine();
        System.out.println();

        String[] biography = {fName, lName, birthPlace, age, qualification, workPlace, favPerformer};
        for (String n : biography){System.out.println(n);}
    }
}
