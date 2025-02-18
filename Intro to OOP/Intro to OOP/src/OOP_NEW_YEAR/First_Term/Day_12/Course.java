package OOP_NEW_YEAR.First_Term.Day_12;

public class Course {
    private String name;
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
