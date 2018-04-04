import java.util.ArrayList;

public class Student extends Person{
    private ArrayList<Course> coursesEnrolled = new ArrayList<Course>();
    private ArrayList<String> currentResults = new ArrayList<String>();

    public Student(String user, String pass){
        super(user, pass);
    }//Student

    public boolean joinCourse(){
        return true;
    }

    public boolean addCourse(Course course) {
        if (coursesEnrolled.contains(course)) {
            return false;
        }else{
            coursesEnrolled.add(course);
            return true;
        }
    }

    public boolean removeCourse(Course course) {
        if (coursesEnrolled.contains(course)) {
            coursesEnrolled.remove(course);
            return true;
        }else{
            return false;
        }
    }


}//Student
