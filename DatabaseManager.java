import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/cafeteria_db";
    private static final String USER = "phoenix";
    private static final String PASS = "12345678";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createMenuItem(String name, double price, String description, String type) {
        String sql = "INSERT INTO menu_items (name, price, description, type) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setString(3, description);
            pstmt.setString(4, type);
            pstmt.executeUpdate();
            System.out.println("Item created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readMenuItems() {
        String sql = "SELECT * FROM menu_items";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateMenuItem(MenuItem item) {
        String sql = "UPDATE menu_items SET name = ?, price = ?, description = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getName());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setString(3, item.getDescription());
            pstmt.setInt(4, item.getItemId());
            pstmt.executeUpdate();
            System.out.println("Item updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMenuItem(int id) {
        String sql = "DELETE FROM menu_items WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Item deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
