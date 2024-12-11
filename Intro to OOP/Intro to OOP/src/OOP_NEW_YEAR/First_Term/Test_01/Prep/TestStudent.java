package OOP_NEW_YEAR.Test_01.Prep;

import java.util.Scanner;

public class TestStudent {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Student[] groupofStudents = createGroupOfStudents(5);
        Faculty[] groupOfFaculty = createGroupOfFaculty(5);


        Student dataCheck = Student.addStudent(scanner);
        System.out.printf("Is the given student in the group: " + checkIfStudentExists(dataCheck, groupofStudents));

        groupofStudents[3] = updateStudentInfo(dataCheck);

        System.out.println("The best student in the group is: " + findMaxGpa(groupofStudents).toString());

    }

    public static Student[] createGroupOfStudents(int n){
        Student[] groupOfStudents = new Student[n];
        for (int i = 0; i< n; i++){
            groupOfStudents[i] = Student.addStudent(scanner);
        }
        return  groupOfStudents;
    }

    public static Faculty[] createGroupOfFaculty(int n){
        Faculty[] groupOfFaculty = new Faculty[n];
        for (int i = 0; i< n; i++){
            groupOfFaculty[i] = Faculty.graduateStudent(scanner, Student.addStudent(scanner));
        }
        return  groupOfFaculty;
    }

    public static boolean checkIfStudentExists(Student student, Student[] group){
        boolean check = false;
        for (Student st : group) {
            if (!check) {
                if (st.getFacNum().equals(student.getFacNum())) {
                    check = true;
                }
            }
        }
        return check;
    }

    public static Student updateStudentInfo(Student newStudentInfo){
        return  newStudentInfo;
    }

    public static Student findMaxGpa(Student[] group){
        double maxGpa = group[0].getGpa();
        Student bestStudent = group[0];
        for (int i = 1; i < group.length; i++) {
            if (group[i].getGpa() > maxGpa){
                maxGpa = group[i].getGpa();
                bestStudent = group[i];
            }
        }
        return bestStudent;
    }
}
