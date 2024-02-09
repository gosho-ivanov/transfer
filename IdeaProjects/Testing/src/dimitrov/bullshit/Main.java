package dimitrov.bullshit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] myArr = new int[n];
        for (int i = 0; i < n; i++) {
            myArr[i] = s.nextInt();
        }

        MyClass returnValues = myFunc(myArr);
        System.out.println(returnValues.arr1);
        System.out.println(returnValues.arr2);
    }
    public static MyClass myFunc(int[] myArr){
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> uneven = new ArrayList<>();
        for (int num : myArr){
            if (num%2==0){
                even.add(num*2);
            }
            else{
                uneven.add(num);
            }
        }
        int[] evenArr = new int[even.size()];
        int[] unevenArr = new int[uneven.size()];
        int counter = 0;
        for (int i = unevenArr.length; i>=1;i--){
            unevenArr[counter] = uneven.get(i);
            counter++;
        }

        return new MyClass(evenArr, unevenArr);
    }
}
class MyClass {
    int[] arr1;
    int[] arr2;

    public MyClass(int[] a, int[] b) {
        this.arr1 = a;
        this.arr2 = b;
    }
}