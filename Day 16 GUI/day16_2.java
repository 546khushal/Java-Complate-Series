/**Demonstrate working of JTextField, JTextArea with event handling.   */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class day16_2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField and TextArea Demo");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTextField
        JTextField textField = new JTextField(20);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text entered in JTextField: " + textField.getText());
            }
        });

        // Create a JTextArea
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                System.out.println("Text entered in JTextArea: " + textArea.getText());
            }
        });

        // Create a panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Enter text in JTextField:"));
        panel.add(textField);
        panel.add(new JLabel("Enter text in JTextArea:"));
        panel.add(new JScrollPane(textArea));

        frame.add(panel);
        frame.setVisible(true);
    }
}
