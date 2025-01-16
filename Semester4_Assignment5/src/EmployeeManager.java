import java.util.*;

public class EmployeeManager {

    private Map<String, Employee> employees;
    private Map<String, List<Transaction>> transactions;

    public EmployeeManager() {
        employees = new HashMap<>();
        transactions = new HashMap<>();
    }

    public void addEmployee(String id, String name, String email) {
        employees.put(id, new Employee(id, name, email));
        transactions.put(id, new ArrayList<>());
    }

    public void recordSale(String employeeId, double amount, String movieTitle, Transaction.Type type) {
        Employee employee = employees.get(employeeId);
        if (employee != null) {
            employee.addSale(amount);
            transactions.get(employeeId).add(new Transaction(type, amount, movieTitle));
        }
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void displaySalesReport() {
        System.out.println("Sales Report:");
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            String employeeId = entry.getKey();
            Employee employee = entry.getValue();
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Total Sales: " + employee.getTotalSales());

            List<Transaction> employeeTransactions = transactions.get(employeeId);
            System.out.println("Transactions:");
            for (Transaction transaction : employeeTransactions) {
                System.out.println("Type: " + transaction.getType());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Movie Title: " + transaction.getMovieTitle());
            }
            System.out.println();
        }
    }
}