/* 
 * The 'final' keyword in Java is used to restrict the user.
 * 
 * Final can be applied to:
 *  1. Variables  -> cannot be reassigned
 *  2. Methods    -> cannot be overridden
 *  3. Classes    -> cannot be extended (inherited)
 */

public class FinalDemo {

    // ==================== 1. FINAL VARIABLES ====================

    // Instance constant: must be initialized when declared or in constructor
    final int instanceFinal=100;

    // Static constant: common convention is UPPER_SNAKE_CASE
    static final double PI = 3.14159;

    // Blank final variable: must be initialized in constructor
    final String blankFinal;

    // Final parameter example: cannot reassign inside method
    void logMessage(final String msg) {
        // msg = "changed"; // COMPILE ERROR: final parameter cannot be reassigned
        System.out.println("Log: " + msg);
    }

    // Constructor initializes the blank final
    FinalDemo() {
        blankFinal = "Initialized in constructor";
        //instanceFinal=100;
    }

    // ==================== 2. FINAL METHODS ====================

    // Final method: cannot be overridden in child classes
    final void criticalOperation() {
        System.out.println("This operation cannot be changed or overridden.");
    }

    // ==================== 3. FINAL CLASSES ====================

    // Final class: cannot be extended (no subclasses allowed)
    final class SecureData {
        final String secret = "Confidential"; // final variable: immutable once assigned

        void showSecret() {
            System.out.println("Secret is: " + secret);
        }
    }

    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo();

        // ----- Demonstrate final variables -----
        System.out.println("Instance final: " + demo.instanceFinal);
        System.out.println("Static final PI: " + PI);
        System.out.println("Blank final: " + demo.blankFinal);

        // demo.instanceFinal = 200; //  COMPILE ERROR: cannot change final variable

        // ----- Demonstrate final method -----
        demo.criticalOperation();

        // ----- Demonstrate final class -----
        SecureData data = demo.new SecureData();
        data.showSecret();

        // data.secret = "Hacked"; // COMPILE ERROR: final variable cannot be reassigned

        // ----- Demonstrate final parameter -----
        demo.logMessage("Hello world");
    }
}

// ==================== ILLEGAL OPERATIONS (WILL NOT COMPILE) ====================

// 1. Cannot extend a final class
// class Hacker extends FinalDemo.SecureData {} //  ERROR: SecureData is final

// 2. Cannot override a final method
// class Child extends FinalDemo {
//     @Override
//     void criticalOperation() {  // ERROR: method is final in parent
//         System.out.println("Trying to override...");
//     }
// }
