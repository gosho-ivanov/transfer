package OOP_NEW_YEAR.Day_06;

public class ElectricalDevice {
    private int voltage;
    private String cpu;

    public ElectricalDevice(){
        this.voltage = 0;
        this.cpu = null;
    }

    public ElectricalDevice(int voltage, String cpu){
        this.voltage = voltage;
        this.cpu = cpu;
    }

    public int getVoltage() {
        return voltage;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public void turnOn(){
        System.out.println("The device has been turned on.");
    }

    public void turnOff(){
        System.out.println("The device has been turned off.");
    }
}

