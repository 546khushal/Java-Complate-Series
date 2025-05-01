/*in day-5 program (Desirable Assignment section) add an interface IEmp with getDetails and 
showDetails as two abstract functions. Implement this interface on Emp class. Other coding will be 
same. Check working of the interface concept. */
interface IEmp {
    String getDetails();
    void showDetails();
}

abstract class Emp implements IEmp {
    private int id;
    private String name;
    private int age;

    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }

    @Override
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
    public String getDetails() {
        return super.getDetails() + ", Basic Pay: " + basicPay + ", DA: " + DA;
    }
}

public class day7_3 {
    public static void main(String[] args) {
        IEmp emp1 = new PartTimeEmp(101, "Alice", 25, 20, 50.0);
        IEmp emp2 = new FullTimeEmp(102, "Bob", 30, 50000, 10000);

        System.out.println("Part-Time Employee Details:");
        emp1.showDetails();

        System.out.println("\nFull-Time Employee Details:");
        emp2.showDetails();
    }
}
