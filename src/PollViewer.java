import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PollViewer {

    public static void main(String[] args){
        openDatabase();
        JFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("iPoll");
        mainFrame.setVisible(true);
    }

    public static void openDatabase(){
        String fieldDelimiter = "#";
        String fileName = "roster.txt";
        String currentLine;

        ArrayList<Person> database = new ArrayList<>();
        String[] person;
        Person newPerson;

        Scanner scanner;

        try{
            scanner = new Scanner(new File(fileName));

            while(scanner.hasNext()){
                currentLine = scanner.nextLine();
                person = currentLine.split(fieldDelimiter);
                newPerson = new Person(person[0], person[1], person[2].charAt(0));
                database.add(newPerson);

                System.out.println(newPerson);
            }

        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error in reading file", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

    }
}
