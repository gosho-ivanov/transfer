package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Arrays;
import java.util.Scanner;

public class ex_08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("The size of the array: ");
        int N = s.nextInt();
        System.out.println();
        int[] a = new int[N];
        int[] sortedA = new int[N];

        for (int j = 0; j < N; j++) {
            int x = s.nextInt();
            a[j] = x;
            sortedA[j] = x;
        }


        Arrays.sort(sortedA);

        if (Arrays.equals(a, sortedA)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
