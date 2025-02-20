public class TestBook {
    public static void main(String[] args) {
        // Tạo danh sách tác giả
        Author author1 = new Author("Nguyen Van A", "a@example.com", 'm');
        Author author2 = new Author("Tran Thi B", "b@example.com", 'f');
        Author[] authors = {author1, author2};

        // Tạo một quyển sách
        Book book1 = new Book("Java Programming", authors, 19.99, 10);

        // Kiểm tra phương thức toString()
        System.out.println(book1);

        // Kiểm tra lấy tên sách
        System.out.println("Tên sách: " + book1.getName());

        // Kiểm tra danh sách tác giả
        System.out.println("Danh sách tác giả: " + book1.getAuthorNames());

        // Kiểm tra thay đổi giá sách
        book1.setPrice(25.99);
        System.out.println("Giá mới: " + book1.getPrice());

        // Kiểm tra thay đổi số lượng
        book1.setQty(15);
        System.out.println("Số lượng mới: " + book1.getQty());
    }
}
