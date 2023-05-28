package Controller;

import Dao.StudentDao;
import Model.Student;
import View.Student_view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentController implements ActionListener {
    private Student_view studentView;
    private ArrayList<Student> studentList;
    private DefaultTableModel studentTableModel;

    public StudentController(Student_view studentView) {
        this.studentView = studentView;
//        this.studentList = new ArrayList<>();




        this.studentTableModel = new DefaultTableModel(new String[]{"Nom", "Prénom", "CNE", "Note", "Téléphone", "Email"}, 0);

        this.studentView.getStudentTable().setModel(studentTableModel);

        this.studentList = StudentDao.retrieveAllStudents();
        for (int i=0;i<studentList.size();i++){
            Student student = studentList.get(i);

            studentTableModel.addRow(new Object[]{student.getNom(), student.getPrenom(),student.getCNE(), student.getNote(), student.getTel(),student.getEmail()});

        }

        // Add action listeners to the buttons
        this.studentView.getAddButton().addActionListener(this);
        this.studentView.getEditButton().addActionListener(this);
        this.studentView.getDeleteButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == studentView.getAddButton()) {
            addStudent();
        } else if (e.getSource() == studentView.getEditButton()) {
            editStudent();
        } else if (e.getSource() == studentView.getDeleteButton()) {
            deleteStudent();
        }
    }

    private void addStudent() {
        // Create a new student object with data from the GUI
        String nom = JOptionPane.showInputDialog(studentView, "Nom:");
        String prenom = JOptionPane.showInputDialog(studentView, "Prénom:");
        String email = JOptionPane.showInputDialog(studentView, "Email:");
        String telephone = JOptionPane.showInputDialog(studentView, "Téléphone:");
        String cne = JOptionPane.showInputDialog(studentView, "CNE:");
        String note = JOptionPane.showInputDialog(studentView, "Note:");
        Student student = new Student(nom, prenom, cne, note, telephone, email);
        // Add the student to the list and update the GUI
        studentList.add(student);
        studentTableModel.addRow(new Object[]{student.getNom(), student.getPrenom(),student.getCNE(), student.getNote(), student.getTel(),student.getEmail()});

        StudentDao.addStudents(student.getNom(),student.getPrenom(),student.getCNE(),student.getNote(),student.getTel(),student.getEmail());
    }

    private void editStudent() {
        // Get the selected row in the student table
        int selectedRow = studentView.getStudentTable().getSelectedRow();

        if (selectedRow != -1) {
            // Get the student object corresponding to the selected row
            Student student = studentList.get(selectedRow);

            // Update the student object with data from the GUI
            String nom = JOptionPane.showInputDialog(studentView, "Nom:", student.getNom());
            String prenom = JOptionPane.showInputDialog(studentView, "Prénom:", student.getPrenom());
            String cne = JOptionPane.showInputDialog(studentView, "CNE:", student.getCNE());
            String note = JOptionPane.showInputDialog(studentView, "Note:", student.getNote());
            String telephone = JOptionPane.showInputDialog(studentView, "Téléphone:", student.getTel());
            String email = JOptionPane.showInputDialog(studentView, "Email:", student.getEmail());

            student.setNom(nom);
            student.setPrenom(prenom);
            student.setCNE(cne);
            student.setNote(note);
            student.setTel(telephone);
            student.setEmail(email);


            // Update the student table in the GUI
            studentTableModel.setValueAt(nom, selectedRow, 0);
            studentTableModel.setValueAt(prenom, selectedRow, 1);
            studentTableModel.setValueAt(email, selectedRow, 5);
            studentTableModel.setValueAt(telephone, selectedRow, 4);
            studentTableModel.setValueAt(cne, selectedRow, 2);
            studentTableModel.setValueAt(note, selectedRow, 3);

            StudentDao.editStudents(student.getNom(),student.getPrenom(),student.getCNE(),student.getNote(),student.getTel(),student.getEmail());
        }
    }
    private void deleteStudent() {
        // Get the selected row in the student table
        int selectedRow = studentView.getStudentTable().getSelectedRow();

        if (selectedRow != -1) {
            Student student = studentList.get(selectedRow);
            // Remove the student from the list and update the GUI
            studentList.remove(selectedRow);
            studentTableModel.removeRow(selectedRow);

            StudentDao.deleteStudents(student.getNom(),student.getPrenom(),student.getCNE(),student.getNote(),student.getTel(),student.getEmail());

        }

    }
}
