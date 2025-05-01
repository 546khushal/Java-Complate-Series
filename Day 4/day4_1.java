// Compare Two Students' Ages and Print the Name with Highest Age
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void compareAges(Student s1, Student s2) {
        if (s1.getAge() > s2.getAge()) {
            System.out.println("Student with highest age: " + s1.getName());
        } else if (s1.getAge() < s2.getAge()) {
            System.out.println("Student with highest age: " + s2.getName());
        } else {
            System.out.println("Both students have the same age.");
        }
    }
}
