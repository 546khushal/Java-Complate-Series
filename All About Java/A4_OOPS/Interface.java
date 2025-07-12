/**
 * INTERFACE: Pure abstraction blueprint.
 
     An interface in java is a blueprint of a class. It has static constants and abstract methods. 

     Java mein, Interface ek special type ka structure hai jo sirf methods aur constants ko define karta hai. 
     Iska main kaam ek blueprint ya contract provide karna hota hai jo kisi 
     class ko implement karna padta hai. Interface ek tarah ka design hai jo classes ke beech ek agreement banata 
     hai ki kaunse methods implement karne hain.
 
  * Key Characteristics:
 * 1. Pure abstraction (before Java 8)
 * 2. Implements the "programming to interfaces" principle
 * 3. Supports multiple inheritance
 * 
 * Rules:
 * 1. All methods are public abstract by default
 * 2. All variables are public static final (constants)
 * 3. Cannot have constructors
 * 4. Cannot be instantiated directly
 * 
* Key Features Demonstrated:
 * 1. Abstract methods (implicitly public)
 * 2. Constant variables (public static final)
 * 3. Default methods (Java 8+)
 * 4. Static methods (Java 8+)
 * 5. Private methods (Java 9+)
 * 6. Multiple inheritance
 * 7. Functional interfaces
 * 8. Marker interfaces
 * 9. Nested interfaces
 */


// ==============================================
// 1. BASIC INTERFACE STRUCTURE
// ==============================================
interface StorageDevice {
    // (1)Abstract method - MUST be implemented by classes
    void connect();  // public abstract is implicit
    
    //(2) Constant field - implicitly public static final
    String INTERFACE_TYPE = "USB";
    
    // (3)Default method - provides implementation
    default void displayType() {
        System.out.println("Storage type: " + INTERFACE_TYPE);
        //log("Displayed device type"); // Using private method
    }
    
    // (4)Static method - called on interface itself
    static boolean isPlugAndPlay() {
        return true;
    }
    
    // (5)Private method - helper method (Java 9+)
    // private void log(String message) {
    //     System.out.println("Log: " + message);
    // }
}

// ==============================================
// 2. (6)FUNCTIONAL INTERFACE (Single Abstract Method)
// ==============================================
@FunctionalInterface  // Ensures single abstract method
interface DataTransfer {
    // Single abstract method
    void transfer(String data);
    
    // Can have multiple default methods
    default void startTransfer() {
        System.out.println("Transfer initiated");
    }
    
    // Can have static methods
    static String getProtocol() {
        return "TCP/IP";
    }
}

// ==============================================
// 3. IMPLEMENTING CLASSES
// ==============================================
class FlashDrive implements StorageDevice {
    @Override
    public void connect() {
        System.out.println("FlashDrive connected via " + StorageDevice.INTERFACE_TYPE);
    }
    
    // Can override default method (optional)
    @Override
    public void displayType() {
        System.out.print("FlashDrive ");
        StorageDevice.super.displayType(); // Call interface's default
    }
}
//(7)Multiple Inheritance 
class ExternalSSD implements StorageDevice, DataTransfer {
    @Override
    public void connect() {
        System.out.println("SSD connected via " + StorageDevice.INTERFACE_TYPE);
    }
    
    @Override
    public void transfer(String data) {
        System.out.println("Transferring: " + data);
    }
}

// ==============================================
// 4. MAIN DEMONSTRATION CLASS
// ==============================================
public class Interface {
    public static void main(String[] args) {
        System.out.println("=== STORAGE DEVICE DEMO ===");
        
        // Basic interface usage
        StorageDevice flash = new FlashDrive();
                 // Calls implemented method
                flash.connect();       //Output: FlashDrive connected via USB
                // Calls overridden default method
                flash.displayType();    //Output: FlashDrive Storage type: USB

        
        // Static method call
        System.out.println("Plug and play? " + StorageDevice.isPlugAndPlay());//Output: Plug and play? true
        
        // Multiple interface implementation
        ExternalSSD ssd = new ExternalSSD();
                // From StorageDevice
                ssd.connect();      //Output: SSD connected via USB
                // From DataTransfer
                ssd.startTransfer();  //Output: Transfer initiated 
                ssd.transfer("4K Video File");//Output: Transferring: 4K Video File
                
        // Functional interface with lambda
        DataTransfer quickTransfer = data -> 
            System.out.println("Quick transfer: " + data);//Output: Quick transfer: Small file
            quickTransfer.transfer("Small file");
        
        // Accessing constant
        System.out.println("Interface type constant: " + StorageDevice.INTERFACE_TYPE);//Output: Interface type constant: USB
    }
}