import java.util.ArrayList;

public class Student extends Person{
    private String name, lastName;
    private ArrayList<Course> coursesEnrolled = new ArrayList<Course>();
    private ArrayList<String> currentResults = new ArrayList<String>();

    public Student(String user, String pass){
        super(user, pass);
    }//Student

    public Student()

    public boolean joinCourse(){
        return true;
    }

    public void editStudent(String name, String lastName) {
        if()
    }


}//Student
