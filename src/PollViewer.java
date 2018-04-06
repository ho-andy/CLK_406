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
        try{
            Scanner scanner = new Scanner(new File("roster.txt")).useDelimiter("\n");
        } catch (FileNotFoundException e){
            System.err.println("File not found");
            System.exit(0);
        }

        ArrayList<Person> database = new ArrayList<>();
        //while(scanner.hasNextLine()){

        //}


    }
}
