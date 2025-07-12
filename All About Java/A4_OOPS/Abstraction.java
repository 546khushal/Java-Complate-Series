/**
 * ABSTRACTION: Hiding complex implementation details.
        A class that is declared with abstract keyword is known as abstract class in java. It can have 
        abstract and non-abstract methods (method with body). It needs to be extended and its method 
        implemented. It cannot be instantiated.

Abstract Class ka matlab hai ek aisi class jo directly instantiate (object create) nahi ki ja sakti, 
matlab aap uska object nahi bana sakte. 
Iska kaam sirf ek blueprint provide karna hota hai, 
jisko subclasses (child classes) extend karke use karti hain
/**
 * ABSTRACT CLASS IN JAVA
 * ----------------------
 * 
 * Definition:
 * An abstract class is a restricted class that cannot be instantiated (cannot create objects directly).
 * It serves as a blueprint for other classes to inherit from.
 * 
 * Key Characteristics:
 * 1. Declared with 'abstract' keyword
 * 2. Can contain both abstract and concrete methods
 * 3. May have constructors (even though you can't instantiate it)
 * 4. Can have fields (variables) like regular classes
 * 
 * When to Use:
 * - When you want to share code among related classes
 * - When you need to declare non-static/non-final fields
 * - When you need to define common methods with some implementations
 */

// Abstract class example
abstract class Vehicle {
    // Abstract method (no implementation - must be overridden by subclasses)
    abstract void startEngine();
    
    // Concrete method (has implementation - can be used directly by subclasses)
    void stopEngine() {
        System.out.println("Engine stopped");
    }
    
    // Can have fields
    protected String vehicleType;
    
    // Can have constructor
    public Vehicle(String type) {
        this.vehicleType = type;
    }
    
    // Can have static methods
    static void displayVehicleInfo() {
        System.out.println("This is a vehicle class");
    }
}
//extend krne pr abstract method implememnt krna jruri hai yadi nhi krna to class bhi abstract krna jruri na hi object banayene
// Concrete class extending abstract class
class Car extends Vehicle {
    public Car() {
        super("Car"); // Calling abstract class constructor
    }
    
    @Override
    void startEngine() {
        System.out.println("Turning key to start car engine");
    }
}

class Bike extends Vehicle {
    public Bike() {
        super("Bike");
    }
    
    @Override
    void startEngine() {
        System.out.println("Kicking bike starter");
    }
    
    // Can also use inherited concrete method
    void demoStop() {
        stopEngine(); // Calling parent's concrete method
    }
}

public class Abstraction {
    public static void main(String[] args) {
        // Vehicle v = new Vehicle(); // ERROR: Can't instantiate abstract class
        
        Car myCar = new Car();
        myCar.startEngine();  // Output: Turning key to start car engine
        myCar.stopEngine();   // Output: Engine stopped
        
        Bike myBike = new Bike();
        myBike.startEngine(); // Output: Kicking bike starter
        myBike.demoStop();    // Output: Engine stopped
        
        // Accessing static method
        Vehicle.displayVehicleInfo(); // Output: This is a vehicle class
        
        // Polymorphism example
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Bike();
        
        vehicle1.startEngine(); // Output: Turning key to start car engine
        vehicle2.startEngine(); // Output: Kicking bike starter
    }
}