package Day_01;

public class ex_01 {
    public static void main(String[] args) {
        Car myCar = new Car("black", "Mercedes-Benz E500", 2008);
        System.out.println(myCar.getInfo());
    }
}

class Car {
    private String name;
    private String color;
    private int year;

    public Car(String newColor, String newName, int newYear){
        this.color = newColor;
        this.name = newName;
        this.year = newYear;
    }
    public String getInfo(){
        return "Name: " + this.name + "\nColor: " + this.color + "\nYear of production: " + this.year;
    }
}