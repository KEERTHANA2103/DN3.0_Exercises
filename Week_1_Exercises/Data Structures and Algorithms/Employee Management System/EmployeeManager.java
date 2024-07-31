import java.util.Arrays;

public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full, cannot add more employees.");
        }
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        // Example usage
        EmployeeManager manager = new EmployeeManager(5);

        // Adding employees
        manager.addEmployee(new Employee("E1", "Jason Brown", "Developer", 75000));
        manager.addEmployee(new Employee("E2", "Jenna Ortega", "HR", 65000));
        manager.addEmployee(new Employee("E3", "Sheldon Cooper", "Manager", 55000));

        // Traversing employees
        System.out.println("All Employees:");
        manager.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for employee E2:");
        Employee emp = manager.searchEmployee("E2");
        System.out.println(emp);

        // Deleting an employee
        System.out.println("\nDeleting employee E1:");
        manager.deleteEmployee("E1");

        // Traversing employees again
        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}