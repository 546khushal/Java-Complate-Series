// Modify the Student class to add a static method to compare two students' ages and return the object with the highest age
class day4_6 {
    private String name;
    private int age;

    public day4_6(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Static method to compare two students and return the one with the highest age
    public static day4_6 getOldestStudent(day4_6 s1, day4_6 s2) {
        if (s1.getAge() > s2.getAge()) {
            return s1;
        } else if (s1.getAge() < s2.getAge()) {
            return s2;
        } else {
            return null; // Indicates both have the same age
        }
    }

    public static void main(String[] args) {
        day4_6 student1 = new day4_6("Alice", 20);
        day4_6 student2 = new day4_6("Bob", 22);

        day4_6 oldest = getOldestStudent(student1, student2);
        if (oldest != null) {
            System.out.println("Oldest student: " + oldest.getName() + " (Age: " + oldest.getAge() + ")");
        } else {
            System.out.println("Both students have the same age.");
        }
    }
}
