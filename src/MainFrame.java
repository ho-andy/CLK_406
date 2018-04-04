import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JLabel userLabel = new JLabel("Username");
    private JTextField userField = new JTextField(69);
    private JLabel passLabel = new JLabel("Password");
    private JTextField passField = new JTextField(69);
    private JButton loginButton = new JButton("Login");

    public MainFrame(){
        this.setSize(888, 888);
        this.setLayout(new FlowLayout());

        this.add(userLabel);
        this.add(userField);
        this.add(passLabel);
        this.add(passField);
        this.add(loginButton);

        loginButton.addActionListener(new LoginListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame studentFrame = new StudentFrame();
            studentFrame.setVisible(true);
            studentFrame.setTitle("Student");
            studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
