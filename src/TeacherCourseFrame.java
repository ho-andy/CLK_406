import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeacherCourseFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton rosterButton = new JButton("Class Roster");
    private JButton sessionButton = new JButton("Start Session");

    private Person loggedIn;

    public TeacherCourseFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(rosterButton);
        rosterButton.addActionListener(new RosterListener());

        this.add(sessionButton);
        sessionButton.addActionListener(new SessionListener());
    }

    public TeacherCourseFrame(Person person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(rosterButton);
        rosterButton.addActionListener(new RosterListener());

        this.add(sessionButton);
        sessionButton.addActionListener(new SessionListener());

        loggedIn = person;
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherFrame = new TeacherFrame(loggedIn);
            teacherFrame.setVisible(true);
            teacherFrame.setTitle("Teacher");
            teacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class RosterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherRosterFrame = new TeacherRosterFrame(loggedIn);
            teacherRosterFrame.setVisible(true);
            teacherRosterFrame.setTitle("Roster");
            teacherRosterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class SessionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherSessionFrame = new TeacherSessionFrame(loggedIn);
            teacherSessionFrame.setVisible(true);
            teacherSessionFrame.setTitle("Session");
            teacherSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
            /*
                THEORETICAL CODE
                try{
                    static Socket server = teacher.startSession(course);
                }catch (IOException){
                    JOptionPane.showMessageDialog(frame, "Could not connect to server", "IOException: Could not connect.", JOptionPane.ERROR_MESSAGE);
                }
             */
        }
    }
}
