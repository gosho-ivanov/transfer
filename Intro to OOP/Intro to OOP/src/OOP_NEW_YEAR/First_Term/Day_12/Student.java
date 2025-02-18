package OOP_NEW_YEAR.First_Term.Day_12;

public class Student extends Person{
    private int fakNum;
    private Course[] courses;
    private double[] grades;

    public Student(String name, String phone, int fakNum) {
        super(name, phone);
        this.courses = new Course[30];
        this.fakNum = fakNum;
        this.grades = new double[30];
    }
}
