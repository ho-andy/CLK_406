import java.util.ArrayList;

public class Question
{
    private String question;
    private ArrayList<Answer> answerList = new ArrayList<>();

    public Question(String question, String correctAnswer){
        this.question = question;
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
        for(int i = 0; i < answerList.size(); i++){
            if(answerList.get(i).isCorrect()){
                return answerList.get(i).getAnswer();
            }
        }
        return "";
    }
}
