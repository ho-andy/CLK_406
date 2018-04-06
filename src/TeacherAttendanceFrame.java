import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherAttendanceFrame extends JFrame{
    private JButton backButton = new JButton("Back");

    private MainFrame mainFrame;

    public TeacherAttendanceFrame(MainFrame mainFrame){
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
            JFrame teacherSessionFrame = new TeacherSessionFrame(mainFrame);
            teacherSessionFrame.setVisible(true);
            teacherSessionFrame.setTitle("Session");
            teacherSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
