public class TestMain {
    public static void main(String[] args) { // Kiểm tra hàm tạo và toString()
        InvoiceItem inv1 = new InvoiceItem("A101", "Pen Red", 888, 0.08);
        System.out.println(inv1);   // toString(); // Kiểm tra các phương thức thiết lập và lấy dữ liệu
        inv1.setQty(999);
        inv1.setUnitPrice(0.99);
        System.out.println(inv1);   // toString();
        System.out.println("id là: " + inv1.getId());
        System.out.println("desc là: " + inv1.getDesc());
        System.out.println("qty là: " + inv1.getQty());
        System.out.println("unitPrice là: " + inv1.getUnitPrice()); // Kiểm tra getTotal()
        System.out.println("Tổng số là: " + inv1.getTotal());
    }
}

