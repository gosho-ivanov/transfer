package OOP_NEW_YEAR.First_Term.Day_13.Question_excercize;

import java.util.Scanner;

public class OpenQuestion extends Question{
    private static Scanner scanner = new Scanner(System.in);
    private String questionAnswer;
    private String studentAnswer;

    public OpenQuestion(String question, String questionAnswer) {
        super(question);
        this.questionAnswer = questionAnswer;
        this.studentAnswer = null;
    }

    @Override
    public void askQuestion() {
        System.out.println(this.getQuestion());
        studentAnswer = scanner.nextLine();
    }

    @Override
    public boolean checkQuestion() {
        return scanner.nextBoolean();
    }
}
