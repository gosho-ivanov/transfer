package OOP_NEW_YEAR.First_Term.Day_05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(sortAndfilter(arr, 7)));
    }

    public static int[] sortAndfilter(int[] arr, int key){
        int[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        int index = 0;
        Arrays.sort(newArr);
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] > key){
                index = i;
                break;
            }
        }
        return Arrays.copyOfRange(newArr, 0, index);

    }
}
