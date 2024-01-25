public class Izpitvane {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int sum_arr = sum_arr(arr);
        System.out.println(sum_arr);
    }
    public static int sum_arr(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] *= -1;
            }
            sum += a[i];
        }
        return sum;
    }
}

