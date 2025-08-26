public class FoodItem extends MenuItem {
    private int calories;
    private boolean isVegetarian;

    // Constructor
    public FoodItem(int itemId, String name, double price, String description, int calories, boolean isVegetarian) {
        super(itemId, name, price, description);
        this.calories = calories;
        this.isVegetarian = isVegetarian;
    }

    // Getters and Setters
    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }
    public boolean isVegetarian() { return isVegetarian; }
    public void setVegetarian(boolean vegetarian) { isVegetarian = vegetarian; }

    // Polymorphism: Override
    @Override
    public String getDetails() {
        return "Food: " + getName() + " (" + calories + " cal, Vegetarian: " + isVegetarian + ") - $" + getPrice();
    }

    public void prepare() {
        System.out.println("Preparing " + getName() + "...");
    }
}