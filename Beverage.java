public class Beverage extends MenuItem {
    private String size;
    private boolean isHot;

    // Constructor
    public Beverage(int itemId, String name, double price, String description, String size, boolean isHot) {
        super(itemId, name, price, description);
        this.size = size;
        this.isHot = isHot;
    }

    // Getters and Setters
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public boolean isHot() { return isHot; }
    public void setHot(boolean hot) { isHot = hot; }

    // Polymorphism: Override
    @Override
    public String getDetails() {
        return "Beverage: " + getName() + " (" + size + ", Hot: " + isHot + ") - $" + getPrice();
    }

    public void serve() {
        System.out.println("Serving " + getName() + " in " + size + " size.");
    }
}