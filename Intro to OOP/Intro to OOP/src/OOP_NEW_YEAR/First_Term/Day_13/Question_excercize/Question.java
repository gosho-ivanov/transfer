package OOP_NEW_YEAR.First_Term.Day_13.Question_excercize;

import java.util.Scanner;

public abstract class Question {
    private String question;


    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void askQuestion(){}

    public abstract boolean checkQuestion();
}
