package No1;

import java.util.Scanner;

public class maxNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] myNums = new int[n];
        int maxNum;
        int maxNumIndex;
        for (int i = 0; i < n; i++) {
            myNums[i] = s.nextInt();
        }
        maxNum = myNums[0];
        maxNumIndex = 0;
        int index = 0;
        for (int num: myNums) {
            if (num>maxNum){
                maxNum = num;
                maxNumIndex = index;
            }
            index ++;
        }
        System.out.println("Biggest number in the array is: " + maxNum + ". It is at index " + maxNumIndex + ".");
    }
}
