package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Arrays;
import java.util.Scanner;

public class ex_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("The size of the arrays: ");
        int N = scan.nextInt();
        System.out.println();
        int[] a = new int[N];
        int[] b = new int[N];

        System.out.println("Filling Array 1:");
        a = fillArray(N, a, scan);
        System.out.println("\nFilling Array 2:");
        b = fillArray(N, b, scan);

        for (int i = 0; i < N; i++) {
            if (a[i] > b[i]){
                System.out.printf("Index &d: arr 1 is bigger\n", i);
            } else if (b[i] > a[i]) {
                System.out.printf("Index %d: arr 2 is bigger\n", i);
            } else {
                System.out.printf("Index %d: arrays are equal\n", i);
            }
        }

        System.out.printf("Array 1 and Array 2 are equal: %b", Arrays.equals(a, b));
    }
    public static int[] fillArray(int index, int[] arr, Scanner s){
        for (int i = 0; i < index; i++) {
            int x = s.nextInt();
            arr[i] = x;
        }
        return arr;
    }
}
