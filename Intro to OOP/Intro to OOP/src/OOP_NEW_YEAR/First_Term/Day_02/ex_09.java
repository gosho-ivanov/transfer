package OOP_NEW_YEAR.Day_02;

import java.util.Scanner;

public class ex_09 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("The size of the array: ");
        int N = s.nextInt();
        System.out.println();
        int[] a = new int[N];

        for (int j = 0; j < N; j++) {
            int x = s.nextInt();
            a[j] = x;
        }

        boolean isMirrored = false;
        for (int i = 0; i <= N/2; i++){
            if (a[i] == a[N-1-i]) {
                isMirrored = true;
            } else {
                isMirrored = false;
                break;
            }
        }

        if (isMirrored) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
