import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentCourseFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton sessionButton = new JButton("Join Session");

    public StudentCourseFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(sessionButton);
        sessionButton.addActionListener(new SessionListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentFrame = new StudentFrame();
            studentFrame.setVisible(true);
            studentFrame.setTitle("Student");
            studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class SessionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentSessionFrame = new StudentSessionFrame();
            studentSessionFrame.setVisible(true);
            studentSessionFrame.setTitle("Session");
            studentSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
