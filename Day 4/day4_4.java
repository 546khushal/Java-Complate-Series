// Add a static variable to count the number of objects created in the Student class
class day4_4 {
    private String name;
    private int age;
    private static int objectCount = 0; // Static variable to count objects

    public day4_4(String name, int age) {
        this.name = name;
        this.age = age;
        objectCount++; // Increment object count when a new object is created
    }

    public static int getObjectCount() {
        return objectCount; // Return the count of objects created
    }

    public static void main(String[] args) {
        day4_4 student1 = new day4_4("Alice", 20);
        day4_4 student2 = new day4_4("Bob", 22);
        day4_4 student3 = new day4_4("Charlie", 21);

        System.out.println("Number of Student objects created: " + day4_4.getObjectCount());
    }
}
