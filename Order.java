import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private List<MenuItem> items = new ArrayList<>();
    private double totalAmount;

    // Constructor
    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public List<MenuItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }

    public void addItem(MenuItem item) {
        items.add(item);
        calculateTotal();
    }

    public void removeItem(int itemId) {
        items.removeIf(i -> i.getItemId() == itemId);
        calculateTotal();
    }

    public void calculateTotal() {
        totalAmount = 0;
        for (MenuItem item : items) {
            totalAmount += item.getPrice() + item.calculateTax();
        }
    }

    public void placeOrder() {
        System.out.println("Order placed for " + customerName + ". Total: $" + totalAmount);
        // Integrate with DB if needed (e.g., save order details)
    }
}