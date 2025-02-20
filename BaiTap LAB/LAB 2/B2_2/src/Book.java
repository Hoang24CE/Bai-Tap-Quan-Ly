import java.util.Arrays;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0; // Mặc định là 0

    // Constructor 1 (Không có qty)
    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    // Constructor 2 (Có qty)
    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Getter cho authors
    public Author[] getAuthors() {
        return authors;
    }

    // Getter cho price
    public double getPrice() {
        return price;
    }

    // Setter cho price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter cho qty
    public int getQty() {
        return qty;
    }

    // Setter cho qty
    public void setQty(int qty) {
        this.qty = qty;
    }

    // Phương thức trả về danh sách tên tác giả
    public String getAuthorNames() {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            names.append(authors[i].getName());
            if (i < authors.length - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }

    // toString method
    @Override
    public String toString() {
        return "Book[name=" + name + ", authors=" + Arrays.toString(authors) + ", price=" + price + ", qty=" + qty + "]";
    }
}
