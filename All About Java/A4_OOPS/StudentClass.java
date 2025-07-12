//package OOPS;//ydi pachakge alg hai to import krna hoga
/*cd "E:\MCA\sem 2\JAVA\PW series\OOPS"
javac Student.java StudentClass.java
java StudentClass */


public class StudentClass{
    //we have to declare the class outside main
    //like creating a data type
    
    //-> dusri file se access krenge ab Student class ko yha se hta de
    public static class Student{
        String name;
        int rno;
        double percent;
    }
    static void func(Student x){
        System.out.println(x.name);
    }
    // Changes the Student object's fields (pass-by-reference)
    static void change(Student x) {
        x.rno += 100;
        x.name = "Ram";
    }


    // This method won't affect the original primitive value
    static void change(int x) {
        x = 7;
    }

    public static void main(String[] args){
        //yha bna skte hai pr problem hai jb bhi function banana ho to access nhi kr paonge
        //  class Student{
        // String name;
        // int rno;
        // double percent;
        // }
        
        
        Student s1 = new Student();
        s1.name="Khushal";
        s1.rno=123;
        s1.percent=99.89;
        System.out.println(s1.name);

        Student s2 = new Student();
        s2.name="Rohan";
        s2.rno=35;
        s2.percent=59.89;
        System.out.println(s2.name);
        change(s2);
        System.out.println(s2.name+" "+s2.rno);  //Ram 135 yha change hua       
        

        func(s1);
        //ydi class main me banai to error 
        
        // Demonstrating pass-by-value with primitive
        int x = 5;
        change(x);
        System.out.println(x);  // Output: 5 (unchanged)

    }
}