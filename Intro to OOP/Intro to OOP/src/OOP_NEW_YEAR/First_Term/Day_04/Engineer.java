package OOP_NEW_YEAR.First_Term.Day_04;

public class Engineer extends Person{
    private String typeEngineering;
    private double salary;
    private Company company;

    public Engineer(String name, String egn, String typeEngineering, double salary, Company company){
        super(name, egn);
        setTypeEngineering(typeEngineering);
        setSalary(salary);
        setCompany(company);
    }

    public void setTypeEngineering(String typeEngineering) {
        this.typeEngineering = typeEngineering;
    }

    public String getTypeEngineering() {
        return typeEngineering;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }
}
