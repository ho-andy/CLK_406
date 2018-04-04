import java.util.ArrayList;
import java.io.*;
import java.net.*;
import java.util.Scanner;
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

    public Socket createSession(Course course) throws IOException {
        int serverPort = course.getCode().hashCode();
        ServerSocket serverSocketPort = new ServerSocket(serverPort);
        Socket server = serverPort.accept();
        return server;
    }

    public void endSession(Socket server) throws IOException {
        server.close();
    }

    public void sendMessageThroughSession(Socket server, String message) throws IOException {
        PrintStream serverOutput = new PrintStream(server.getOutputStream());
        serverOutput.println(message);
    }

    public String receiveMessageThroughSession(Socket server) throws IOException {
        Scanner serverInput = new Scanner(server.getInputStream());
        return serverInput.nextLine();
    }

}//Teacher
