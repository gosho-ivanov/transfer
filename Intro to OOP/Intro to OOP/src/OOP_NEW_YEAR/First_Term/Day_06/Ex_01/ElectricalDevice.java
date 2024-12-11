package OOP_NEW_YEAR.First_Term.Day_06.Ex_01;

public class ElectricalDevice {
    private int voltage;
    private String cpu;
    private boolean isON = false;

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
        if (!isON) {
            System.out.println("The device has been turned on.");
            isON = true;
        } else {
            System.out.println("The device was already on.");
        }
    }

    public void turnOff(){
        if (!isON) {
            System.out.println("The device was already off.");
        } else {
            System.out.println("The device has been turned off..");
            this.isON = false;
        }
    }
}

