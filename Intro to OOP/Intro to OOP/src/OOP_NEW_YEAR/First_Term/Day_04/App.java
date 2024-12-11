package OOP_NEW_YEAR.First_Term.Day_04;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Person p1 = new Person();
        p1.setName("Pesho");
        Person p2 = new Person("Desi", "8907186733");
        p1.sayMyName();
        Person.sayHi();
        System.out.println(p2.getEgn());
        System.out.println();

        Student st1 = new Student("Ivan", "0751136840", "21633");
        st1.sayMyName();
        Student.sayHi();
        System.out.println(st1.getfNum());
        System.out.println();

        Course c1 = new Course("OOP LAB");
        c1.setCourseName("OOP LECTURES");
        System.out.println(c1.getCourseName());
        System.out.println();
        Course c2 = new Course("OOP LABS");
        Course c3 = new Course("DataBases LABS");

        Course[] courses = {c1, c2, c3};

        Teacher t1 = new Teacher("Dimitar", "7302074537", courses);
        System.out.println(t1.getCourses()[2].getCourseName());
        t1.setName("Petar");
        t1.sayMyName();
        System.out.println();

        Company com1 = new Company("AbraCadabraOOD", 20_000, "Magic");
        System.out.println(com1.getEmployees());
        System.out.println();

        Engineer e1 = new Engineer("Ivan", "9801234567", "Electrivcal", 2_500.00, com1);
        System.out.println(e1.getCompany().getName());
    }
}
