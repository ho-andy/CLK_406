
import java.util.ArrayList;
//
public class Question
{
    private ArrayList<String> answers = new ArrayList<String>();
    private String question;
    private int correctAnswer;

    public Question(String question, int correctAnswer){
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public void addAnswer(){

    }

    public void deleteAnswer(){

    }

    public boolean checkAnswer(){
        return true;
    }
}
