package com.multicampus.daos;

import com.multicampus.MariaDBConnector;
import com.multicampus.models.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private ArrayList<Student> listOfStudents;

    public StudentDAO() {
        this.listOfStudents = new ArrayList<Student>();
    }

    public void displayStudent() {
        String dbHost = "localhost";
        int dbPort = 3307;
        String dbName = "studentms";
        String dbUser = "root";
        String dbPass = "1105";

        try {
            MariaDBConnector connector = new MariaDBConnector(dbHost, dbPort, dbName, dbUser, dbPass);
            String sql = "SELECT * FROM student";
            ResultSet result = connector.executeQuery(sql);

            while (result.next()) {
                String stdID = result.getString("stdID");
                String stdName = result.getString("stdName");
                String stdMobile = result.getString("stdMobile");

                Student std = new Student(stdID, stdName, stdMobile);
                listOfStudents.add(std);
            }
            if (this.listOfStudents.isEmpty()) {
                System.out.println("List is Empty");
            } else {
                System.out.println("List of Students");
                for (Student std : listOfStudents) {
                    System.out.println(std.toString());
                }
            }
            connector.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //1. Add a new Student
    public void addNewStudent(Student std) {
        this.listOfStudents.add(std);
        System.out.println(this.listOfStudents.size());
    }

    //2. Delete a Student(){
    public void deleteStudent() {
        System.out.println("Delete a Student");
    }

    //3. Update a Student
    public void updateStudent() {
        System.out.println("Update a Student");
    }

    //4. Seach Student
    public void searchStudent() {
        System.out.println("Search Student");
    }
}