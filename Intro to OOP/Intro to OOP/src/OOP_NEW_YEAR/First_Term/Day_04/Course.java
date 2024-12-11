package OOP_NEW_YEAR.First_Term.Day_04;

public class Course {
    private String courseName;

    public Course(String n){
        setCourseName(n);
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
