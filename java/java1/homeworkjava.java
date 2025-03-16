import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
abstract class StaffMember {
    protected int id;
    protected String name;
    protected String address;
    public StaffMember(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public abstract double pay();
}
class Volunteer extends StaffMember {
    private double salary = 0.0;

    public Volunteer(int id, String name, String address) {
        super(id, name, address);
    }
    @Override
    public double pay() {
        return 0.0;
    }
    @Override
    public String toString() {
        return "Volunteer [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
    }
}
class HourlyEmployee extends StaffMember {
    private int hoursWorked;
    private double rate;

    public HourlyEmployee(int id, String name, String address, int hoursWorked, double rate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    @Override
    public double pay() {
        return hoursWorked * rate;
    }
    @Override
    public String toString() {
        return "HourlyEmployee [id=" + id + ", name=" + name + ", address=" + address +
                ", hoursWorked=" + hoursWorked + ", rate=" + rate + ", pay=" + pay() + "]";
    }
}
class SalariedEmployee extends StaffMember {
    private double salary;
    private double bonus;
    public SalariedEmployee(int id, String name, String address, double salary, double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    @Override
    public double pay() {
        return salary + bonus;
    }
    @Override
    public String toString() {
        return "SalariedEmployee [id=" + id + ", name=" + name + ", address=" + address +
                ", salary=" + salary + ", bonus=" + bonus + ", pay=" + pay() + "]";
    }
}
public class EmployeeManagementSystem {
    private static List<StaffMember> staffList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        staffList.add(new Volunteer(1, "nimol", "PP"));
        staffList.add(new Volunteer(4, "vichecka", "pp"));
        staffList.add(new HourlyEmployee(3, "Sokha", "ks", 60, 10.0));
        staffList.add(new SalariedEmployee(5, "liv", "kS", 300.0, 20.0));
        staffList.add(new SalariedEmployee(2, "korng", "PP", 300.0, 10.0));
        staffList.add(new HourlyEmployee(6, "chan", "kk", 50, 10.0));
        boolean running = true;
        while (running) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    private static void insertEmployee() {
        System.out.println("\nInsert Employee:");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Type (1: Volunteer, 2: HourlyEmployee, 3: SalariedEmployee): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        switch (type) {
            case 1:
                staffList.add(new Volunteer(id, name, address));
                System.out.println("Volunteer added successfully.");
                break;
            case 2:
                System.out.print("Enter Hours Worked: ");
                int hoursWorked = scanner.nextInt();
                System.out.print("Enter Rate: ");
                double rate = scanner.nextDouble();
                staffList.add(new HourlyEmployee(id, name, address, hoursWorked, rate));
                System.out.println("Hourly Employee added successfully.");
                break;
            case 3:
                System.out.print("Enter Salary: ");
                double salary = scanner.nextDouble();
                System.out.print("Enter Bonus: ");
                double bonus = scanner.nextDouble();
                staffList.add(new SalariedEmployee(id, name, address, salary, bonus));
                System.out.println("Salaried Employee added successfully.");
                break;
            default:
                System.out.println("Invalid type.");
        }
    }
    private static void displayAllEmployees() {
        System.out.println("\nAll Employees:");
        if (staffList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            staffList.stream().forEach(System.out::println);
        }
    }
    private static void updateEmployee() {
        System.out.print("\nEnter ID of employee to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (StaffMember staff : staffList) {
            if (staff.getId() == id) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                staff.setName(name);
                System.out.print("Enter new Address: ");
                String address = scanner.nextLine();
                staff.setAddress(address);
                if (staff instanceof HourlyEmployee) {
                    HourlyEmployee he = (HourlyEmployee) staff;
                    System.out.print("Enter new Hours Worked: ");
                    int hoursWorked = scanner.nextInt();
                    he.setHoursWorked(hoursWorked);
                    System.out.print("Enter new Rate: ");
                    double rate = scanner.nextDouble();
                    he.setRate(rate);
                } else if (staff instanceof SalariedEmployee) {
                    SalariedEmployee se = (SalariedEmployee) staff;
                    System.out.print("Enter new Salary: ");
                    double salary = scanner.nextDouble();
                    se.setSalary(salary);
                    System.out.print("Enter new Bonus: ");
                    double bonus = scanner.nextDouble();
                    se.setBonus(bonus);
                }
                scanner.nextLine(); 
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    private static void removeEmployee() {
        System.out.print("\nEnter ID of employee to remove: ");
        try {
            int employeeIdToRemove = scanner.nextInt();
            scanner.nextLine();
            if (employeeIdToRemove <= 0) {
                System.out.println("Invalid ID. Please enter a positive integer.");
                return;
            }
            boolean wasEmployeeRemoved = false;
            for (int i = 0; i < staffList.size(); i++) {
                if (staffList.get(i).getId() == employeeIdToRemove) {
                    staffList.remove(i);
                    wasEmployeeRemoved = true;
                    break;
                }
            }
            if (wasEmployeeRemoved) {
                System.out.println("Employee removed successfully.");
            } else {
                System.out.println("Employee not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer ID.");
            scanner.nextLine();
        }
    }
}