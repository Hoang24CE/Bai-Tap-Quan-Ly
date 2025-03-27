package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Book;
import model.XMLHandler;

public class LibraryController {
    @FXML private TableView<Book> tableView;
    @FXML private Button addButton, deleteButton;

    @FXML
    public void initialize() {
        tableView.getItems().addAll(XMLHandler.readBooks());

        addButton.setOnAction(e -> addBook());
        deleteButton.setOnAction(e -> deleteBook());
    }

    private void addBook() {
        Book book = new Book("Sách mới", "Tác giả", 2025, "Nhà XB", 250, "Khoa học", 120000, "978-1234567890");
        XMLHandler.addBook(book);
        tableView.getItems().add(book);
    }

    private void deleteBook() {
        Book selectedBook = tableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            tableView.getItems().remove(selectedBook);
        }
    }
}
