package OOP_NEW_YEAR.Tomov_Lectures.Shkolo;

import java.util.ArrayList;

public interface Principal extends Teacher{
    public abstract void setSubjects(ArrayList<String> subjects);
    public abstract void setTeachers(ArrayList<String> teachers);
    public abstract void setStudents(ArrayList<String> students);
    public abstract void setPrincipals(ArrayList<String> principals);
}
