/*The final keyword in java is used to restrict the user. The java final keyword can be used in many context. 
Final can be: 
 
1. variable 
2. method 
3. class */
public class FinalDemo {

    // ========== 1. final VARIABLES ==========
    
    // Instance constant (must be initialized)
    final int instanceFinal = 100;
    
    // Static constant (UPPER_SNAKE_CASE naming)
    static final double PI = 3.14159;
    
    // Blank final variable (initialized in constructor)
    final String blankFinal;
    
    // Final parameter example
    void logMessage(final String msg) {
        // msg = "changed"; // COMPILE ERROR - cannot modify final parameter
        System.out.println(msg);
    }

    // Constructor initializes blank final
    FinalDemo() {
        blankFinal = "Initialized in constructor";
    }

    // ========== 2. final METHODS ==========
    final void criticalOperation() {
        System.out.println("This operation cannot be changed");
    }

    // ========== 3. final CLASSES ==========
    final class SecureData {
        final String secret = "Confidential";
        
        void showSecret() {
            System.out.println(secret);
        }
    }

    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo();
        
        // 1. Demo final variables
        System.out.println("Instance final: " + demo.instanceFinal);
        System.out.println("Static final PI: " + PI);
        System.out.println("Blank final: " + demo.blankFinal);
        
        // demo.instanceFinal = 200; // COMPILE ERROR
        
        // 2. Demo final method
        demo.criticalOperation();
        
        // 3. Demo final class
        SecureData data = demo.new SecureData();
        data.showSecret();
        
        // data.secret = "Hacked"; // COMPILE ERROR
        
        // Demo final parameter
        demo.logMessage("Hello world");
    }
}

// Attempting to extend final class would fail:
// class Hacker extends SecureData {} // COMPILE ERROR

// Attempting to override final method would fail:
// class Child extends FinalDemo {
//     void criticalOperation() {} // COMPILE ERROR
// }