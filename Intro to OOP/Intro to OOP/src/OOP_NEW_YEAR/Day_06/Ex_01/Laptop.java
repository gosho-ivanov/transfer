package OOP_NEW_YEAR.Day_06.Ex_01;

public class Laptop extends ElectricalDevice {
    private int ramCapacity;
    public int storageCapacity;

    public Laptop(){
        super();
        this.ramCapacity = 0;
        this.storageCapacity = 0;
    }

    public Laptop(int voltage, String cpu, int RAM, int storage){
        super(voltage, cpu);
        this.ramCapacity = RAM;
        this.storageCapacity = storage;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String toString(){
        return "This laptop has a " + this.getCpu() + " CPU;"
                +  "a " + this.getVoltage() + "V power supply;"
                + " " + this.getRamCapacity() + "GB of RAM;"
                + " " + this.getStorageCapacity() + "GB of storage.";
    }

    public boolean isBetter(Laptop lp2){
        if (this.getRamCapacity() > lp2.getRamCapacity() && this.getStorageCapacity() > lp2.getStorageCapacity()){
            return true;
        } else return false;
    }
}
