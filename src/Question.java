import java.util.ArrayList;

public class Question
{
    private String question,correct;
    private ArrayList<Answer> answerList = new ArrayList<>();

    public Question(String question, String correctAnswer){
        this.question = question;
        this.correct = correctAnswer;
        answerList.add(new Answer(correctAnswer, true));
    }

    public void addAnswer(String answer, boolean isCorrect){
        if(answerList.size() > 5){
            System.out.println("Answer List Full");
        } else{
            answerList.add(new Answer(answer, false));
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer(){
        return correct;
    }

    public String getAnswer(int i)
    {
        if(i <= 5)
            return this.answerList.get(i-1).getAnswer();
        return null;
    }
}
