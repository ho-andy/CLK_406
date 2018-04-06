import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Person> personDatabase = new ArrayList<>();
    private ArrayList<Course> courseDatabase = new ArrayList<>();

    public Database(){
        openPersonDatabase();
        openCourseDatabase();
    }

    private void openCourseDatabase() {

    }

    public void openPersonDatabase(){
        String fieldDelimiter = "#";
        String fileName = "roster.txt";
        String currentLine;

        String[] person;
        Person newPerson;

        Scanner scanner;

        try{
            scanner = new Scanner(new File(fileName));

            while(scanner.hasNext()){
                currentLine = scanner.nextLine();
                person = currentLine.split(fieldDelimiter);
                newPerson = new Person(person[0], person[1], person[2].charAt(0));
                personDatabase.add(newPerson);
            }
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error in reading file", "Error", JOptionPane.INFORMATION_MESSAGE);
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