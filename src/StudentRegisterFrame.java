import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegisterFrame extends JFrame{
    private JButton backButton = new JButton("Back");

    private Person loggedIn;

    public StudentRegisterFrame(){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());
    }

    public StudentRegisterFrame(Person person){
        this.setSize(420, 747);
        this.setLayout(new FlowLayout());

        this.add(backButton);
        backButton.addActionListener(new BackListener());

        loggedIn = person;
        System.out.println(loggedIn);
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentFrame = new StudentFrame(loggedIn);
            studentFrame.setVisible(true);
            studentFrame.setTitle("Student");
            studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
