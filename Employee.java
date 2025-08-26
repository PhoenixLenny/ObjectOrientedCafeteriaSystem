public class Employee {
    private int employeeId;
    private String name;
    private String role;

    // Constructor
    public Employee(int employeeId, String name, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getRole() { return role; }

    public void processOrder(Order order) {
        if (role.equals("Cashier")) {
            order.placeOrder();
        } else if (role.equals("Chef")) {
            for (MenuItem item : order.getItems()) {
                if (item instanceof FoodItem) {
                    ((FoodItem) item).prepare();
                } else if (item instanceof Beverage) {
                    ((Beverage) item).serve();
                }
            }
        }
    }

    public void updateMenu(MenuItem item) {
        // Proxy to DB update
        DatabaseManager.updateMenuItem(item);
    }
}