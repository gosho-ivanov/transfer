package OOP_NEW_YEAR.First_Term.Day_13.Question_excercize;

import java.util.Scanner;

public class IntegerQuestion extends Question{
    private static Scanner scanner = new Scanner(System.in);
    private int questionAnswer;
    private int studentAnswer;

    public IntegerQuestion(String question, int questionAnswer) {
        super(question);
        this.questionAnswer = questionAnswer;
        this.studentAnswer = 0;
    }

    @Override
    public void askQuestion() {
        System.out.println(this.getQuestion());
        studentAnswer = scanner.nextInt();
    }

    @Override
    public boolean checkQuestion() {
        if (studentAnswer == questionAnswer) {
            return true;
        } else {
            return false;
        }
    }
}
