public class TestMain {
    public static void main(String[] args) { // Kiểm tra các hàm tạo và toString() // Bạn cần thêm 'f' hoặc 'F' vào một ký tự float
        Rectangle r1 = new Rectangle(1.2f, 3.4f);
        System.out.println(r1);   // toString()
        Rectangle r2 = new Rectangle();   // hàm tạo mặc định
        System.out.println(r2); // Kiểm tra các hàm thiết lập và lấy
        r1.setLength(5.6f);
        r1.setWidth(7.8f);
        System.out.println(r1);   // toString()
        System.out.println("length is: " + r1.getLength());
        System.out.println("width is: " + r1.getWidth()); // Kiểm tra getArea() và getPerimeter()
        System.out.printf("area is: %.2f%n", r1.getArea());
        System.out.printf("chu vi là: %.2f%n", r1.getPerimeter());
    }
}
