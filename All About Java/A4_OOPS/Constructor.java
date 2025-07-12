/*
*Constructor in java is a special type of method that is used to initialize the object. 
*Java constructor is invoked at the time of object creation 

*There are basically two rules defined for the constructor.  
        1. Constructor name must be same as its class name 
        2. Constructor must have no explicit return type 

There are two types of constructors: 
    1. Default constructor (no-arg constructor) 
        A constructor that have no parameter is known as default constructor. 
    2. Parameterized constructor 

    3. Copy Costructor
        There is no copy constructor in java. But, we can copy the values of one object to another

Constructor OverLoading
    Constructor overloading is a technique in Java in which a class can have any number of 
    constructors that differ in parameter lists.
*/

class Student {
    String name;
    int rollNo;
    float marks;

    // 1. Default Constructor (no arguments)
    Student() {
        System.out.println("Default constructor called");
        this.name = "Unknown";
        this.rollNo = 0;
        this.marks = 0.0f;
    }

    // 2. Parameterized Constructor
    Student(String name, int rollNo, float marks) {
        System.out.println("Parameterized constructor called");
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // 3. Copy Constructor
    Student(Student other) {
        System.out.println("Copy constructor called");
        this.name = other.name;
        this.rollNo = other.rollNo;
        this.marks = other.marks;
    }

    // 4. Constructor Overloading (different parameters)
    Student(String name) {
        this(name, 0, 0.0f); // Calling parameterized constructor
        System.out.println("Single-argument constructor called");
    }

    void display() {
        System.out.println("Student: " + name + ", Roll No: " + rollNo + ", Marks: " + marks);
    }
}

public class Constructor{
    public static void main(String[] args) {
        // 1. Default constructor
        Student s1 = new Student();//Default constructor called
        s1.display();//Student: Unknown, Roll No: 0, Marks: 0.0

        // 2. Parameterized constructor
        Student s2 = new Student("Alice", 101, 85.5f);//Parameterized constructor called
        s2.display();//Student: Alice, Roll No: 101, Marks: 85.5

        // 3. Copy constructor
        Student s3 = new Student(s2);//Copy constructor called
        s3.display();//Student: Alice, Roll No: 101, Marks: 85.5 

        // 4. Overloaded constructor
        Student s4 = new Student("Bob");/*Parameterized constructor called
                        Single-argument constructor called
                        */
        s4.display();//Student: Bob, Roll No: 0, Marks: 0.0 
    
        
    }
}