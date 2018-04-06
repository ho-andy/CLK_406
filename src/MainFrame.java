import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainFrame extends JFrame{
    private ArrayList<Person> database = new ArrayList<>();
    private JLabel userLabel = new JLabel("Username");
    private JTextField userField = new JTextField(35);
    private JLabel passLabel = new JLabel("Password");
    private JTextField passField = new JTextField(35);
    private JButton loginButton = new JButton("Login");

    public MainFrame(){
        openDatabase();

        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(userLabel);
        this.add(userField);
        this.add(passLabel);
        this.add(passField);
        this.add(loginButton);

        loginButton.addActionListener(new LoginListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userField.getText();
            String password = passField.getText();
            boolean badUser = true;

            for (Person aPerson : database) {
                if (aPerson.getUserName().equals(username) && aPerson.getPassword().equals(password)) {
                    if (aPerson.getPersonType() == 's') {
                        badUser = false;

                        JFrame studentFrame = new StudentFrame();
                        studentFrame.setVisible(true);
                        studentFrame.setTitle("Student");
                        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        closePanel();
                    } else if (aPerson.getPersonType() == 't') {
                        badUser = false;

                        JFrame teacherFrame = new TeacherFrame();
                        teacherFrame.setVisible(true);
                        teacherFrame.setTitle("Teacher");
                        teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        closePanel();
                    } else {
                        JOptionPane.showMessageDialog(null, "User Does Not Exist", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            if(badUser) {
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void openDatabase(){
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
                database.add(newPerson);
            }

        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error in reading file", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}