package OOP_NEW_YEAR.First_Term.Day_13.Question_excercize;

import java.util.ArrayList;

public class Test {

    private Question[] questions;
    private int numCorrectAnswers;

    public Test(Question[] questions) {
        this.numCorrectAnswers = 0;
        this.questions = questions;
    }

    public void performTest(){
        int[] possible_numbers = new int[10];
        shuffle();
        for (int i = 0; i < 10; i++) {
            questions[i].askQuestion();
            if (questions[i].checkQuestion()){
                numCorrectAnswers += 1;
            }
        }
    }

    private void shuffle(){
        Question[] shuffledQuestions = new Question[this.questions.length];
        int minIndex = 0;
        int maxIndex = this.questions.length -1;
        int range = maxIndex - minIndex +1;
        ArrayList<Integer> passedIndexes = new ArrayList<>();
        for (int i = minIndex; i < maxIndex+1; i++){
            int randIndex = (int) (Math.random() * range) + minIndex;
            boolean inPassedIndexes = false;
            for (int index:passedIndexes){
                if (index == randIndex){
                    inPassedIndexes = true;
                    break;
                }
            }
            if (!inPassedIndexes){
                shuffledQuestions[randIndex] = questions[i];
            }
        }
        questions = shuffledQuestions;
    }

    public int getNumCorrectAnswers(){
        return numCorrectAnswers;
    }

}
