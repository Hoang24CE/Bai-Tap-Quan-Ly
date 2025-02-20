
public class TestAuthor {
    public static void main(String[] args) {
        // Tạo một đối tượng Author
        Author author1 = new Author("Nguyen Van A", "nguyenvana@example.com", 'm');

        // Hiển thị thông tin tác giả bằng phương thức toString()
        System.out.println(author1);

        // Kiểm thử các phương thức getter
        System.out.println("Tên: " + author1.getName());
        System.out.println("Email: " + author1.getEmail());
        System.out.println("Giới tính: " + author1.getGender());

        // Kiểm thử phương thức setter cho email
        author1.setEmail("newemail@example.com");
        System.out.println("Email mới: " + author1.getEmail());

        // Hiển thị lại thông tin sau khi cập nhật email
        System.out.println(author1);
    }
}