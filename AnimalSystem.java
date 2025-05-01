// Abstract Animal Class
abstract class Animal {
    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Abstract Method
    public abstract void displayDetails();
}

// Dog Class (Inherits Animal)
class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age); // Call superclass constructor
        this.breed = breed;
    }

    // Method Override
    @Override
    public void displayDetails() {
        System.out.println("Animal Type: Dog");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Breed: " + breed);
    }
}

// Cat Class (Inherits Animal)
class Cat extends Animal {
    private String color;

    // Constructor
    public Cat(String name, int age, String color) {
        super(name, age); // Call superclass constructor
        this.color = color;
    }

    // Method Override
    @Override
    public void displayDetails() {
        System.out.println("Animal Type: Cat");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Color: " + color);
    }
}

// Main Class
public class AnimalSystem {
    public static void main(String[] args) {
        // Create Dog object
        Animal dog = new Dog("Buddy", 3, "Golden Retriever");
        dog.displayDetails();

        // Create Cat object
        Animal cat = new Cat("Whiskers", 2, "White");
        cat.displayDetails();
    }
}