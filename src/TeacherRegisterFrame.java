import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherRegisterFrame extends JFrame{
    JButton backButton = new JButton("Back");

    public TeacherRegisterFrame(){
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
            JFrame teacherFrame = new TeacherFrame();
            teacherFrame.setVisible(true);
            teacherFrame.setTitle("Teacher");
            teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
