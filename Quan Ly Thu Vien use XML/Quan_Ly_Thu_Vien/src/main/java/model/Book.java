package model;

public class Book {
    private String title, author, publisher, genre, isbn;
    private int year, pages;
    private double price;

    public Book(String title, String author, int year, String publisher, int pages, String genre, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.pages = pages;
        this.genre = genre;
        this.price = price;
        this.isbn = isbn;
    }

    // Thêm getter
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getPublisher() { return publisher; }
    public int getPages() { return pages; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public String getIsbn() { return isbn; }
}
