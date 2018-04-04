import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherAttendanceFrame extends JFrame{
    private JButton backButton = new JButton("Back");

    public TeacherAttendanceFrame(){
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
            JFrame teacherSessionFrame = new TeacherSessionFrame();
            teacherSessionFrame.setVisible(true);
            teacherSessionFrame.setTitle("Session");
            teacherSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
