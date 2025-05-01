
/*In the day-5 program, create object / reference of Emp class which will point to any of the child class. 
Call the getDetails and showDetails methods and check working of polymorphism.  */


// Demonstrating Polymorphism and Abstract Classes in Emp hierarchy
abstract class Emp {
    private int id;
    private String name;
    private int age;

    // Parameterized constructor
    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Abstract method for calculating salary
    public abstract double calculateSalary();

    // Get details method
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }

    // Show details method
    public void showDetails() {
        System.out.println(getDetails());
    }
}

class PartTimeEmp extends Emp {
    private int numberOfHours;
    private double ratePerHour;

    public PartTimeEmp(int id, String name, int age, int numberOfHours, double ratePerHour) {
        super(id, name, age);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSalary() {
        return numberOfHours * ratePerHour;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Hours: " + numberOfHours + ", Rate: " + ratePerHour;
    }
}

class FullTimeEmp extends Emp {
    private double basicPay;
    private double DA;

    public FullTimeEmp(int id, String name, int age, double basicPay, double DA) {
        super(id, name, age);
        this.basicPay = basicPay;
        this.DA = DA;
    }

    @Override
    public double calculateSalary() {
        return basicPay + DA;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Basic Pay: " + basicPay + ", DA: " + DA;
    }
}

public class day6_1 {
    public static void main(String[] args) {
        // Using Emp reference to point to child classes
        Emp emp1 = new PartTimeEmp(101, "Alice", 25, 20, 50.0);
        Emp emp2 = new FullTimeEmp(102, "Bob", 30, 50000, 10000);

        System.out.println("Part-Time Employee Details:");
        emp1.showDetails();
        System.out.println("Salary: " + emp1.calculateSalary());

        System.out.println("\nFull-Time Employee Details:");
        emp2.showDetails();
        System.out.println("Salary: " + emp2.calculateSalary());

        // Uncommenting the following line will cause an error because Emp is abstract
        // Emp emp = new Emp(103, "Charlie", 28);
    }
}
