public class variant_1 {
    public static void main(String[] args) {
        boolean beginningSide = false;
        boolean otherSide = true;
        boolean wolf = beginningSide;
        boolean goat = beginningSide;
        boolean cabbage = beginningSide;
        int count = 1;
        while (!wolf || !cabbage || !goat) {
        if (wolf == goat && goat == beginningSide) {
            goat = otherSide;
            System.out.println(count + ". Goat -> Right; Wolf -> Left; Cabbage -> Left");
            count++;
            System.out.println(count + ". We return to the left shore empty-handed");
            count++;
            continue;
        }
        if (wolf == goat && goat == otherSide) {
            goat = beginningSide;
            System.out.println(count + ". Goat -> Left; Wolf -> Right; Cabbage -> Left");
            count++;
            continue;
        }
        if (goat == cabbage && cabbage == beginningSide) {
            cabbage = otherSide;
            System.out.println(count + ". Goat -> Left; Wolf -> Right; Cabbage -> Right");
            count++;
            System.out.println(count + ". We return to the left shore empty-handed");
            count++;
            continue;
        }
        if (wolf == cabbage && cabbage == beginningSide) {
            wolf = otherSide;
            System.out.println(count + ". Goat -> Right; Wolf -> Right; Cabbage -> Left");
            count++;
            continue;
        }
        if (cabbage == otherSide && wolf == otherSide && goat == beginningSide) {
            goat = otherSide;
            System.out.println(count + ". Goat -> Right; Wolf -> Right; Cabbage -> Right");
            }
        }
    }
}

