/*
1. this can be used to refer current class instance variable. 
2. this can be used to invoke current class method (implicitly) 
3. this() can be used to invoke current class constructor. 
4. this can be passed as an argument in the method call. 
5. this can be passed as argument in the constructor call. 
6. this can be used to return the current class instance from the method.  */
class Student {
    // Instance variables
    int rollno;
    String name;
    float fee;
    
    // Constructor using 'this' to distinguish parameters from instance variables
    Student(int rollno, String name, float fee) {
        this.rollno = rollno; // 'this' refers to current object
        this.name = name;
        this.fee = fee;
    }
    
    // Method to display student details
    void display() {
        System.out.println(rollno + " " + name + " " + fee);
    }
}

class ThisDemo {
    public static void main(String args[]) {
        // Creating Student objects
        Student s1 = new Student(111, "ankit", 5000f);
        Student s2 = new Student(112, "sumit", 6000f);
        
        // Calling display method
        s1.display(); // Output: 111 ankit 5000.0
        s2.display(); // Output: 112 sumit 6000.0
    }
}