package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] a = new int[N];

        for (int j = 0; j < N; j++) {
            int x = s.nextInt();
            a[j] = x;
        }

        boolean x = false;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j ++){
                if (i == j){
                    System.out.println(i);
                    x = true;
                    break;
                }
            }
            if (x) {
                break;
            }
        }
    }
}
