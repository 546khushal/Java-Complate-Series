package school;

import java.util.*;
import java.io.*;

class Student extends Person implements Notifications, Serializable {
    private int rollNumber;
    private List<Subject> subjects = new ArrayList<>();
    private static int studentCount = 0; // static variable
    private final String schoolName = "My School"; // final variable

    // Constructor
    public Student(String name, int age, int rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
        studentCount++;
    }

    // Encapsulation
    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public void addSubject(Subject s) { subjects.add(s); }
    public List<Subject> getSubjects() { return subjects; }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + ", Age: " + getAge() + ", Roll: " + getRollNumber());
        System.out.println("School: " + schoolName);
        System.out.println("Subjects: " + subjects);
    }

    // Interface method
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification to " + getName() + ": " + message);
    }

    // Static method
    public static int getStudentCount() { return studentCount; }
}
