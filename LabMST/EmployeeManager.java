import java.util.HashMap;
import java.util.Map;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

public class EmployeeManager {
    private Map<Integer, String> employeeMap;

    public EmployeeManager() {
        employeeMap = new HashMap<>();
    }

    public void addEmployee(int id, String name) {
        employeeMap.put(id, name);
    }

    public String getEmployeeName(int id) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        } else {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(101, "Kartik");
        manager.addEmployee(102, "Rahul");
        try {
            System.out.println("Employee with ID 101: " + manager.getEmployeeName(101));
            System.out.println("Employee with ID 103: " + manager.getEmployeeName(103));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
