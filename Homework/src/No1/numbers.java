package No1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class numbers {
    public static int[] digits(int[] nums){
        List<Integer> digits = new ArrayList<Integer>();
        for (int num : nums) {
            int[] temp = new int[String.valueOf(num).length()];
            int index = 0;
            while (num > 0) {
                int digit = num % 10;
                temp[index] = digit;
                num /= 10;
                index++;
            }
            for (int i = temp.length - 1; i >= 0; i--) {
                digits.add(temp[i]);
            }
        }
        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        System.out.print("Numbers: [");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1){
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + ", ");
            }
        }
        System.out.println("]");
        int[] result = digits(nums);
        System.out.print("Digits: [");
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1){
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
