// Employee Hierarchy with PartTimeEmp and FullTimeEmp classes
class Emp {
    private int id;
    private String name;
    private int age;

    // Default constructor
    public Emp() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Get details
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }

    // Show details
    public void showDetails() {
        System.out.println(getDetails());
    }
}

// PartTimeEmp inherits Emp
class PartTimeEmp extends Emp {
    private int numberOfHours;
    private double ratePerHour;

    // Default constructor
    public PartTimeEmp() {
        super();
        this.numberOfHours = 0;
        this.ratePerHour = 0.0;
    }

    // Parameterized constructor
    public PartTimeEmp(int id, String name, int age, int numberOfHours, double ratePerHour) {
        super(id, name, age);
        this.numberOfHours = numberOfHours;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Hours: " + numberOfHours + ", Rate: " + ratePerHour;
    }
}

// FullTimeEmp inherits Emp
class FullTimeEmp extends Emp {
    private double basicPay;
    private double DA;

    // Default constructor
    public FullTimeEmp() {
        super();
        this.basicPay = 0.0;
        this.DA = 0.0;
    }

    // Parameterized constructor
    public FullTimeEmp(int id, String name, int age, double basicPay, double DA) {
        super(id, name, age);
        this.basicPay = basicPay;
        this.DA = DA;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Basic Pay: " + basicPay + ", DA: " + DA;
    }
}

public class day5_1 {
    public static void main(String[] args) {
        PartTimeEmp partTimeEmp = new PartTimeEmp(101, "Alice", 25, 20, 50.0);
        FullTimeEmp fullTimeEmp = new FullTimeEmp(102, "Bob", 30, 50000, 10000);

        System.out.println("Part-Time Employee Details:");
        partTimeEmp.showDetails();

        System.out.println("\nFull-Time Employee Details:");
        fullTimeEmp.showDetails();
    }
}
