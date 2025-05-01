/*Demonstrate the use of FlowLayout, BorderLayout, GridLayout, GridBagLayout & CardLayout. */
import javax.swing.*;
import java.awt.*;

public class day16_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Layout Manager Demo");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FlowLayout Example
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JLabel("FlowLayout"));
        flowPanel.add(new JTextField(10));
        flowPanel.add(new JButton("Button"));

        // BorderLayout Example
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JLabel("North Label"), BorderLayout.NORTH);
        borderPanel.add(new JButton("Center Button"), BorderLayout.CENTER);
        borderPanel.add(new JLabel("South Label"), BorderLayout.SOUTH);

        // GridLayout Example
        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        gridPanel.add(new JButton("1"));
        gridPanel.add(new JButton("2"));
        gridPanel.add(new JButton("3"));
        gridPanel.add(new JButton("4"));

        // GridBagLayout Example
        JPanel gridBagPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridBagPanel.add(new JLabel("GridBag Layout"), gbc);

        // CardLayout Example
        JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.add(new JLabel("Card 1"), "Card 1");
        cardPanel.add(new JLabel("Card 2"), "Card 2");
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "Card 1");

        // Adding panels to frame
        frame.setLayout(new BorderLayout());
        frame.add(flowPanel, BorderLayout.NORTH);
        frame.add(borderPanel, BorderLayout.CENTER);
        frame.add(gridPanel, BorderLayout.SOUTH);
        frame.add(gridBagPanel, BorderLayout.EAST);
        frame.add(cardPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }
}
