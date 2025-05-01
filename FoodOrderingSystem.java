// Abstract Food Class
abstract class Food {
    private String foodName;
    private String customerName;
    private double price;

    // Constructor
    public Food(String foodName, String customerName, double price) {
        this.foodName = foodName;
        this.customerName = customerName;
        this.price = price;
    }

    // Getters
    public String getFoodName() {
        return foodName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getPrice() {
        return price;
    }

    // Abstract Method
    public abstract void displayDetails();
}

// JainFood Class (Inherits Food)
class JainFood extends Food {
    private boolean isJain;

    // Constructor
    public JainFood(String foodName, String customerName, double price, boolean isJain) {
        super(foodName, customerName, price); // Call superclass constructor
        this.isJain = isJain;
    }

    // Method Override
    @Override
    public void displayDetails() {
        System.out.println("Food Name: " + getFoodName());
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("Price: " + getPrice());
        System.out.println("Is Jain: " + (isJain ? "Yes" : "No"));
    }
}

// Main Class
public class FoodOrderingSystem {
    public static void main(String[] args) {
        // Create JainFood object
        JainFood food1 = new JainFood("Paneer Tikka", "John Doe", 250.0, true);
        JainFood food2 = new JainFood("Chicken Biryani", "Jane Doe", 300.0, false);

        // Display food details
        System.out.println("Food 1 Details:");
        food1.displayDetails();

        System.out.println("\nFood 2 Details:");
        food2.displayDetails();
    }
}