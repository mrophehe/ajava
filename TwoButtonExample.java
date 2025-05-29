import javax.swing.*;
import java.awt.event.*;

public class TwoButtonExample {
public static void main(String[] args) {

JFrame frame = new JFrame("Two Button Event Handling");

        
JButton alphaButton = new JButton("Alpha");
JButton betaButton = new JButton("Beta");
JLabel label = new JLabel("");
        
alphaButton.setBounds(100, 100, 100, 40);
betaButton.setBounds(220, 100, 100, 40);
label.setBounds(140, 170, 200, 30);

alphaButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
label.setText("Alpha is pressed");}
        });

betaButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
label.setText("Beta is pressed");            }
        });


frame.add(alphaButton);
frame.add(betaButton);
frame.add(label);

frame.setSize(450, 300);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
    }
}
