public class Book {

    private String isbn;
    private String name;
    private Author author;
    private double price;
    private int  qty = 0;
//
    public Book(String isbn, String name, Author author, double price) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }
//
    public Book(String isbn, String name, Author author, double price, int qty) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.price = price;
    }
//
    public String getIsbn() {
        return isbn;
    }
//
    public String getName() {
        return name;
    }
//
    public void setName(String name) {
        this.name = name;
    }
//
    public double getPrice() {
        return price;
    }
//
    public void setPrice(double price) {
        this.price = price;
    }
//
    public int getQty() {
        return qty;
    }
//
    public void setQty(int qty) {
        this.qty = qty;
    }
//
    public String getAuthorName() {
        return author.getName();
    }
//
    public String toString() {
        return "Book[isbn=" + isbn + ",name=" + name + ",Author[name=" + name + ",email=" + name + "],price=" + price + ",qty=" + qty + "]";
    }
//
    public Author getAuthor() {
        return author;
    }
//
    public void setAuthor(Author author) {
        this.author = author;
    }
}
