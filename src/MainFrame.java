import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{

    private ArrayList<Person> roster;
    private ArrayList<Teacher> teacherRoster;
    private ArrayList<Student> studentRoster;

    private JLabel userLabel = new JLabel("Username");
    private JTextField userField = new JTextField(35);
    private JLabel passLabel = new JLabel("Password");
    private JTextField passField = new JPasswordField(35);
    private JButton loginButton = new JButton("Login");

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
        teacherRoster = database.getTeacherDatabase();
        studentRoster = database.getStudentDatabase();
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
            Person p = new Person(username,password);
            boolean badUser = true;

                if (p.getUserName().toLowerCase().trim().equals(username) && p.getPassword().trim().equals(password)) {
                    for(int i = 0; i<teacherRoster.size();i++)
                    {
                        if(p.getUserName().equals(teacherRoster.get(i).getUserName().toLowerCase()))
                        {
                            badUser = false;
                            JFrame teacherFrame = new TeacherFrame(teacherRoster.get(i));
                            teacherFrame.setVisible(true);
                            teacherFrame.setTitle("Teacher");
                            teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            closePanel();
                        }
                    }
                    for(int i = 0;i<studentRoster.size();i++)
                    {
                        if(p.getUserName().equals(studentRoster.get(i).getUserName().toLowerCase()))
                        {
                            badUser = false;
                            JFrame studentFrame = new StudentFrame(p);
                            studentFrame.setVisible(true);
                            studentFrame.setTitle("Student");
                            studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            closePanel();
                        }
                    }

                } else
                    JOptionPane.showMessageDialog(null, "User Does Not Exist", "Error", JOptionPane.INFORMATION_MESSAGE);

            if(badUser) {
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}