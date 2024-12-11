package OOP_NEW_YEAR.First_Term.Day_02;

import java.util.Scanner;

public class ex_06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = j + 1 + i;
            }
        }
        for (int[] row: matrix){
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
