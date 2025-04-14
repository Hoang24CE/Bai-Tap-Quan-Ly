package dao;
import model.Customer;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        }
        return customers;
    }
}
