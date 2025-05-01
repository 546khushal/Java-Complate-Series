// Create a Calculator class to add two integers and two floats using method overloading
class day4_3 {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add two floats
    public float add(float a, float b) {
        return a + b;
    }

    public static void main(String[] args) {
        day4_3 calc = new day4_3();
        System.out.println("Sum of two integers: " + calc.add(5, 10));
        System.out.println("Sum of two floats: " + calc.add(5.5f, 10.5f));
    }
}
