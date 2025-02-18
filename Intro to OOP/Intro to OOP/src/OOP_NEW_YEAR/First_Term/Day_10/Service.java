package OOP_NEW_YEAR.First_Term.Day_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Device> devices = makeArrListOfDevices(5, scanner);
        ArrayList<BrokenDevice> brokenDevices = makeArrOfBrokenDevices(5, scanner);
    }

    public static ArrayList<Device> makeArrListOfDevices(int n, Scanner scanner){
        ArrayList<Device> deviceArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deviceArr.set(i, Device.createDevice(scanner));
        }
        return deviceArr;
    }

    public static ArrayList<BrokenDevice> makeArrOfBrokenDevices(int n, Scanner scanner){
        ArrayList<BrokenDevice> deviceArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deviceArr.set(i, BrokenDevice.createBrokenDevice(scanner));
        }
        return deviceArr;
    }

    public static void getAllDevices(ArrayList<Device> devices){
        for (Device device: devices){
            System.out.println(device.toString());
        }
    }

    public static void getAllBrokenDevices(ArrayList<BrokenDevice> devices){
        for (BrokenDevice device: devices){
            System.out.println(device.toString());
        }
    }

    public static void addDevice(ArrayList<Device> devices, Scanner scanner){
        devices.add(Device.createDevice(scanner));
    }

    public static void addBrokenDevice(ArrayList<BrokenDevice> brokenDevices, Scanner scanner){
        brokenDevices.add(BrokenDevice.createBrokenDevice(scanner));
    }

    public static void fixDevice(ArrayList<BrokenDevice> brokenDevices,ArrayList<Device> devices, BrokenDevice brokenDevice){
        if (brokenDevices.contains(brokenDevice)){
            brokenDevices.remove(brokenDevice);
            Device fixedDevice = new Device(brokenDevice.getMaker(), brokenDevice.getModel(), brokenDevice.getPrice());
            devices.add(fixedDevice);
        }
    }

    public static void getAllBrokenDevicesWithTheSameProblem(ArrayList<BrokenDevice> brokenDevices, String problem){
        for (BrokenDevice device: brokenDevices){
            if (device.getProblem().equals(problem)){
                System.out.println(device.toString());
            }
        }
    }

    public static double getPricesForAllDevices(ArrayList<Device> devices){
        double totalPrice = 0;
        for (Device device: devices){
            totalPrice += device.getPrice();
        }
        return totalPrice;
    }

    public static double getEarnignsForFixingAllBrokenDevices(ArrayList<BrokenDevice> brokenDevices, double fixingCostPerDevice){
        double totalPrice = 0;
        for (BrokenDevice device: brokenDevices){
            totalPrice += device.getPrice();
        }
        return totalPrice - (brokenDevices.size() * fixingCostPerDevice);
    }
}
