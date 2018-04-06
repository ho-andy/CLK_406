import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
//
public class Course{
    private String code, description;
    private ArrayList<Student> studentRoster = new ArrayList<Student>();
    private Teacher teacherInCharge;
    private String serverIP;
    private ArrayList<Integer> courseWeights;

    public Course(String code, String description, Teacher teacherInCharge, String serverIP, ArrayList<Integer> courseWeights){
        this.code = code;
        this.description = description;
        this.teacherInCharge = teacherInCharge;
        this.serverIP = serverIP;
        this.courseWeights = courseWeights;
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

    public ArrayList<Integer> getCourseWeights(){
        return courseWeights;
    }//getCourseWeights

    public void setCode(String newCode){
        code = newCode;
    }//setCode

    public void setDescription(String newDescription){
        description = newDescription;
    }//setDescription

    public void setTeacherInCharge(Teacher newTeacher){
        teacherInCharge = newTeacher;
    }//setTeacherInCharge

    public void setCourseWeights(ArrayList<Integer> newCourseWeights){
        courseWeights = newCourseWeights;
    }//setCourseWeights

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
