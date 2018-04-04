import java.util.ArrayList;


public class Teacher extends Person
{
    private ArrayList<Course> coursesEnrolled = new ArrayList<Course>();

    public Teacher(String user, String pass)
    {
        super(user, pass);
    }
}
