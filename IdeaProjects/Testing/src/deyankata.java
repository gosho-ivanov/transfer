import java.util.Scanner;

public class deyankata {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] myArr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++){
            myArr[i] = s.nextInt();
            if (myArr[i] < 0){
                myArr[i] = myArr[i] * -1;
            }
            sum += myArr[i];
        }
        System.out.println(sum);
    }
}
