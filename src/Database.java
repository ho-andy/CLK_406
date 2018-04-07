import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Person> personDatabase = new ArrayList<>();

    public ArrayList<Student> getStudentDatabase() {
        return studentDatabase;
    }

    public void setStudentDatabase(ArrayList<Student> studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public ArrayList<Teacher> getTeacherDatabase() {
        return teacherDatabase;
    }

    public void setTeacherDatabase(ArrayList<Teacher> teacherDatabase) {
        this.teacherDatabase = teacherDatabase;
    }

    private ArrayList<Student> studentDatabase = new ArrayList<>();
    private ArrayList<Teacher> teacherDatabase = new ArrayList<>();
    private ArrayList<Course> courseDatabase = new ArrayList<>();

    public Database(){
        openPersonDatabase();
        openCourseDatabase();

        for(int i = 0; i < personDatabase.size(); i ++){
            if(personDatabase.get(i).getPersonType() == 't'){
                Teacher temporary = new Teacher(personDatabase.get(i).getUserName(), personDatabase.get(i).getPassword());

                for(int j = 0; j < courseDatabase.size(); j ++){
                    if(courseDatabase.get(j).getTeacherInCharge().getUserName().equals(temporary.getUserName())){
                        temporary.addCourse(courseDatabase.get(j));
                    }
                }
                personDatabase.set(i, temporary);
            }else if(personDatabase.get(i).getPersonType() == 's'){
                Student temporary = new Student(personDatabase.get(i).getUserName(), personDatabase.get(i).getPassword());

                for(int j = 0; j < courseDatabase.size(); j ++){
                    if(courseDatabase.get(j).getStudentRoster().contains(temporary)){
                        temporary.addCourse(courseDatabase.get(j));
                    }
                }

                personDatabase.set(i, temporary);
            }
        }

        for(int i = 0; i < personDatabase.size(); i++){
            if(personDatabase.get(i) instanceof Teacher){
                teacherDatabase.add((Teacher) personDatabase.get(i));
            } else if(personDatabase.get(i) instanceof Student){
                studentDatabase.add((Student) personDatabase.get(i));
            }
        }
    }

    private void openCourseDatabase() {
        String coursesFileName = "courses.txt";
        String fieldDelimiter = "#";
        String currentLine;
        String[] course, person;

        ArrayList<String> currentFields = new ArrayList<>();
        Scanner scanner;
        ArrayList<Integer> courseWeights = new ArrayList<>();
        ArrayList<Student> currentRoster = new ArrayList<>();

        Student newStudent = null;
        Teacher teacherInCharge = null;
        Course newCourse = null;

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
                    if((personDatabase.get(i).getUserName().toUpperCase()).equals(course[2].toUpperCase())){
                        teacherInCharge = new Teacher(personDatabase.get(i).getUserName(), personDatabase.get(i).getPassword());
                    }
                }

                newCourse = new Course(course[0], teacherInCharge, course[1], courseWeights);

                while(scanner.hasNextLine()){
                    String temp = scanner.nextLine().trim();
                    if(temp.matches("\\?")) {
                        break;
                    } else {
                        currentLine = temp;
                        person = currentLine.split(fieldDelimiter);
                        newStudent = new Student(person[0], person[1]);
                        currentRoster.add(newStudent);
                    }
                }
                newCourse.setStudentRoster(new ArrayList<>(currentRoster));

                currentFields.clear();
                courseWeights.clear();
                currentRoster.clear();

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
}