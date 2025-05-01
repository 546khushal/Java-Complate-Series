import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealCalculator {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Advanced Calculator");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        // Create the display field
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setText("0");

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));

        // Button labels
        String[] buttons = {
            "C", "<x", "/", "x",
            "7", "8", "9", "-",
            "4", "5", "6", "+",
            "1", "2", "3", "=",
            "0", ".", "(", ")"
        };

        // Add buttons to the panel
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            buttonPanel.add(button);

            // Add functionality to buttons
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();

                    if (command.equals("C")) {
                        display.setText("0"); // Clear the display
                    } else if (command.equals("<x")) {
                        String text = display.getText();
                        // Handle backspace functionality
                        if (text.length() > 1) {
                            display.setText(text.substring(0, text.length() - 1)); // Remove the last character
                        } else {
                            display.setText("0"); // Reset to 0 if empty
                        }
                    } else if (command.equals("=")) {
                        try {
                            String expression = display.getText()
                                    .replace("×", "*") // Replace for evaluation
                                    .replace("÷", "/");
                            String result = evaluate(expression);
                            display.setText(result);
                        } catch (Exception ex) {
                            display.setText("Error");
                        }
                    } else {
                        if (display.getText().equals("0")) {
                            display.setText(command); // Replace initial 0
                        } else {
                            display.setText(display.getText() + command);
                        }
                    }
                }
            });
        }

        // Add components to frame
        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Evaluate the mathematical expression
    public static String evaluate(String expression) {
        try {
            return String.valueOf(
                new javax.script.ScriptEngineManager()
                        .getEngineByName("JavaScript")
                        .eval(expression)
            );
        } catch (Exception e) {
            return "Error";
        }
    }
}
