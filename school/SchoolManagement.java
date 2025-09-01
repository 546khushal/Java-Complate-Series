package school;

import java.util.*;

public class SchoolManagement {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        Scanner sc  = new Scanner(System.in);

        //Adding Students
        Student s1 = new Student("Khushal",23,101);
        s1.addSubject(Subject.MATH);
        s1.addSubject(Subject.COMPUTER);

        Student s2 = new Student("Rahul", 22, 102);
        s2.addSubject(Subject.ENGLISH);
        s2.addSubject(Subject.SCIENCE);

        students.add(s1);
        students.add(s2);

        // Adding teachers
        Teacher t1 = new Teacher("Mrs. Sharma", 40, "Math");
        Teacher t2 = new Teacher("Mr. Verma", 35, "Computer");


        // Display Info
        Utilities.printLine();
        s1.displayInfo();
        Utilities.printLine();
        t1.displayInfo();
        t1.teach();
        t1.teach("Algebra");
        Utilities.printLine();

         // Notifications
        s2.sendNotification("Exam on Monday!");
    
        // Static & Final usage
        System.out.println("Total Students: " + Student.getStudentCount());
        System.out.println("School Address: " + Utilities.SCHOOL_ADDRESS);

        // Exception Handling
        try {
            System.out.print("Enter index to fetch student: ");
            int idx = sc.nextInt();
            System.out.println("Student Name: " + students.get(idx).getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }


         // File I/O
        Database.saveStudents(students);
        List<Student> loaded = Database.loadStudents();
        System.out.println("Loaded Students:");
        for(Student s : loaded) {
            s.displayInfo();
        }

        sc.close();
    }   
}