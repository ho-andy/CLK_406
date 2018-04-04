import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
//
public class Course{
    private String code, description;
    private ArrayList<Student> studentRoster = new ArrayList<Student>();
    private Teacher teacherInCharge;
    private String serverIP;

    public Course(String code, String description, Teacher teacherInCharge, String serverIP){
        this.code = code;
        this.description = description;
        this.teacherInCharge = teacherInCharge;
        this.serverIP = serverIP;
    }//Course

    public String getCode(){
        return code;
    }//getCode

    public String getDescription(){
        return description;
    }//getDescription

    public Teacher getTeacherInCharge() {
        return teacherInCharge;
    }//getTeacherInCharge

    public void setCode(String newCode){
        code = newCode;
    }//setCode

    public void setDescription(String newDescription){
        description = newDescription;
    }//setDescription

    public void setTeacherInCharge(Teacher newTeacher){
        teacherInCharge = newTeacher;
    }//setTeacherInCharge

    public boolean addStudent(Student newStudent){
        if(!studentRoster.contains(newStudent)){
            return true;
        }else{
            return false;
        }//if
    }//addStudent

    public boolean deleteStudent(Student studentToDelete){
        if(studentRoster.contains(studentToDelete)){
            studentRoster.remove(studentToDelete);
            return true;
        }else{
            return false;
        }//if
    }//deleteStudent

    public boolean equals(Course course){
        if(course == null){
            return false;
        }
        if(course.getCode() == this.getCode() && course.getDescription() == this.getDescription()){
            return false;
        }
        return true;
    }

    public void setLocalIP() throws UnknownHostException {
        serverIP = InetAddress.getLocalHost().toString();
    }

    public void setLocalIP(String newIP){
        serverIP = newIP;
    }

    public String getLocalIP(){
        return serverIP;
    }

}//Course
