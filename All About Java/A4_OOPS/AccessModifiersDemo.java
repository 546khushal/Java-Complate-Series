
/*
Modifier	Class	Package	Subclass (Same PKG)	Subclass (Diff PKG)	World
public	    Yes	    Yes	    Yes	                Yes	                Yes
protected	Yes	    Yes	    Yes	                Yes (Inheritance)	No
default	    Yes	    Yes	    Yes	                No	                No
private	    Yes	    No	    No	                No                  No    
*/


//DEFAULT CLASS (Accessible only in same package)
class TestClass {
    // Public (Accessible everywhere)
    public int publicVar = 10;
    public void publicMethod() {
        System.out.println("Public Method");
    }

    //Protected (Accessible in same package + subclasses)
    protected int protectedVar = 20;
    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    //Default (Accessible only in same package)
    int defaultVar = 30;
    void defaultMethod() {
        System.out.println("Default Method");
    }

    //Private (Accessible only within same class)
    private int privateVar = 40;
    private void privateMethod() {
        System.out.println("Private Method");
    }
    
    // PUBLIC GETTER (to read privateVar)
    public int getPrivateVar() {
        return privateVar;
    }

    //  PUBLIC SETTER (to modify privateVar)
    public void setPrivateVar(int newValue) {
        privateVar = newValue;
    }

    //  PUBLIC METHOD to expose privateMethod()
    public void callPrivateMethod() {
        privateMethod(); // Calls the private method safely
    }
}


//PUBLIC CLASS (Accessible everywhere)
public class AccessModifiersDemo {
    public static void main(String[] args) {
        TestClass obj = new TestClass();

        // Accessing public members (Allowed)
        System.out.println(obj.publicVar);
        obj.publicMethod();

        // Accessing default members (Same package - Allowed)
        System.out.println(obj.defaultVar);
        obj.defaultMethod();

        // Accessing protected members (Same package - Allowed)
        System.out.println(obj.protectedVar);
        obj.protectedMethod();

        //  Accessing private members (Not allowed outside class)
        // System.out.println(obj.privateVar); // ERROR!
        // obj.privateMethod(); // ERROR!

        // SAFE ACCESS VIA GETTERS/SETTERS
        System.out.println("Original PrivateVar: " + obj.getPrivateVar()); // 40
        obj.setPrivateVar(99); // Modify privateVar
        System.out.println("Updated PrivateVar: " + obj.getPrivateVar()); // 99

        // CALLING PRIVATE METHOD VIA PUBLIC WRAPPER
        obj.callPrivateMethod(); // Output: "Private Method"
    }
}

