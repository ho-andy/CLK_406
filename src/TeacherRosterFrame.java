import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherRosterFrame extends JFrame{
    private JButton backButton = new JButton("Back");

    public TeacherRosterFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());


        this.add(backButton);
        backButton.addActionListener(new BackListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
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
