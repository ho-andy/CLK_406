
public class Answer {
    private String answer;
    private boolean isCorrect;

    public Answer(String answer, boolean isCorrect){
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
