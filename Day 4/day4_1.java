// Compare Two Students' Ages and Print the Name with Highest Age
// Compare Two Students' Ages and Print the Name with Highest Age
import java.util.Scanner;

class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Static method to compare ages
    public static void compareAges(Student s1, Student s2) {
        if (s1.getAge() > s2.getAge()) {
            System.out.println("Student with highest age: " + s1.getName());
        } else if (s1.getAge() < s2.getAge()) {
            System.out.println("Student with highest age: " + s2.getName());
        } else {
            System.out.println("Both students have the same age.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Student 1
        System.out.println("Enter details for Student 1:");
        System.out.print("Name: ");
        String name1 = sc.nextLine();
        System.out.print("Age: ");
        int age1 = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Input for Student 2
        System.out.println("Enter details for Student 2:");
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Age: ");
        int age2 = sc.nextInt();

        // Create objects
        Student student1 = new Student(name1, age1);
        Student student2 = new Student(name2, age2);

        // Compare ages
        compareAges(student1, student2);

        sc.close();
    }
}
