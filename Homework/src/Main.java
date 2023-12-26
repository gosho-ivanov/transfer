import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {123, 456, 789};
        int[] result = extractDigits(numbers);

        // Пример за извеждане на резултата
        System.out.print("Цифри: ");
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }

    static int[] extractDigits(int[] numbers) {
        List<Integer> digitsList = new ArrayList<>();

        for (int number : numbers) {
            int temp = number;
            // Извличане на цифрите от числото и добавяне към списъка
            while (temp > 0) {
                int digit = temp % 10;
                digitsList.add(digit);
                temp /= 10;
            }
        }

        // Преобразуване на списъка от цифри в масив
        int[] result = new int[digitsList.size()];
        for (int i = digitsList.size() - 1; i >= 0; i--) {
            result[digitsList.size() - 1 - i] = digitsList.get(i);
        }

        return result;
    }
}