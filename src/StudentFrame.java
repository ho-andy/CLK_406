import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton registerButton = new JButton("Register Course");
    private JButton courseButton = new JButton("Select Course");
    private JComboBox courseBox = new JComboBox();


    private Student loggedIn;

    public StudentFrame(){
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

    public StudentFrame(Student person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        Currents.STUDENT = person;
        addCourses();

        this.add(backButton);
        backButton.addActionListener(new BackListener());
        this.add(registerButton);
        registerButton.addActionListener(new RegisterListener());


        this.add(courseBox);

        this.add(courseButton);
        courseButton.addActionListener(new CourseListener());


        System.out.println(loggedIn);
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    public void addCourses()
    {
        for(int i = 0; i < Currents.STUDENT.getCoursesEnrolled().size();i++)
        {
            courseBox.addItem(Currents.STUDENT.getCoursesEnrolled().get(i).getCode());
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
            JFrame registerFrame = new StudentRegisterFrame(loggedIn);
            registerFrame.setVisible(true);
            registerFrame.setTitle("Register Course");
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class CourseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            for(int i = 0; i < Currents.STUDENT.getCoursesEnrolled().size();i++)
            {
                if(courseBox.getSelectedItem().equals(Currents.STUDENT.getCoursesEnrolled().get(i).getCode()))
                {
                    Currents.SCOURSE = Currents.STUDENT.getCoursesEnrolled().get(i);
                }
            }

            JFrame courseFrame = new StudentCourseFrame();
            courseFrame.setVisible(true);
            courseFrame.setTitle("Course List");
            courseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
