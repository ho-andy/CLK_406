import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    private ArrayList<Person> roster;

    private JLabel userLabel = new JLabel("Username");
    private JTextField userField = new JTextField(35);
    private JLabel passLabel = new JLabel("Password");
    private JTextField passField = new JTextField(35);
    private JButton loginButton = new JButton("Login");

    private JButton teacherButton = new JButton("Teacher");
    private JButton studentButton = new JButton("Student");

    public MainFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(userLabel);
        this.add(userField);
        this.add(passLabel);
        this.add(passField);
        this.add(loginButton);

        loginButton.addActionListener(new LoginListener());

        Database database = new Database();
        roster = database.getPersonDatabase();

        this.add(teacherButton);
        teacherButton.addActionListener(new TeacherListener());
        this.add(studentButton);
        studentButton.addActionListener(new StudentListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userField.getText().toLowerCase();
            String password = passField.getText();
            boolean badUser = true;

            for (Person aPerson : roster) {
                if (aPerson.getUserName().toLowerCase().trim().equals(username) && aPerson.getPassword().trim().equals(password)) {
                    if (aPerson instanceof Student) {
                        badUser = false;
                        JFrame studentFrame = new StudentFrame(aPerson);
                        studentFrame.setVisible(true);
                        studentFrame.setTitle("Student");
                        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        closePanel();
                    } else if (aPerson instanceof Teacher) {
                        badUser = false;
                        JFrame teacherFrame = new TeacherFrame(aPerson);
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

    class TeacherListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherFrame = new TeacherFrame();
            teacherFrame.setVisible(true);
            teacherFrame.setTitle("Teacher");
            teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
    class StudentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentFrame = new StudentFrame();
            studentFrame.setVisible(true);
            studentFrame.setTitle("Student");
            studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}