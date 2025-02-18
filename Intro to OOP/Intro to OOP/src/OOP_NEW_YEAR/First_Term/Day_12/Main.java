package OOP_NEW_YEAR.First_Term.Day_12;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Student[] students = generateArrOfStudents(2);
        Teacher[] teachers = generateArrOfTeachers(2);

        showInfoOfStudents(students);
        showInfoOFTeachers(teachers);
    }
    
    public static Student[] generateArrOfStudents(int n){
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of the student: ");
            String name = scanner.next();
            System.out.print("Enter his phone number: ");
            String phone = scanner.next();
            System.out.print("Enter his faculty number: ");
            int fakNum = scanner.nextInt();

            students[i] = new Student(name, phone, fakNum);
        }
        return students;
    }

    public static Teacher[] generateArrOfTeachers(int n){
        Teacher[] teachers = new Teacher[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of the teacher: ");
            String name = scanner.nextLine();
            System.out.print("Enter his phone number: ");
            String phone = scanner.next();
            System.out.print("Enter his position: ");
            String position = scanner.nextLine();
            teachers[i] = new Teacher(name, phone, position);
        }
        return teachers;
    }

    public static void showInfoOfStudents(Student[] students){
        for (Student st: students){
            System.out.println(st.toString());
        }
    }

    public static void showInfoOFTeachers(Teacher[] teachers){
        for (Teacher tc: teachers){
            System.out.println(tc.toString());
        }
    }
}
