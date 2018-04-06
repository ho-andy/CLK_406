import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherSessionFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JButton questionButton = new JButton("Ask Question");
    private JButton attendanceButton = new JButton("Attendance");
    private JButton resultsButton = new JButton("Results");
    private JButton testButton = new JButton("test");

    private Person loggedIn;
    private Poll poll = new Poll("Poll");

    public TeacherSessionFrame(Poll poll){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.poll = poll;
        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(questionButton);
        questionButton.addActionListener(new QuestionListener());

        this.add(attendanceButton);
        attendanceButton.addActionListener(new AttendanceListener());

        this.add(resultsButton);
        resultsButton.addActionListener(new ResultsListener());

        this.add(testButton);
        testButton.addActionListener(new TestListener());
    }

    public TeacherSessionFrame(Person person){
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
        this.add(testButton);
        testButton.addActionListener(new TestListener());

        loggedIn = person;
    }

    public TeacherSessionFrame(Person person, Poll poll){
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

        this.add(testButton);
        testButton.addActionListener(new TestListener());

        this.loggedIn = person;
        this.poll = poll;
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherCourseFrame = new TeacherCourseFrame(loggedIn);
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
            JFrame teacherQuestionFrame = new TeacherQuestionFrame(loggedIn, poll);
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
            JFrame teacherAttendanceFrame = new TeacherAttendanceFrame(loggedIn);
            teacherAttendanceFrame.setVisible(true);
            teacherAttendanceFrame.setTitle("Attendance");
            teacherAttendanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class ResultsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherResultsFrame = new TeacherResultsFrame(loggedIn, poll);
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

    class TestListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("This is the first question: " + poll.getQuestion(1).getQuestion() +
                                "\n This is the correct answer: " + poll.getQuestion(1).getCorrectAnswer() +
                                "\n This is a wrong answer: " + poll.getQuestion(1).getAnswer(2) +
                                "\n This is also a wrong answer: " + poll.getQuestion(1).getAnswer(3) +
                                 "\n This is the last wrong answer: " + poll.getQuestion(1).getAnswer(4));

            System.out.println("This is the second question: " + poll.getQuestion(2).getQuestion() +
                    "\n This is the correct answer: " + poll.getQuestion(2).getCorrectAnswer() +
                    "\n This is a wrong answer: " + poll.getQuestion(2).getAnswer(2) +
                    "\n This is also a wrong answer: " + poll.getQuestion(2).getAnswer(3) +
                    "\n This is the last wrong answer: " + poll.getQuestion(2).getAnswer(4));
        }
    }
}
