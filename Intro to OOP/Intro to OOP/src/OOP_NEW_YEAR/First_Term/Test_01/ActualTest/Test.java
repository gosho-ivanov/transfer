package OOP_NEW_YEAR.First_Term.Test_01.ActualTest;

import OOP_NEW_YEAR.First_Term.Test_01.Prep.Student;

public class Test {
    public static void main(String[] args) {
        Pilot[] arrOfPilots = createGroupOfPilots(5);
        RetiredPilot[] arrOFRetiredPilots = createGroupOfRetiredPilots(5);

        Pilot piltoToFind = Pilot.createPilot();
        findAPilotInAnArray(arrOfPilots, piltoToFind);
        System.out.println("Is the " + piltoToFind.toString() + "in the array: " +
                findAPilotInAnArray(arrOfPilots, piltoToFind));


        arrOfPilots[3] = updatePilotInfo(Pilot.createPilot());
        System.out.println(findPilotWithMostFlyingHours(arrOfPilots).toString());
    }

    public static Pilot[] createGroupOfPilots(int n){
        Pilot[] groupOfPilots = new Pilot[n];
        for (int i = 0; i< n; i++){
            groupOfPilots[i] = Pilot.createPilot();
            System.out.println();
        }
        return  groupOfPilots;
    }

    public static RetiredPilot[] createGroupOfRetiredPilots(int n){
        RetiredPilot[] groupOfRetiredPilots = new RetiredPilot[n];
        for (int i = 0; i< n; i++){
            groupOfRetiredPilots[i] = RetiredPilot.retireAPilot(Pilot.createPilot());
        }
        return  groupOfRetiredPilots;
    }

    public static boolean findAPilotInAnArray(Pilot[] pilots, Pilot pilotToFind){
        boolean flag = false;
        for (Pilot pilot: pilots){
            if (pilot.getId().equals(pilotToFind.getId())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static Pilot updatePilotInfo(Pilot newInfo){
        return newInfo;
    }

    public static Pilot findPilotWithMostFlyingHours(Pilot[] pilots){
        double mostfliyingHours = 0;
        Pilot pilot = null;
        for (Pilot pilot1 : pilots){
            if (pilot1.getFlyingHours() > mostfliyingHours){
                mostfliyingHours = pilot1.getFlyingHours();;
                pilot = pilot1;
            }
        }
        return pilot;
    }
}
