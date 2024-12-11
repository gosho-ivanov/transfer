package OOP_NEW_YEAR.Day_04;

public class Student extends Person{
    private String fNum;
    private double gpa;

    public Student(String name, String egn, String f) {
        super(name, egn);
        this.setfNum(f);

    }

    public String getfNum() {
        return fNum;
    }

    public void setfNum(String fNum) {
        this.fNum = fNum;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student[] checkGPA(Student[] sts){
        Student[] passingStudents = new Student[sts.length];
        int index = 0;
        for (Student st : sts){
            if (st.gpa > this.gpa){
                passingStudents[index] = st;
            }
        }
        return passingStudents;
    }
}
