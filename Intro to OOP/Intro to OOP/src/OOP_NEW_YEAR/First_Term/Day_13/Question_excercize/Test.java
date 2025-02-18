package OOP_NEW_YEAR.First_Term.Day_13.Question_excercize;

public class Test {

    private Question[] questions;
    private int numCorrectAnswers;

    public Test(Question[] questions) {
        this.numCorrectAnswers = 0;
        this.questions = questions;
    }

    public void performTest(){
        int[] possible_numbers = new int[10];
        for (int i = 0; i < 10; i++) {

            questions[i].askQuestion();
            if (questions[i].checkQuestion()==true){
                numCorrectAnswers += 1;
            }
        }
    }

    public int getNumCorrectAnswers(){
        return numCorrectAnswers;
    }

}
