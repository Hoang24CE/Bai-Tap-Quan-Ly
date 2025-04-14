package com.example.ketnoisql.dao;

import com.example.ketnoisql.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    public static Product getProductById(int id) throws SQLException {
        String query = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
        }
        return null;
    }
}
