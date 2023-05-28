package View;
import javax.swing.*;
import java.awt.*;

public class Student_view extends JFrame {
    private JTable studentTable;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public Student_view() {
        // Set the title of the JFrame
        setTitle("Student CRUD Application");

        // Create the GUI components
        studentTable = new JTable();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");

        // Create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);




        // Create a JPanel to hold the student table
        JPanel studentPanel = new JPanel(new BorderLayout());
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        studentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the student panel to the JFrame
        add(studentPanel);

        // Set the size and visibility of the JFrame
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public JTable getStudentTable() {
        return studentTable;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
