import java.util.ArrayList;
import java.util.Scanner;

// Custom Exceptions
class InvalidEmployeeIdException extends Exception {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}

class DuplicateEmployeeException extends Exception {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}

// Interface for Bonus Calculation
interface BonusEligible {
    double calculateBonus();
}

// Abstract Employee Class
abstract class Employee {
    private int empId;
    private String name;
    private String department;

    public Employee(int empId, String name, String department) {
        this.empId = empId;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Abstract method for salary calculation
    public abstract double calculateSalary();

    // Display employee details
    public void displayDetails() {
        System.out.println("ID: " + empId + ", Name: " + name + ", Department: " + department);
    }
}

// FullTimeEmployee Class
class FullTimeEmployee extends Employee implements BonusEligible {
    private double monthlySalary;

    public FullTimeEmployee(int empId, String name, String department, double monthlySalary) {
        super(empId, name, department);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.1; // 10% bonus
    }
}

// PartTimeEmployee Class
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int empId, String name, String department, double hourlyRate, int hoursWorked) {
        super(empId, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// EmployeeManager Class
class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee emp) throws DuplicateEmployeeException {
        if (searchEmployee(emp.getEmpId()) != null) {
            throw new DuplicateEmployeeException("Employee with ID " + emp.getEmpId() + " already exists.");
        }
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Update Employee
    public void updateEmployee(int empId, String name, String department) throws InvalidEmployeeIdException {
        Employee emp = searchEmployee(empId);
        if (emp == null) {
            throw new InvalidEmployeeIdException("Employee with ID " + empId + " not found.");
        }
        emp.setName(name);
        emp.setDepartment(department);
        System.out.println("Employee updated successfully.");
    }

    // Delete Employee
    public void deleteEmployee(int empId) throws InvalidEmployeeIdException {
        Employee emp = searchEmployee(empId);
        if (emp == null) {
            throw new InvalidEmployeeIdException("Employee with ID " + empId + " not found.");
        }
        employees.remove(emp);
        System.out.println("Employee deleted successfully.");
    }

    // Search Employee
    public Employee searchEmployee(int empId) {
        for (Employee emp : employees) {
            if (emp.getEmpId() == empId) {
                return emp;
            }
        }
        return null;
    }

    // Display All Employees
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employees) {
                emp.displayDetails();
                System.out.println("Salary: " + emp.calculateSalary());
                if (emp instanceof BonusEligible) {
                    System.out.println("Bonus: " + ((BonusEligible) emp).calculateBonus());
                }
                System.out.println("-----------------------------");
            }
        }
    }
}

// Main Class
public class EmpManagement {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display Menu
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Delete Employee");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        // Add Full-Time Employee
                        System.out.print("Enter Employee ID: ");
                        int ftId = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        scanner.nextLine(); // Consume newline
                        String ftName = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String ftDept = scanner.nextLine();
                        System.out.print("Enter Monthly Salary: ");
                        double ftSalary = scanner.nextDouble();
                        manager.addEmployee(new FullTimeEmployee(ftId, ftName, ftDept, ftSalary));
                        break;

                    case 2:
                        // Add Part-Time Employee
                        System.out.print("Enter Employee ID: ");
                        int ptId = scanner.nextInt();
                        System.out.print("Enter Name: ");
                        scanner.nextLine(); // Consume newline
                        String ptName = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String ptDept = scanner.nextLine();
                        System.out.print("Enter Hourly Rate: ");
                        double ptRate = scanner.nextDouble();
                        System.out.print("Enter Hours Worked: ");
                        int ptHours = scanner.nextInt();
                        manager.addEmployee(new PartTimeEmployee(ptId, ptName, ptDept, ptRate, ptHours));
                        break;

                    case 3:
                        // Update Employee
                        System.out.print("Enter Employee ID to update: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter New Name: ");
                        scanner.nextLine(); // Consume newline
                        String newName = scanner.nextLine();
                        System.out.print("Enter New Department: ");
                        String newDept = scanner.nextLine();
                        manager.updateEmployee(updateId, newName, newDept);
                        break;

                    case 4:
                        // Search Employee
                        System.out.print("Enter Employee ID to search: ");
                        int searchId = scanner.nextInt();
                        Employee emp = manager.searchEmployee(searchId);
                        if (emp != null) {
                            emp.displayDetails();
                            System.out.println("Salary: " + emp.calculateSalary());
                            if (emp instanceof BonusEligible) {
                                System.out.println("Bonus: " + ((BonusEligible) emp).calculateBonus());
                            }
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 5:
                        // Display All Employees
                        manager.displayAllEmployees();
                        break;

                    case 6:
                        // Delete Employee
                        System.out.print("Enter Employee ID to delete: ");
                        int deleteId = scanner.nextInt();
                        manager.deleteEmployee(deleteId);
                        break;

                    case 7:
                        // Exit
                        System.out.println("Exiting Employee Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InvalidEmployeeIdException | DuplicateEmployeeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 7);

        scanner.close();
    }
}