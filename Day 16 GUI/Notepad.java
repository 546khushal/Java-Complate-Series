import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame {
    // Declare JTextArea for text input
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private File currentFile; // To store the current file reference

    public Notepad() {
        // Set the title of the window
        setTitle("Notepad");

        // Set the size of the window
        setSize(600, 400);

        // Create a JTextArea for input
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));  // Set font size and style

        // Create a JScrollPane for the JTextArea (to allow scrolling)
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the scrollPane to the center of the window
        add(scrollPane, BorderLayout.CENTER);

        // Create a file chooser for file operations
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));

        // Set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create the "File" menu
        JMenu fileMenu = new JMenu("File");

        // Add menu items to the "File" menu
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(new NewFileListener());

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new OpenFileListener());

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new SaveFileListener());

        JMenuItem saveAsItem = new JMenuItem("Save As");
        saveAsItem.addActionListener(new SaveAsFileListener());

        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.addActionListener(new CloseFileListener());

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitListener());

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator();  // Add a separator line
        fileMenu.add(exitItem);

        // Create the "Edit" menu
        JMenu editMenu = new JMenu("Edit");

        // Add menu items to the "Edit" menu
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(new CutListener());

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(new CopyListener());

        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(new PasteListener());

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Create the "Help" menu
        JMenu helpMenu = new JMenu("Help");

        // Add menu items to the "Help" menu
        JMenuItem aboutItem = new JMenuItem("About Notepad");
        aboutItem.addActionListener(new AboutListener());

        helpMenu.add(aboutItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set the menu bar
        setJMenuBar(menuBar);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window visibility to true
        setVisible(true);
    }

    // Listener for New menu item
    private class NewFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");  // Clear the text area
            currentFile = null;  // Clear the reference to the current file
        }
    }

    // Listener for Open menu item
    private class OpenFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int returnValue = fileChooser.showOpenDialog(Notepad.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                openFile(file);
            }
        }
    }

    // Listener for Save menu item
    private class SaveFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentFile != null) {
                saveFile(currentFile);  // Save the current file
            } else {
                int returnValue = fileChooser.showSaveDialog(Notepad.this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    saveFile(file);  // Save as a new file
                }
            }
        }
    }

    // Listener for Save As menu item
    private class SaveAsFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int returnValue = fileChooser.showSaveDialog(Notepad.this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                saveFile(file);  // Save the file as a new file
            }
        }
    }

    // Listener for Close menu item
    private class CloseFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");  // Clear the text area
            currentFile = null;  // Clear the reference to the current file
        }
    }

    // Listener for Exit menu item
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);  // Exit the application
        }
    }

    // Listener for Cut menu item
    private class CutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.cut();  // Cut the selected text
        }
    }

    // Listener for Copy menu item
    private class CopyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.copy();  // Copy the selected text
        }
    }

    // Listener for Paste menu item
    private class PasteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.paste();  // Paste the text from clipboard
        }
    }

    // Listener for About menu item
    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(Notepad.this,
                    "Notepad - A simple text editor\nCreated by ChatGPT",
                    "About Notepad",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method to save the file
    private void saveFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(textArea.getText());
            currentFile = file;  // Update the reference to the current file
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error saving file: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to open a file
    private void openFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.setText("");  // Clear the text area before loading the new content
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            currentFile = file;  // Update the reference to the current file
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error opening file: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to launch the Notepad application
    public static void main(String[] args) {
        new Notepad();
    }
}
