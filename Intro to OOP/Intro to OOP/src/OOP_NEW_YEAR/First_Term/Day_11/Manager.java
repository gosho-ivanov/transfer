package OOP_NEW_YEAR.First_Term.Day_11;

public class Manager extends Worker{
    private int managedEmployees;


    public Manager(int age, String department, String fullName, double salary, int managedEmployees) {
        super(age, department, fullName, salary);
        this.managedEmployees = managedEmployees;
    }

    public int getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(int managedEmployees) {
        this.managedEmployees = managedEmployees;
    }
}
