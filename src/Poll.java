
import java.util.ArrayList;

public class Poll
{
    private String pollName;
    private int numOfQs;
    private ArrayList<Question> poll = new ArrayList<Question>();

    public Poll(String name)
    {
        this.pollName = name;
    }

    public void addQuestion(Question q)
    {
        this.poll.add(q);
    }

    public void deleteQuestion(Question q){

    }

}
