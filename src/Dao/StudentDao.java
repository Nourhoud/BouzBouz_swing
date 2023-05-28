package Dao;

import Model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDao {
    public static Student retrieveStudent(String CNE){
        try {
            Student stu = null;
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/students";
            String user = "root";
            String passwd = "";

            Connection con = DriverManager.getConnection(url,user,passwd);
            //System.out.println("connected !!");


            Statement stm = con.createStatement();

            ResultSet resultSet = stm.executeQuery("SELECT * FROM student WHERE CNE='"+CNE+"'");

            while (resultSet.next()){
                stu = new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
            con.close();
            return stu;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList<Student> retrieveAllStudents(){
        try {
            ArrayList<Student> stuList = new ArrayList<Student>();
            Student stu = null;
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/students";
            String user = "root";
            String passwd = "";

            Connection con = DriverManager.getConnection(url,user,passwd);
            //System.out.println("connected !!");


            Statement stm = con.createStatement();

            ResultSet resultSet = stm.executeQuery("SELECT * FROM students ");

            while (resultSet.next()){
                stu = new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                stuList.add(stu);
            }
            con.close();
            return stuList;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addStudents(String nom,String prenom,String CNE, String note, String tel, String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/students";
            String user = "root";
            String passwd = "";

            Connection con = DriverManager.getConnection(url,user,passwd);
            System.out.println("connected !!");


            Statement stm = con.createStatement();

            stm.executeUpdate("INSERT INTO students values ('"+nom+"','"+prenom+"','"+CNE+"','"+note+"','"+tel+"','"+email+"')");



            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void editStudents(String nom,String prenom,String CNE, String note, String tel, String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/students";
            String user = "root";
            String passwd = "";

            Connection con = DriverManager.getConnection(url,user,passwd);
            System.out.println("connected !!");


            Statement stm = con.createStatement();

            stm.executeUpdate("UPDATE students SET nom ='"+nom+"' ,prenom = '"+prenom+"',note = '"+note+"',tel = '"+tel+"',email = '"+email+"' where CNE='"+CNE+"'");

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteStudents(String nom,String prenom,String CNE, String note, String tel, String email){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/students";
            String user = "root";
            String passwd = "";

            Connection con = DriverManager.getConnection(url,user,passwd);
            System.out.println("connected !!");


            Statement stm = con.createStatement();

            stm.executeUpdate("DELETE FROM students  where CNE='"+CNE+"'");

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
