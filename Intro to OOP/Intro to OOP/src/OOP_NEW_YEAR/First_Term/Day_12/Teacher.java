package OOP_NEW_YEAR.First_Term.Day_12;

public class Teacher extends Person{
    private String position;

    public Teacher(String name, String phone) {
        super(name, phone);
        this.position = "ASSISTANT";
    }

    public Teacher(String name, String phone, String position) {
        super(name, phone);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name=" + this.getName() + "\'" +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
