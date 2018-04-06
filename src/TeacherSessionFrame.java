import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherSessionFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton questionButton = new JButton("Ask Question");
    private JButton attendanceButton = new JButton("Attendance");
    private JButton resultsButton = new JButton("Results");

    public TeacherSessionFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());


        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(questionButton);
        questionButton.addActionListener(new QuestionListener());

        this.add(attendanceButton);
        attendanceButton.addActionListener(new AttendanceListener());

        this.add(resultsButton);
        resultsButton.addActionListener(new ResultsListener());
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
            /*
                THEORETICAL CODE
                Socket session = TeacherCourseFrame.server;
                teacher.endSession(session);
             */
        }
    }

    class QuestionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherQuestionFrame = new TeacherQuestionFrame();
            teacherQuestionFrame.setVisible(true);
            teacherQuestionFrame.setTitle("Questions");
            teacherQuestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
            /*
                THEORETICAL CODE
                Socket session = TeacherCourseFrame.server;
                teacher.sendMessageThroughSession(session, question);
                teacher.sendMessageThroughSession(session, choiceA);
                teacher.sendMessageThroughSession(session, choiceB);
                teacher.sendMessageThroughSession(session, choiceC);
                teacher.sendMessageThroughSession(session, choiceD);
             */
        }
    }

    class AttendanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherAttendanceFrame = new TeacherAttendanceFrame();
            teacherAttendanceFrame.setVisible(true);
            teacherAttendanceFrame.setTitle("Attendance");
            teacherAttendanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class ResultsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherResultsFrame = new TeacherResultsFrame();
            teacherResultsFrame.setVisible(true);
            teacherResultsFrame.setTitle("Results");
            teacherResultsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();

            /*
                THEORETICAL CODE
                Socket session = TeacherCourseFrame.server;
                teacher.sendMessageThroughSession(session, result);
             */
        }
    }
}
