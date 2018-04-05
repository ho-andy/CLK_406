import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton registerButton = new JButton("Register Course");
    private JButton courseButton = new JButton("Course List");

    public TeacherFrame(){
        this.setSize(420, 888);
        this.setLayout(new FlowLayout());


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
            JFrame teacherRegisterFrame = new TeacherRegisterFrame();
            teacherRegisterFrame.setVisible(true);
            teacherRegisterFrame.setTitle("Register Course");
            teacherRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class CourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherCourseFrame = new TeacherCourseFrame();
            teacherCourseFrame.setVisible(true);
            teacherCourseFrame.setTitle("Course List");
            teacherCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
