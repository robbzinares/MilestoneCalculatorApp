import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MilestoneCalculatorApp {
    private JFrame frame;
    private JLabel milestone1Label, milestone2Label, terminalLabel;
    private JTextField milestone1Field, milestone2Field, terminalField;
    private JButton calculateButton;

    // Maximum points for each milestone
    private final int MAX_MILESTONE1_POINTS = 25;
    private final int MAX_MILESTONE2_POINTS = 40;
    private final int MAX_TERMINAL_POINTS = 35;

    public MilestoneCalculatorApp() {
        frame = new JFrame("Milestone Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        milestone1Label = new JLabel("Milestone 1 (%):");
        milestone2Label = new JLabel("Milestone 2 (%):");
        terminalLabel = new JLabel("Terminal Assessment (%):");

        milestone1Field = new JTextField();
        milestone2Field = new JTextField();
        terminalField = new JTextField();

        calculateButton = new JButton("Calculate Grades");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });

        frame.add(milestone1Label);
        frame.add(milestone1Field);
        frame.add(milestone2Label);
        frame.add(milestone2Field);
        frame.add(terminalLabel);
        frame.add(terminalField);
        frame.add(new JLabel()); // Empty cell for spacing
        frame.add(calculateButton);

        frame.setVisible(true);
    }

    public void calculateGrades() {
        try {
            double milestone1 = Double.parseDouble(milestone1Field.getText());
            double milestone2 = Double.parseDouble(milestone2Field.getText());
            double terminal = Double.parseDouble(terminalField.getText());

            // Validate input against maximum points
            if (milestone1 < 0 || milestone1 > MAX_MILESTONE1_POINTS ||
                    milestone2 < 0 || milestone2 > MAX_MILESTONE2_POINTS ||
                    terminal < 0 || terminal > MAX_TERMINAL_POINTS) {
                showErrorDialog("Invalid input! Grades should be between 0 and the maximum points for each milestone.");
                return;
            }

            double totalGrade = (milestone1 * 0.25) + (milestone2 * 0.40) + (terminal * 0.35);
            JOptionPane.showMessageDialog(frame, "Total Grade: " + totalGrade);
        } catch (NumberFormatException ex) {
            showErrorDialog("Invalid input! Please enter numeric values.");
        }
    }

    public void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MilestoneCalculatorApp();
            }
        });
    }
}
