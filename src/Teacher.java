import java.util.ArrayList;
import java.io.*;
import java.net.*;
//
public class Teacher extends Person
{
    private ArrayList<Course> coursesTaught = new ArrayList<Course>();
    private String localIP;

    public Teacher(String user, String pass, String localIP) {
        super(user, pass);
        this.localIP = localIP;
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

    public void setLocalIP() throws UnknownHostException {
        localIP = InetAddress.getLocalHost().toString();
    }

    public void setLocalIP(String newIP){
        localIP = newIP;
    }

    public String getLocalIP(){
        return localIP;
    }

}//Teacher
