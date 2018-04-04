import java.util.ArrayList;
//
public class Teacher extends Person
{
    private ArrayList<Course> coursesTaught = new ArrayList<Course>();

    public Teacher(String user, String pass) {
        super(user, pass);
    }//Teacher

    public boolean addCourse(Course newCourse){
        if(!coursesTaught.contains(newCourse)){
            return false;
        }else{
            coursesTaught.add(newCourse);
            return true;
        }
    }

    public boolean deleteCourse(Course courseToDelete){
        if(!coursesTaught.contains(courseToDelete)){
            return false;
        }else{
            coursesTaught.remove(courseToDelete);
            return true;
        }
    }

    public void createCourse(String code, String description){

    }

    public boolean addStudentToRoster(Student student){
        return true;
    }

    public boolean deleteStudentFromRoster(Student student){
        return true;
    }

}//Teacher
