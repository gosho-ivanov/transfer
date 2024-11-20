package OOP_NEW_YEAR.Day_06.Ex_02;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] cpuCores = {4, 6, 8, 2, 4, 6, 8, 8};
        MultiProcessor m1 = new MultiProcessor(8, cpuCores, 5.7);
        System.out.println(Arrays.toString(m1.clockPerCPU()));
        System.out.println(m1.getProccessTime(2, 4));
    }
}
