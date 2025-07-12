import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClinicAppointmentBooking {

    static class Appointment {
        String patientName;
        String doctorName;
        String appointmentDate;
        String appointmentTime;

        public Appointment(String patientName, String doctorName, String appointmentDate, String appointmentTime) {
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.appointmentDate = appointmentDate;
            this.appointmentTime = appointmentTime;
        }

        @Override
        public String toString() {
            return "Patient: " + patientName + ", Doctor: " + doctorName + ", Date: " + appointmentDate + ", Time: " + appointmentTime;
        }
    }

    private ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClinicAppointmentBooking().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Clinic Appointment Booking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        JLabel nameLabel = new JLabel("Patient Name:");
        JTextField nameField = new JTextField();
        JLabel doctorLabel = new JLabel("Doctor Name:");
        JTextField doctorField = new JTextField();
        JLabel dateLabel = new JLabel("Appointment Date (YYYY-MM-DD):");
        JTextField dateField = new JTextField();
        JLabel timeLabel = new JLabel("Appointment Time (HH:MM):");
        JTextField timeField = new JTextField();

        JButton bookButton = new JButton("Book Appointment");
        JButton updateButton = new JButton("Update Appointment");
        JButton cancelButton = new JButton("Cancel Appointment");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(doctorLabel);
        formPanel.add(doctorField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(timeLabel);
        formPanel.add(timeField);
        formPanel.add(bookButton);
        formPanel.add(updateButton);
        formPanel.add(cancelButton);

        // Appointment List Panel
        JPanel listPanel = new JPanel(new BorderLayout());
        JLabel listLabel = new JLabel("Appointments:");
        JTextArea listArea = new JTextArea();
        listArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listArea);

        listPanel.add(listLabel, BorderLayout.NORTH);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(listPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        bookButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String doctor = doctorField.getText().trim();
            String date = dateField.getText().trim();
            String time = timeField.getText().trim();

            if (name.isEmpty() || doctor.isEmpty() || date.isEmpty() || time.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Appointment appointment = new Appointment(name, doctor, date, time);
            appointments.add(appointment);

            listArea.append(appointment.toString() + "\n");

            nameField.setText("");
            doctorField.setText("");
            dateField.setText("");
            timeField.setText("");

            JOptionPane.showMessageDialog(frame, "Appointment booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        updateButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter Patient Name to Update:");

            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Patient name is required to update!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Appointment appointment : appointments) {
                if (appointment.patientName.equalsIgnoreCase(name.trim())) {
                    String newDoctor = JOptionPane.showInputDialog(frame, "Enter New Doctor Name:", appointment.doctorName);
                    String newDate = JOptionPane.showInputDialog(frame, "Enter New Appointment Date:", appointment.appointmentDate);
                    String newTime = JOptionPane.showInputDialog(frame, "Enter New Appointment Time:", appointment.appointmentTime);

                    if (newDoctor != null && !newDoctor.trim().isEmpty()) {
                        appointment.doctorName = newDoctor.trim();
                    }
                    if (newDate != null && !newDate.trim().isEmpty()) {
                        appointment.appointmentDate = newDate.trim();
                    }
                    if (newTime != null && !newTime.trim().isEmpty()) {
                        appointment.appointmentTime = newTime.trim();
                    }

                    listArea.setText("");
                    for (Appointment a : appointments) {
                        listArea.append(a.toString() + "\n");
                    }

                    JOptionPane.showMessageDialog(frame, "Appointment updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(frame, "No appointment found for the given patient name!", "Error", JOptionPane.ERROR_MESSAGE);
        });

        cancelButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter Patient Name to Cancel:");

            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Patient name is required to cancel!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            appointments.removeIf(appointment -> appointment.patientName.equalsIgnoreCase(name.trim()));

            listArea.setText("");
            for (Appointment appointment : appointments) {
                listArea.append(appointment.toString() + "\n");
            }

            JOptionPane.showMessageDialog(frame, "Appointment cancelled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);
    }
}
