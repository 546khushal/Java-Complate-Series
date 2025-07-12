/**
 * POLYMORPHISM: Same operation performed in different ways.
 *
    *When one task is performed by different ways i.e. known as polymorphism. For example: to 
    convince the customer differently, to draw something e.g. shape or rectangle etc. 
    
    In java, we use method overloading and method overriding to achieve polymorphism. 

 * Two Types:
 * 1. Compile-time (Method Overloading)
          Polymorphism resolved during compilation based on method signatures.
          Mehtod Overloading: fun same name,diff parameters 
 * 2. Runtime (Method Overriding)
           Polymorphism resolved during execution based on actual object type. 
            Rules for Java Method Overriding 
                    1. method must have same name as in the parent class 
                    2. method must have same parameter as in the parent class. 
                    3. must be IS-A relationship (inheritance).  

 */
class Calculator {
    // Method Overloading (Compile-time)
    int add(int a, int b) {
        return a + b;
    }
    
    double add(double a, double b) {
        return a + b;
    }
}

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    // Method Overriding (Runtime)
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // Compile-time Example
        Calculator calc = new Calculator();
        System.out.println(calc.add(2,3));
        System.out.println(calc.add(2.5,3.5));
        
        // Runtime Example
        Animal a = new Cat();
        a.sound(); // Output: Meow
    }
}