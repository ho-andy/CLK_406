import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton registerButton = new JButton("Register Course");
    private JButton courseButton = new JButton("Course List");
    private MainFrame mainFrame;

    public StudentFrame(MainFrame mainFrame){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());
        this.mainFrame = mainFrame;

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(registerButton);
        registerButton.addActionListener(new RegisterListener());

        this.add(courseButton);
        courseButton.addActionListener(new CourseListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame testerFrame = new MainFrame();
            testerFrame.setVisible(true);
            testerFrame.setTitle("iPoll");
            testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame registerFrame = new StudentRegisterFrame(mainFrame);
            registerFrame.setVisible(true);
            registerFrame.setTitle("Register Course");
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class CourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame courseFrame = new StudentCourseFrame(mainFrame);
            courseFrame.setVisible(true);
            courseFrame.setTitle("Course List");
            courseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
