package OOP_NEW_YEAR.Second_Term.Day_04;

public class Main {
    public static void main(String[] args) {
        try {
            Car car = new Car(280, "Mercedes C220", 6700.00, 140);
            Hovercraft hcr = new Hovercraft(80, "RLG-innovations eurocraft", 60_000.00, 4);
            Ship ship = new Ship(100, "USS Missouri", 1_500_00.00, 50);

            System.out.println("The promotional price of the car is: " + car.checkPromo());
            System.out.println("The promotional price of the hovercraft is: " + hcr.checkPromo());
            System.out.println("The promotional price of the ship is: " + ship.checkPromo());

            hcr.enterSea();
            hcr.enterLand();
        } catch (SpeedException | PriceException e){
            System.out.println(e.getMessage());
        }
    }
}
