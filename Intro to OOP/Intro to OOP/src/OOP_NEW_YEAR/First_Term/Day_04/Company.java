package OOP_NEW_YEAR.First_Term.Day_04;

public class Company {
    private String name;
    private int employees;
    private String areaOfWork;

    public Company(String n, int e, String a){
        setName(n);
        setEmployees(e);
        setAreaOfWork(a);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getEmployees() {
        return employees;
    }

    public void setAreaOfWork(String areaOfWork) {
        this.areaOfWork = areaOfWork;
    }

    public String getAreaOfWork() {
        return areaOfWork;
    }
}
