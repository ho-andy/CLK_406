import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrame extends JFrame{
    JButton button = new JButton("back");

    public StudentFrame(){
        this.setSize(888, 888);
        this.setLayout(new FlowLayout());


        this.add(button);
        button.addActionListener(new ButtonListener());
    }

    public void closePanel(){
        this.setVisible(false);
        this.dispose();
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame testerFrame = new MainFrame();
            testerFrame.setVisible(true);
            testerFrame.setTitle("iPoll");
            testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            closePanel();
        }
    }
}
