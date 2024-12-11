package OOP_NEW_YEAR.Day_04;

public class Teacher extends Person{
    private Course[] courses;

    public Teacher(String Name, String egn, Course[] courses){
        super(Name, egn);
        setCourses(courses);
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public Course[] getCourses() {
        return this.courses;
    }
}
