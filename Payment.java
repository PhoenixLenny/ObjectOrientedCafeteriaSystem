public class Payment {
    private int paymentId;
    private double amount;
    private String method;
    private String status = "Pending";

    // Constructor
    public Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    // Getters (No setters for immutability where possible)
    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }

    public void processPayment(double paidAmount) {
        if (paidAmount >= amount) {
            status = "Paid";
            System.out.println("Payment successful via " + method);
        } else {
            System.out.println("Insufficient payment.");
        }
    }

    public String getReceipt() {
        return "Payment ID: " + paymentId + ", Amount: $" + amount + ", Status: " + status;
    }
}