/*For the Student class(id,name,age) override toString and  equals methods of object class. Test working 
of both the methods. */
class day7_1 {
    private int id;
    private String name;
    private int age;

    public day7_1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [ID: " + id + ", Name: " + name + ", Age: " + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        day7_1 other = (day7_1) obj;
        return id == other.id && name.equals(other.name) && age == other.age;
    }

    public static void main(String[] args) {
        day7_1 s1 = new day7_1(1, "Alice", 20);
        day7_1 s2 = new day7_1(1, "Alice", 20);
        day7_1 s3 = new day7_1(2, "Bob", 22);

        System.out.println("Testing toString Method:");
        System.out.println(s1);

        System.out.println("\nTesting equals Method:");
        System.out.println("s1 equals s2: " + s1.equals(s2)); // Should return true
        System.out.println("s1 equals s3: " + s1.equals(s3)); // Should return false
    }
}
