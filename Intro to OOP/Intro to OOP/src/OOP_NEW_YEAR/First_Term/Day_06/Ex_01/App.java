package OOP_NEW_YEAR.Day_06.Ex_01;

public class App {
    public static void main(String[] args) {
        ElectricalDevice e1 = new ElectricalDevice();
        ElectricalDevice e2 = new ElectricalDevice(750, "i7 14700KF");

        e1.setCpu("i9 13900KS");
        e1.setVoltage(1200);
        System.out.println(e1.getVoltage());
        System.out.println(e2.getCpu());


        Laptop myLaptop = new Laptop(450, "Apple M2", 16, 256);
        Laptop l2 = new Laptop();
        l2.setCpu("Apple M4");
        l2.setRamCapacity(24);
        l2.setVoltage(650);
        l2.setStorageCapacity(512);

        System.out.println(l2.isBetter(myLaptop));
        System.out.println(myLaptop.toString());
    }
}
