import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSessionFrame extends JFrame{
    JButton backButton = new JButton("Back");

    public StudentSessionFrame(){
        this.setSize(420, 888);
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
            JFrame studentCourseFrame = new StudentCourseFrame();
            studentCourseFrame.setVisible(true);
            studentCourseFrame.setTitle("Course List");
            studentCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}