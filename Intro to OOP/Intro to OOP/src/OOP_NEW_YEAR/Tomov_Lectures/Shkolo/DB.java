package OOP_NEW_YEAR.Tomov_Lectures.Shkolo;

import java.util.ArrayList;

public class DB implements Student, Teacher, Principal{
    private ArrayList<String> subjects;
    private ArrayList<Integer> grades;
    private int absences;
    private ArrayList<String> praises;
    private ArrayList<String> notes;
    private ArrayList<String> teachers;
    private ArrayList<String> students;
    private ArrayList<String> principals;

    public DB() {
    }

    public DB(int absences, ArrayList<Integer> grades, ArrayList<String> notes, ArrayList<String> praises, ArrayList<String> subjects, ArrayList<String> teachers, ArrayList<String> students, ArrayList<String> directors) {
        this.absences = absences;
        this.grades = grades;
        this.notes = notes;
        this.praises = praises;
        this.subjects = subjects;
        this.teachers = teachers;
        this.students = students;
        this.principals = directors;
    }

    @Override
    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public void setTeachers(ArrayList<String> teachers) {
        this.teachers = teachers;
    }

    @Override
    public void setAbsences(int absences) {
        this.absences = absences;
    }

    @Override
    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    @Override
    public void setPraises(ArrayList<String> praises) {
        this.praises = praises;
    }

    @Override
    public ArrayList<Integer> getGrades() {
        return this.grades;
    }

    @Override
    public ArrayList<String> getSubjects() {
        return this.subjects;
    }

    @Override
    public ArrayList<String> getNotes() {
        return this.notes;
    }

    @Override
    public ArrayList<String> getPraises() {
        return this.praises;
    }

    @Override
    public int getAbsences() {
        return this.absences;
    }

    @Override
    public ArrayList<String> getTeachers() {
        return this.teachers;
    }

    @Override
    public ArrayList<String> getPrincipals() {
        return this.principals;
    }

    @Override
    public ArrayList<String> getStudent() {
        return this.students;
    }

    @Override
    public void setPrincipals(ArrayList<String> principals) {
        this.principals = principals;
    }

    @Override
    public void setStudents(ArrayList<String> students) {
        this.students = students;
    }
}
