import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuaHang cuaHang = new CuaHang();

        cuaHang.themXe(new Xe("Honda Air Blade", "AB123", 40000000, "Còn hàng", new Date()));
        cuaHang.themXe(new Xe("Honda SH", "SH456", 90000000, "Còn hàng", new Date()));
        cuaHang.themXe(new Xe("Siurus RC", "AB123", 25000000, "Còn hàng", new Date()));
        cuaHang.themXe(new Xe("Honda Dream", "AB123", 20000000, "Còn hàng", new Date()));
        cuaHang.themXe(new Xe("Cub 50", "AB123", 15000000, "Còn hàng", new Date()));


        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm thông tin người mua");
            System.out.println("2. Tìm người mua theo ngày mua");
            System.out.println("3. Hiển thị danh sách người mua");
            System.out.println("4. Hiển thị thành tiền");
            System.out.println("5. Thoát");
            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("Nhập thông tin người mua:");
                    System.out.print("Họ tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Số điện thoại: ");
                    String soDienThoai = scanner.nextLine();
                    System.out.print("Số CCCD: ");
                    String soCCCD = scanner.nextLine();
                    System.out.print("Tên xe muốn mua: ");
                    String tenXe = scanner.nextLine();
                    Date ngayMua = new Date();
                    if (cuaHang.kiemTraXeTonTai(tenXe)) {
                        NguoiMua nguoiMua = new NguoiMua(hoTen, soDienThoai, soCCCD, tenXe, ngayMua);
                        cuaHang.themNguoiMua(nguoiMua);
                        System.out.println("Người mua đã được thêm thành công.");
                    } else {
                        System.out.println("Xe không có sẵn trong cửa hàng.");
                    }
                    break;
                case 4:
                    System.out.println("Thành tiền:");
                    for (NguoiMua nm : cuaHang.danhSachNguoiMua) {
                        cuaHang.tinhTien(nm, cuaHang.danhSachXe.get(0));
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }
}
