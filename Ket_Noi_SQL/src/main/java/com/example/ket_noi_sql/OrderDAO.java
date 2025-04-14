public void addOrder(int customerId, List<OrderItem> orderItems) throws SQLException {
    String orderSql = "INSERT INTO orders (customer_id) VALUES (?)";
    String orderItemSql = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection()) {
        conn.setAutoCommit(false);

        try (PreparedStatement orderStmt = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
            orderStmt.setInt(1, customerId);
            orderStmt.executeUpdate();
            ResultSet rs = orderStmt.getGeneratedKeys();

            if (rs.next()) {
                int orderId = rs.getInt(1);

                try (PreparedStatement orderItemStmt = conn.prepareStatement(orderItemSql)) {
                    for (OrderItem item : orderItems) {
                        orderItemStmt.setInt(1, orderId);
                        orderItemStmt.setInt(2, item.getProductId());
                        orderItemStmt.setInt(3, item.getQuantity());
                        orderItemStmt.addBatch();
                    }
                    orderItemStmt.executeBatch();
                }
                conn.commit();
            }
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }
}
