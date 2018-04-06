import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.net.Socket;
import java.util.Scanner;

public class Student extends Person{
    private ArrayList<Course> coursesEnrolled = new ArrayList<Course>();
    private ArrayList<String> currentResults = new ArrayList<String>();
    private boolean inAttendance = false;

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

    public Socket joinSession(Course course) throws IOException {
        String serverIP = course.getLocalIP();
        int serverPort = course.getCode().hashCode();
        Socket server = new Socket(serverIP, serverPort);
        return server;
    }

    public void sendMessageToSession(Socket server, String message) throws IOException {
        PrintStream serverInput = new PrintStream(server.getOutputStream());
        serverInput.println(message);
    }

    public String receiveMessageFromSession(Socket server) throws IOException {
        Scanner serverOutput = new Scanner(server.getInputStream());
        return serverOutput.nextLine();
    }

    public void leaveSession(Socket server) throws IOException {
        server.close();
    }


}//Student
