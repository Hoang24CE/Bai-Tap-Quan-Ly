package controllers;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Customer;
import model.OrderItem;
import model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML private ComboBox<Customer> customerComboBox;
    @FXML private ComboBox<Product> productComboBox;
    @FXML private TextField quantityField;
    @FXML private ListView<String> orderListView;

    private final CustomerDAO customerDAO = new CustomerDAO();
    private final ProductDAO productDAO = new ProductDAO();
    private final OrderDAO orderDAO = new OrderDAO();

    private final List<OrderItem> orderItems = new ArrayList<>();

    @FXML
    public void initialize() {
        try {
            customerComboBox.getItems().addAll(customerDAO.getAllCustomers());
            productComboBox.getItems().addAll(productDAO.getAllProducts());
        } catch (SQLException e) {
            showAlert("Lỗi tải dữ liệu", e.getMessage());
        }
    }

    @FXML
    public void addProductToOrder() {
        Product product = productComboBox.getValue();
        int quantity = Integer.parseInt(quantityField.getText());

        if (product != null && quantity > 0) {
            orderItems.add(new OrderItem(0, product.getId(), quantity));
            orderListView.getItems().add(product.getName() + " x " + quantity);
        } else {
            showAlert("Lỗi", "Vui lòng chọn sản phẩm và nhập số lượng hợp lệ.");
        }
    }

    @FXML
    public void createOrder() {
        Customer customer = customerComboBox.getValue();
        if (customer != null && !orderItems.isEmpty()) {
            try {
                orderDAO.addOrder(customer.getId(), orderItems);
                orderListView.getItems().clear();
                orderItems.clear();
                showAlert("Thành công", "Đơn hàng đã được tạo.");
            } catch (SQLException e) {
                showAlert("Lỗi khi tạo đơn hàng", e.getMessage());
            }
        } else {
            showAlert("Lỗi", "Vui lòng chọn khách hàng và thêm sản phẩm.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
