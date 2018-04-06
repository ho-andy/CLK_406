import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Person> personDatabase = new ArrayList<>();
    private ArrayList<Course> courseDatabase = new ArrayList<>();
    private Poll poll;

    public Database(){
        openPersonDatabase();
        openCourseDatabase();
    }

    private void openCourseDatabase() {
        String coursesFileName = "courses.txt";
        String fieldDelimiter = "#";
        char lineDelimiter = '?';
        String currentLine;
        String[] course, person;

        ArrayList<String> currentFields = new ArrayList<>();
        Scanner scanner;
        ArrayList<Integer> courseWeights = new ArrayList<>();
        ArrayList<Student> currentRoster = new ArrayList<>();

        Student newStudent = null;
        Teacher teacherInCharge = null;
        Course newCourse;

        try{
            scanner = new Scanner(new File(coursesFileName));
            while(scanner.hasNext()){
                currentLine = scanner.nextLine();
                course = currentLine.split(fieldDelimiter);

                //PARSING COURSE INFORMATION, FIRST LINE OF EACH COURSE INFO
                for(int i = 0; i < 3; i ++){
                    currentFields.add(course[i]);
                }//for

                for(int i = 3; i < course.length; i++){
                    courseWeights.add(Integer.parseInt(course[i]));
                }//for

                for(int i = 0; i < personDatabase.size(); i ++){
                    if(personDatabase.get(i).getUserName().toUpperCase() == course[2].toUpperCase()){
                        teacherInCharge = (Teacher)personDatabase.get(i);
                    }
                }

                newCourse = new Course(course[0], teacherInCharge, course[1], courseWeights);

                //PARSING STUDENT ROSTER
                while(currentLine.charAt(0) != lineDelimiter){
                    currentLine = scanner.nextLine();
                    person = currentLine.split(fieldDelimiter);
                    newStudent = new Student(person[0], person[1]);
                    currentRoster.add(newStudent);
                }//while

                newCourse.setStudentRoster(currentRoster);
                courseDatabase.add(newCourse);

            }//while


        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error in reading courses.txt file", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public void openPersonDatabase(){
        String fieldDelimiter = "#";
        String rosterFileName = "roster.txt";
        String currentLine;

        String[] person;
        Person newPerson;

        Scanner scanner;

        try{
            scanner = new Scanner(new File(rosterFileName));

            while(scanner.hasNext()){
                currentLine = scanner.nextLine();
                person = currentLine.split(fieldDelimiter);
                newPerson = new Person(person[0], person[1], person[2].charAt(0));
                personDatabase.add(newPerson);
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error in reading roster.txt file", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }

    public ArrayList<Person> getPersonDatabase() {
        return personDatabase;
    }

    public void setPersonDatabase(ArrayList<Person> personDatabase) {
        this.personDatabase = personDatabase;
    }

    public ArrayList<Course> getCourseDatabase() {
        return courseDatabase;
    }

    public void setCourseDatabase(ArrayList<Course> courseDatabase) {
        this.courseDatabase = courseDatabase;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}