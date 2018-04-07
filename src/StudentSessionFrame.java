import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSessionFrame extends JFrame{
    private JButton backButton = new JButton("Back");
    private JLabel questionLabel = new JLabel();
    private JRadioButton answerButtons = new JRadioButton();
    private JButton submitButton = new JButton("Submit");
    private String selectedAnswer = "";

    private Person loggedIn;

    public StudentSessionFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        this.add(questionLabel);

        questionLabel.setText("Wagwan fam?");

        JRadioButton answer1 = new JRadioButton("nm fam");
        JRadioButton answer2 = new JRadioButton("soft tings");
        JRadioButton answer3 = new JRadioButton("yknow stuff");
        JRadioButton answer4 = new JRadioButton("chilling with the boys");
        JRadioButton answer5 = new JRadioButton("just chillin");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answer1);
        buttonGroup.add(answer2);
        buttonGroup.add(answer3);
        buttonGroup.add(answer4);
        buttonGroup.add(answer5);

        answer1.addActionListener(new AnswerListener());
        answer2.addActionListener(new AnswerListener());
        answer3.addActionListener(new AnswerListener());
        answer4.addActionListener(new AnswerListener());
        answer5.addActionListener(new AnswerListener());

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(answer1);
        radioPanel.add(answer2);
        radioPanel.add(answer3);
        radioPanel.add(answer4);
        radioPanel.add(answer5);

        this.add(radioPanel);

        this.add(submitButton);
        submitButton.addActionListener(new SubmitListener());
    }

    public StudentSessionFrame(Person person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        loggedIn = person;

        this.add(questionLabel);

        questionLabel.setText("Wagwan fam?");

        JRadioButton answer1 = new JRadioButton("nm fam");
        JRadioButton answer2 = new JRadioButton("soft tings");
        JRadioButton answer3 = new JRadioButton("yknow stuff");
        JRadioButton answer4 = new JRadioButton("chilling with the boys");
        JRadioButton answer5 = new JRadioButton("just chillin");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answer1);
        buttonGroup.add(answer2);
        buttonGroup.add(answer3);
        buttonGroup.add(answer4);
        buttonGroup.add(answer5);

        answer1.addActionListener(new AnswerListener());
        answer2.addActionListener(new AnswerListener());
        answer3.addActionListener(new AnswerListener());
        answer4.addActionListener(new AnswerListener());
        answer5.addActionListener(new AnswerListener());

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(answer1);
        radioPanel.add(answer2);
        radioPanel.add(answer3);
        radioPanel.add(answer4);
        radioPanel.add(answer5);

        this.add(radioPanel);

        this.add(submitButton);
        submitButton.addActionListener(new SubmitListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentCourseFrame = new StudentCourseFrame(loggedIn);
            studentCourseFrame.setVisible(true);
            studentCourseFrame.setTitle("Course List");
            studentCourseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }

    class AnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton button = (JRadioButton) e.getSource();
            selectedAnswer = button.getText();
        }
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(selectedAnswer);
            //submit here
        }
    }
}
