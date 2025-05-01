// Compare Two Students' Ages and Print the Name with Highest Age
class day4_1 {
    private String name;
    private int age;

    public day4_1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void compareAges(day4_1 s1, day4_1 s2) {
        if (s1.getAge() > s2.getAge()) {
            System.out.println("Student with highest age: " + s1.getName());
        } else if (s1.getAge() < s2.getAge()) {
            System.out.println("Student with highest age: " + s2.getName());
        } else {
            System.out.println("Both students have the same age.");
        }
    }

    public static void main(String[] args) {
        day4_1 student1 = new day4_1("Alice", 20);
        day4_1 student2 = new day4_1("Bob", 22);
        compareAges(student1, student2);
    }
}
