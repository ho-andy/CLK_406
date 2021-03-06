
import java.util.ArrayList;

public class Poll
{
    private String pollName;
    private ArrayList<Question> poll = new ArrayList<Question>();

    public Poll(String name)
    {
        this.pollName = name;
    }

    public void addQuestion(Question q)
    {
        this.poll.add(q);
    }
    public void deleteQuestion(int n)
    {
        this.poll.remove(n+1);
    }
    public String getPollName()
    {
        return pollName;
    }
    public Question getQuestion(int i)
    {
        return this.poll.get(i-1);
    }
}
