/**With the help of Student(id,name,age) class do the followings: 
a. Create list of 5 students. Iterate from first to last student and display all the information about 
each student. 
b. Create stack of 5 students. Iterate from first to last student and display all the information 
about each student. 
c. Create vector of 5 students. Iterate from first to last student and display all the information 
about each student.  */
import java.util.*;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}

public class day09_1 {
    public static void main(String[] args) {
        // Code for list, stack, and vector
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Alice", 20));
        studentList.add(new Student(2, "Bob", 22));
        studentList.add(new Student(3, "Charlie", 21));
        studentList.add(new Student(4, "David", 23));
        studentList.add(new Student(5, "Eve", 20));

        System.out.println("Iterating over List:");
        for (Student s : studentList) {
            System.out.println(s);
        }

        Stack<Student> studentStack = new Stack<>();
        studentStack.addAll(studentList);

        System.out.println("\nIterating over Stack:");
        for (Student s : studentStack) {
            System.out.println(s);
        }

        Vector<Student> studentVector = new Vector<>(studentList);

        System.out.println("\nIterating over Vector:");
        for (Student s : studentVector) {
            System.out.println(s);
        }
    }
}
