public class Employee {

    private String id;
    private String name;
    private String email;
    private double totalSales;

    public Employee(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.totalSales = 0.0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void addSale(double amount) {
        totalSales += amount;
    }

}
