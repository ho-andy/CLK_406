import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSessionFrame extends JFrame{
    private JButton backButton = new JButton("Back");

    private Person loggedIn;

    public StudentSessionFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());
    }

    public StudentSessionFrame(Person person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        loggedIn = person;
        System.out.println(loggedIn);
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentCourseFrame = new StudentCourseFrame(loggedIn);
            studentCourseFrame.setVisible(true);
            studentCourseFrame.setTitle("Course List");
            studentCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
