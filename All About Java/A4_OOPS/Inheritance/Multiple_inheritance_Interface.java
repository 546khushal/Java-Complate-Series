
/**
 * MULTIPLE INHERITANCE USING INTERFACES
 * -------------------------------------
 * Java doesn't support multiple inheritance with classes due to the "Diamond Problem",
 * but it can be achieved using interfaces because:
 * 1. Interfaces contain only abstract methods (no implementation)
 * 2. No ambiguity since implementation is provided by the class
 * 
 * Key Points:
 * - A class can implement multiple interfaces
 * - Must provide implementation for all interface methods
 * - No conflict even if methods have same name (unlike classes)
 */
 
// First interface
interface Printable {
    void print();  // Abstract method (no body)
}

// Second interface
interface Showable {
    void show();   // Abstract method (no body)
}

// Class implementing both interfaces
class Multiple_inheritance_Interface implements Printable, Showable {
    // Implementing Printable's method
    public void print() {
        System.out.println("Printing document...");
    }
    
    // Implementing Showable's method
    public void show() {
        System.out.println("Displaying content...");
    }
    
    // Additional method specific to this class
    public void log() {
        System.out.println("Logging activity...");
    }

    public static void main(String args[]) {
        Multiple_inheritance_Interface obj = new Multiple_inheritance_Interface();
        
        // Calling interface methods
        obj.print();  // Output: Printing document...
        obj.show();   // Output: Displaying content...
        
        // Calling class-specific method
        obj.log();    // Output: Logging activity...
        
        // Polymorphism with interfaces
        Printable p = obj;
        p.print();    // Same output
        
        Showable s = obj;
        s.show();     // Same output
    }
}

/**Printing document...
Displaying content...
Logging activity...
Printing document...
Displaying content... */