package OOP_NEW_YEAR.Tomov_Lectures.Shkolo;

import java.util.ArrayList;

public interface Teacher extends Student{
    public abstract void setAbsences(int absences);
    public abstract void setGrades(ArrayList<Integer> grades);
    public abstract void setNotes(ArrayList<String> notes);
    public abstract void setPraises(ArrayList<String> praises);
//    public abstract ArrayList<String> getStudent();
//    public abstract ArrayList<String> getPrincipals();
}
