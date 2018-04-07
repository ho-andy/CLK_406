import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton registerButton = new JButton("Register Course");
    private JButton courseButton = new JButton("Select Course");
    private JComboBox courseBox = new JComboBox();


    public TeacherFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        addCourses();

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(registerButton);
        registerButton.addActionListener(new RegisterListener());

        this.add(courseBox);

        this.add(courseButton);
        courseButton.addActionListener(new CourseListener());

    }

    public TeacherFrame(Teacher person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        Currents.TEACHER = person;

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(registerButton);
        registerButton.addActionListener(new RegisterListener());

        this.add(courseBox);

        this.add(courseButton);
        courseButton.addActionListener(new CourseListener());
        addCourses();


    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    public void addCourses()
    {

        for(int i = 0; i < Currents.TEACHER.getCoursesTaught().size();i++)
        {
            courseBox.addItem(Currents.TEACHER.getCoursesTaught().get(i).getCode());
        }
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
            for(int i = 0; i < Currents.TEACHER.getCoursesTaught().size();i++)
            {
                if(courseBox.getSelectedItem().equals(Currents.TEACHER.getCoursesTaught().get(i).getCode()))
                {
                    Currents.COURSE = Currents.TEACHER.getCoursesTaught().get(i);
                }
            }
            JFrame teacherCourseFrame = new TeacherCourseFrame();
            teacherCourseFrame.setVisible(true);
            teacherCourseFrame.setTitle("Course List");
            teacherCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
