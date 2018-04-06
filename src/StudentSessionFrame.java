import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSessionFrame extends JFrame{
    private JButton backButton = new JButton("Back");

    private MainFrame mainFrame;

    public StudentSessionFrame(MainFrame mainFrame){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());
        this.mainFrame = mainFrame;

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
            JFrame studentCourseFrame = new StudentCourseFrame(mainFrame);
            studentCourseFrame.setVisible(true);
            studentCourseFrame.setTitle("Course List");
            studentCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
