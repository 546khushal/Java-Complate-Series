/**Write a program for GUI based calculator with addition, subtraction, multiplication and division 
functionalities.   */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private String currentInput = "";  // To store current input for calculations
    private double firstNum = 0, secondNum = 0, result = 0;
    private String operator = "";  // To store the current operator

    public Calculator() {
        // Initialize components
        display = new JTextField(20);
        display.setEditable(false);  // Display is read-only
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        
        // Create the buttons
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new ButtonClickListener());
        }

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("C");

        // Button actions
        addButton.addActionListener(new OperatorClickListener());
        subtractButton.addActionListener(new OperatorClickListener());
        multiplyButton.addActionListener(new OperatorClickListener());
        divideButton.addActionListener(new OperatorClickListener());
        equalsButton.addActionListener(new EqualsClickListener());
        clearButton.addActionListener(new ClearClickListener());

        // Set up the layout
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));  // 4x4 grid for buttons

        // Add number buttons to the grid
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(multiplyButton);

        panel.add(numberButtons[0]);
        panel.add(clearButton);
        panel.add(equalsButton);
        panel.add(divideButton);

        // Adding display at the top
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ButtonClickListener for number buttons
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            currentInput += source.getText();
            display.setText(currentInput);
        }
    }

    // OperatorClickListener for operator buttons
    private class OperatorClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            operator = source.getText();
            firstNum = Double.parseDouble(currentInput);  // Store the first number
            currentInput = "";  // Reset the input field for next number
        }
    }

    // EqualsClickListener for equals button
    private class EqualsClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondNum = Double.parseDouble(currentInput);  // Store the second number
            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "/":
                    if (secondNum != 0) {
                        result = firstNum / secondNum;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero!");
                        result = 0;
                    }
                    break;
                default:
                    break;
            }
            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);  // Store the result for further calculations
        }
    }

    // ClearClickListener for clear button
    private class ClearClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentInput = "";
            display.setText(currentInput);
            firstNum = secondNum = result = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
