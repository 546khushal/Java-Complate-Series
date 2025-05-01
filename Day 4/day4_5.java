// Create an Outer class with instance variable 'a' and an Inner class with instance variable 'b'
class day4_5 {
    private int a = 10; // Instance variable of Outer class

    class Inner {
        private int b = 20; // Instance variable of Inner class

        public void printValues() {
            System.out.println("Value of 'a' from Outer class: " + a);
            System.out.println("Value of 'b' from Inner class: " + b);
        }
    }

    public static void main(String[] args) {
        day4_5 outer = new day4_5(); // Create Outer class object
        day4_5.Inner inner = outer.new Inner(); // Create Inner class object
        inner.printValues(); // Print values of 'a' and 'b'
    }
}
