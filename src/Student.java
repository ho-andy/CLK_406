import java.util.ArrayList;

public class Student extends Person{
    private ArrayList<Course> coursesEnrolled = new ArrayList<Course>();
    private ArrayList<String> currentResults = new ArrayList<String>();

    public Student(String user, String pass){
        super(user, pass);
    }//Student


}//Student
