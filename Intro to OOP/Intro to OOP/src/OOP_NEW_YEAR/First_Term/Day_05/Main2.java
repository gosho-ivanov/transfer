package OOP_NEW_YEAR.Day_05;

import java.util.Arrays;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int[] newArr = createArray();
        System.out.println(Arrays.toString(newArr));
        System.out.println("The smallest value int the array at the odd indexes: " + findMinUnevenIndexLastDigitSeven(newArr));
        System.out.println("The array without the numbers that end in 9: " + Arrays.toString(removeNumsWithNine(newArr)));

    }

    public static int[] createArray(){
        Random rand = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    private static double avgElement(int[] arr){
        int sum = 0;
        for (int el : arr){
            sum += el;
        }
        return (double) sum/arr.length;
    }

    public static int[] lessThanAvg(int[] arr){
        double avg = avgElement(arr);
        int[] newArr = Arrays.copyOfRange(arr, 0 , arr.length);
        Arrays.sort(newArr);
        int index = 0;
        for (int num: newArr){
            if (num >= avg){
                index = Arrays.binarySearch(newArr, num);
            }
        }

        return Arrays.copyOfRange(newArr, 0, index);
    }

    public static int findMinUnevenIndexLastDigitSeven(int[] arr){
        int min = 1001;
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] % 10 == 7){
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
        }
        return min;
    }

    public static int[] removeNumsWithNine(int[] arr){
        int[] newArr = new int[arr.length];
        int index = 0;
        for (int num : arr){
            if (num % 10 != 9){
                newArr[index++] = num;
            }
        }
        return  newArr;
    }
}
