import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherQuestionFrame extends JFrame{
    private JTextArea qField = new JTextArea(3,35);
    private JTextArea corrField = new JTextArea(3,35);
    private JTextArea altFieldOne = new JTextArea(3,35);
    private JTextArea altFieldTwo = new JTextArea(3,35);
    private JTextArea altFieldThree = new JTextArea(3,35);

    private JLabel qLabel = new JLabel("Question");
    private JLabel corrLabel = new JLabel("Correct Answer");
    private JLabel altLabelOne = new JLabel("Alternative Answer");
    private JLabel altLabelTwo = new JLabel("Alternative Answer");
    private JLabel altLabelThree = new JLabel("Alternative Answer");

    private JButton addButton = new JButton("Add");
    private JButton backButton = new JButton("Back");

    private Poll poll;
    private Person loggedIn;

    public TeacherQuestionFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(qLabel);
        this.add(qField);
        this.add(corrLabel);
        this.add(corrField);
        this.add(altLabelOne);
        this.add(altFieldOne);
        this.add(altLabelTwo);
        this.add(altFieldTwo);
        this.add(altLabelThree);
        this.add(altFieldThree);
        this.add(addButton);

        this.add(backButton);
        backButton.addActionListener(new BackListener());
    }

    public TeacherQuestionFrame(Person person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(qLabel);
        this.add(qField);
        this.add(corrLabel);
        this.add(corrField);
        this.add(altLabelOne);
        this.add(altFieldOne);
        this.add(altLabelTwo);
        this.add(altFieldTwo);
        this.add(altLabelThree);
        this.add(altFieldThree);
        this.add(addButton);

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.loggedIn = person;
    }

    public TeacherQuestionFrame(Person person, Poll poll){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(qLabel);
        this.add(qField);
        this.add(corrLabel);
        this.add(corrField);
        this.add(altLabelOne);
        this.add(altFieldOne);
        this.add(altLabelTwo);
        this.add(altFieldTwo);
        this.add(altLabelThree);
        this.add(altFieldThree);
        this.add(addButton);

        this.add(backButton);
        backButton.addActionListener(new BackListener());

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
            JFrame teacherSessionFrame = new TeacherSessionFrame(loggedIn, poll);
            teacherSessionFrame.setVisible(true);
            teacherSessionFrame.setTitle("Session");
            teacherSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
