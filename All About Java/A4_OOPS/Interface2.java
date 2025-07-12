/**
 * COMPLETE JAVA INTERFACE DEMONSTRATION
 * Covers all 9 key interface features:
 * 1. Abstract methods
 * 2. Constants
 * 3. Default methods (Java 8+)
 * 4. Static methods (Java 8+)
 * 5. Private methods (Java 9+)
 * 6. Multiple inheritance
 * 7. Functional interfaces
 * 8. Marker interfaces
 * 9. Nested interfaces
 */

public class InterfaceDemo {

    // ==============================================
    // 1. ABSTRACT METHODS (Implicitly public)
    // ==============================================
    interface Connectable {
        void connect(); // Abstract method (no body)
    }

    // ==============================================
    // 2. CONSTANT VARIABLES (public static final)
    // ==============================================
    interface Constants {
        String DEFAULT_PROTOCOL = "HTTPS"; // Constant
        int MAX_CONNECTIONS = 100;         // Constant
    }

    // ==============================================
    // 3. DEFAULT METHODS (Java 8+)
    // ==============================================
    interface Loggable {
        default void log(String message) {
            System.out.println("LOG: " + message);
            // For Java 8, we can't use private methods, so we inline the code
            System.out.println("[DEBUG] Operation logged");
        }
    }

    // ==============================================
    // 4. STATIC METHODS (Java 8+)
    // ==============================================
    interface Validator {
        static boolean isValid(String input) {
            return input != null && !input.isEmpty();
        }
    }

    // ==============================================
    // 5. PRIVATE METHODS (Commented out for Java 8)
    // ==============================================
    interface Secure {
        default void encryptData(String data) {
            // validate(data); // Private method commented out
            if (data == null) throw new IllegalArgumentException(); // Inlined validation
            System.out.println("Encrypting: " + data);
        }
        
        /* Java 9+ private method - commented out
        private void validate(String data) {
            if (data == null) throw new IllegalArgumentException();
        }
        */
    }

    // ==============================================
    // 6. MULTIPLE INHERITANCE DEMO
    // ==============================================
    static class SmartDevice implements Connectable, Loggable, Secure {
        @Override
        public void connect() {
            log("Device connected");
            encryptData("sensitive data");
        }
    }

    // ==============================================
    // 7. FUNCTIONAL INTERFACE (Single Abstract Method)
    // ==============================================
    @FunctionalInterface
    interface Transformer {
        String transform(String input);
        
        default void printTransformed(String input) {
            System.out.println(transform(input));
        }
    }

    // ==============================================
    // 8. MARKER INTERFACE (No methods)
    // ==============================================
    interface Serializable { } // Example: java.io.Serializable

    // ==============================================
    // 9. NESTED INTERFACES
    // ==============================================
    interface Vehicle {
        interface Engine {
            void start();
        }
        
        interface Wheel {
            void rotate();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== JAVA INTERFACE DEMONSTRATION ===");

        // 1. Abstract method implementation
        Connectable device = new SmartDevice();
        device.connect(); 
        /* Output:
           LOG: Device connected
           [DEBUG] Operation logged
           Encrypting: sensitive data
        */

        // 2. Accessing constants
        System.out.println("Default protocol: " + Constants.DEFAULT_PROTOCOL); 
        // Output: Default protocol: HTTPS

        // 3. Default method usage
        new SmartDevice().log("Test message"); 
        /* Output:
           LOG: Test message
           [DEBUG] Operation logged
        */

        // 4. Static method call
        System.out.println("Is valid? " + Validator.isValid("test")); 
        // Output: Is valid? true

        // 5. "Private" method simulation
        new SmartDevice().encryptData("private data"); 
        // Output: Encrypting: private data

        // 6. Multiple inheritance demo
        SmartDevice multi = new SmartDevice();
        multi.connect();
        /* Output:
           LOG: Device connected
           [DEBUG] Operation logged
           Encrypting: sensitive data
        */

        // 7. Functional interface with lambda
        Transformer upperCase = String::toUpperCase;
        System.out.println(upperCase.transform("hello")); 
        // Output: HELLO

        // 8. Marker interface usage
        class Data implements Serializable { }
        System.out.println("Marker interface implemented"); 
        // Output: Marker interface implemented

        // 9. Nested interface implementation
        class CarEngine implements Vehicle.Engine {
            public void start() {
                System.out.println("Engine started");
            }
        }
        new CarEngine().start(); 
        // Output: Engine started
    }
}