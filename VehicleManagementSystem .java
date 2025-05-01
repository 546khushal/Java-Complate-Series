// Abstract Vehicle Class
abstract class Vehicle {
    private String vehicleNumber;
    private String brand;
    private double price;

    // Constructor
    public Vehicle(String vehicleNumber, String brand, double price) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.price = price;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    // Abstract Method for Maintenance Cost
    public abstract double calculateMaintenanceCost();

    // Display Vehicle Details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }
}

// Car Class (Inherits Vehicle)
class Car extends Vehicle {
    private int numberOfSeats;
    private double mileage; // in km/l

    // Constructor
    public Car(String vehicleNumber, String brand, double price, int numberOfSeats, double mileage) {
        super(vehicleNumber, brand, price); // Call superclass constructor
        this.numberOfSeats = numberOfSeats;
        this.mileage = mileage;
    }

    // Method to calculate maintenance cost
    @Override
    public double calculateMaintenanceCost() {
        // Maintenance cost formula for cars: (10000 / mileage) * 100
        return (10000 / mileage) * 100;
    }

    // Display Car Details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call superclass method
        System.out.println("Type: Car");
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Mileage: " + mileage + " km/l");
        System.out.println("Maintenance Cost: " + calculateMaintenanceCost());
    }
}

// Bike Class (Inherits Vehicle)
class Bike extends Vehicle {
    private double mileage; // in km/l

    // Constructor
    public Bike(String vehicleNumber, String brand, double price, double mileage) {
        super(vehicleNumber, brand, price); // Call superclass constructor
        this.mileage = mileage;
    }

    // Method to calculate maintenance cost
    @Override
    public double calculateMaintenanceCost() {
        // Maintenance cost formula for bikes: (5000 / mileage) * 50
        return (5000 / mileage) * 50;
    }

    // Display Bike Details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call superclass method
        System.out.println("Type: Bike");
        System.out.println("Mileage: " + mileage + " km/l");
        System.out.println("Maintenance Cost: " + calculateMaintenanceCost());
    }
}

// Main Class
public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Create Car object
        Vehicle car = new Car("DL123", "Toyota", 1500000, 5, 15.5);
        System.out.println("Car Details:");
        car.displayDetails();

        // Create Bike object
        Vehicle bike = new Bike("DL456", "Honda", 80000, 50.5);
        System.out.println("\nBike Details:");
        bike.displayDetails();
    }
}