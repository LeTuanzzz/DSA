/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

public class Student {
    private String id;
    private String fullName;
    private double marks;

    // Constructor
    public Student(String id, String fullName, double marks) {
        this.id = id;
        this.fullName = fullName;
        this.marks = marks;
    }   

    // Getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getMarks() {
        return marks;
    }

    // Method to determine ranking based on marks
    public String getRanking() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // toString method for easy display of student information
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + fullName + ", Marks: " + marks + ", Rank: " + getRanking();
    }
}
