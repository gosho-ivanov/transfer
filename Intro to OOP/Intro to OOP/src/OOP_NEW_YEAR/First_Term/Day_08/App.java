package OOP_NEW_YEAR.First_Term.Day_08;

public class App {
    public static void main(String[] args) {
        House[] houseComplex = makeHouses(2);
        System.out.println();
        //Building[] buildingComplex = makeBuilding(5);

        House biggestHouse = House.findBiggestHouse(houseComplex);
        System.out.println(biggestHouse.toString());

    }

    public static House[] makeHouses(int n){
        House[] houseArr = new House[n];
        for (int i = 0; i < n; i++) {
            houseArr[i] = House.addHouse();
            System.out.println("\n");
        }

        return houseArr;
    }

    public static Building[] makeBuilding(int n){
        Building[] buildingArr = new Building[n];
        for (int i = 0; i < n; i++) {
            buildingArr[i] = Building.addBuilding();
            System.out.println("\n");
        }

        return buildingArr;
    }

}
