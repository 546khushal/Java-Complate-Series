// Class demonstrating overloading and overriding
class Shape {
    // Overloaded methods (Compile-time polymorphism)
    public double area(double radius) { // Circle area
        return 3.14 * radius * radius;
    }

    public double area(double length, double breadth) { // Rectangle area
        return length * breadth;
    }

    // Method to be overridden
    public void description() {
        System.out.println("This is a generic shape");
    }
}

// Subclass overriding a method
class Circle extends Shape {
    // Overriding the description method (Runtime polymorphism)
    @Override
    public void description() {
        System.out.println("This is a circle");
    }

    // Overriding the area method for circle only (optional)
    @Override
    public double area(double radius) {
        return Math.PI * radius * radius; // More accurate Pi
    }
}

// Main class to test the program
public class inheritance {
    public static void main(String[] args) {
        // Using the parent class directly
        Shape shape = new Shape();
        System.out.println("Area of circle (Shape class): " + shape.area(5)); // Overloaded
        System.out.println("Area of rectangle (Shape class): " + shape.area(4, 6)); // Overloaded
        shape.description(); // Parent class method

        // Using the child class
        Circle circle = new Circle();
        circle.description(); // Overridden method
        System.out.println("Area of circle (Circle class): " + circle.area(5)); // Overloaded (from Circle class)
        System.out.println("Area of rectangle (Circle class): " + circle.area(4, 6)); // Inherited method

        // Demonstrating polymorphism
        Shape polymorphicShape = new Circle(); // Parent reference to child object
        polymorphicShape.description(); // Overridden method (Runtime polymorphism)
        System.out.println("Area of circle (Polymorphic Shape): " + polymorphicShape.area(5)); // Overloaded in Shape, not Circle
    }
}
