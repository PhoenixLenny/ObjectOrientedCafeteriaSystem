public class Main {
    public static void main(String[] args) {
        DatabaseManager.createMenuItem("Burger", 5.99, "Tasty burger", "Food");
        DatabaseManager.readMenuItems();
        FoodItem burger = new FoodItem(1, "Burger", 6.99, "Updated burger", 500, true);
        DatabaseManager.updateMenuItem(burger);
        DatabaseManager.readMenuItems();
        DatabaseManager.deleteMenuItem(1);

        FoodItem pizza = new FoodItem(2, "Pizza", 8.99, "Cheese pizza", 800, true);
        Beverage coffee = new Beverage(3, "Coffee", 2.99, "Black coffee", "medium", true);

        Order order = new Order(101, "John Doe");
        order.addItem(pizza);
        order.addItem(coffee);
        order.calculateTotal();
        System.out.println("Total: $" + order.getTotalAmount());

        Employee cashier = new Employee(1, "Alice", "Cashier");
        cashier.processOrder(order);

        Payment payment = new Payment(201, order.getTotalAmount(), "Card");
        payment.processPayment(12.0);
        System.out.println(payment.getReceipt());
    }
}
