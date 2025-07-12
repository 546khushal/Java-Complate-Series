/**
 * COMPLETE STATIC KEYWORD DEMONSTRATION
 * Covers:
 * - Static variables:- The static variable can be used to refer the common property of all objects
 * - Static methods:-A static method can be invoked without the need for creating an instance of a class
 * - Static blocks:-Is used to initialize the static data member. It is executed before main method at the time of class loading
 * - Static nested classes
 * - Static imports
 * - When to use static
 */
import static java.lang.Math.PI; // Import static member
public class StaticDemo {

    /*1. STATIC VARIABLES (Class Variables)
                Shared across all class instances
                Only one copy exists in memory
                Accessed via ClassName.variableName*/

    static int instanceCount = 0; 
    
    // Instance variable for comparison
    int instanceId; // Unique per object

    /*2. STATIC METHODS
            Can only access static members
            Called without object instantiation
            Commonly used for utility functions
    */
    static void printCount() {
        System.out.println("Total instances created: " + instanceCount);
        
        // Cannot access non-static members directly
        // System.out.println(instanceId); // ERROR!
    }
    // Instance method can access static members
    void printInfo() {
        System.out.println("Instance ID: " + instanceId +", Total instances: " + instanceCount);
    }

    /* 3. STATIC BLOCKS (Initialization Blocks)
                Executes when class loads (before any instances)
                Used for complex static initializations
                Runs only once per classloader
    */
    static {
        System.out.println("Static block runs FIRST when class loads");
        // Initialize complex static variables here
    }
    
    // Instance initializer block for comparison
    {
        instanceCount++;
        this.instanceId = instanceCount;
        System.out.println("Instance block runs per object creation");
    }

    /* 4. STATIC NESTED CLASSES
            Doesn't have access to outer class instance members
            Can be instantiated without outer class instance
            Behaves like a top-level class
    */
    static class NestedClass {
        void display() {
            System.out.println("Static nested class can only access static outer members: " + instanceCount);
        }
    }

    // ==============================================
    // 5. MAIN METHOD DEMONSTRATION
    // ==============================================
    public static void main(String[] args) {
        //Output: Static block runs FIRST when class loads
        
        // Access static variable without instance
        System.out.println("Initial instance count: " + StaticDemo.instanceCount);//Initial instance count: 0
                                                        //instanceCount
        // Call static method
        StaticDemo.printCount();//Total instances created: 0
        //or printCount()
        // Create instances
        StaticDemo obj1 = new StaticDemo();//Instance block runs per object creation
        StaticDemo obj2 = new StaticDemo();//Instance block runs per object creation
        
        // Verify counts
        obj1.printInfo();//Instance ID: 1, Total instances: 2
        obj2.printInfo();//Instance ID: 2, Total instances: 2
        StaticDemo.printCount();//Total instances created: 2
        
        // Use static nested class
        NestedClass nested = new NestedClass();
        nested.display();//Static nested class can only access static outer members: 2
        
        // Demonstrate static import (see below)
        double val = PI; // From static import
        System.out.println("Static import value: " + val);//Static import value: 3.141592653589793  
    }
}



/* 6. STATIC IMPORTS (Separate Section)
        Import specific static members
        Allows using them without class qualification
        Improves readability for constants/frequent utilities
*/
class Circle {
    double calculateArea(double radius) {
        return PI * radius * radius; // Using imported PI
    }
}