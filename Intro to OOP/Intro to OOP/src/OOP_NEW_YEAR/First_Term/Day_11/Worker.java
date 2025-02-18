package OOP_NEW_YEAR.First_Term.Day_11;

public class Worker {
    private String FullName;
    private int age;
    private double salary;
    private String position;
    private String department;

    public Worker(int age, String department, String fullName, double salary) {
        this.age = age;
        this.department = department;
        FullName = fullName;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
