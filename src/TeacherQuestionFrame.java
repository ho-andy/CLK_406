import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

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
    private Question q;

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
        this.add(backButton);
        this.add(addButton);
        addButton.addActionListener(new AddListener());
        backButton.addActionListener(new BackListener());
    }

    public TeacherQuestionFrame(Poll poll){
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
        addButton.addActionListener(new AddListener());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.poll = poll;
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    public void addQuestion()
    {
        q = new Question(qField.getText(),corrField.getText());
        q.addAnswer(altFieldOne.getText(),false);
        q.addAnswer(altFieldTwo.getText(),false);
        q.addAnswer(altFieldThree.getText(),false);
        poll.addQuestion(q);

    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame teacherSessionFrame = new TeacherSessionFrame(poll);
            teacherSessionFrame.setVisible(true);
            teacherSessionFrame.setTitle("Session");
            teacherSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addQuestion();
            Socket session = Currents.SERVER;
            try {
                Random r = new Random();
                ArrayList<Integer> order = new ArrayList<Integer>();
                while(order.size()<4){
                    int rand = r.nextInt(3)+1;
                    if(!order.contains(rand))
                        order.add(rand);
                }
                Currents.TEACHER.sendMessageThroughSession(session, q.getQuestion());
                for(int i:order)
                    Currents.TEACHER.sendMessageThroughSession(session, q.getAnswer(i));
            }catch(IOException exc){
                exc.printStackTrace();
            }
            JFrame teacherSessionFrame = new TeacherSessionFrame(poll);
            teacherSessionFrame.setVisible(true);
            teacherSessionFrame.setTitle("Session");
            teacherSessionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
