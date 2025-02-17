import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Khoa> danhSachKhoa = new ArrayList<>();
        List<Phong> danhSachPhong = new ArrayList<>();
        List<BacSi> danhSachBacSi = new ArrayList<>();

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm khoa");
            System.out.println("2. Thêm phòng");
            System.out.println("3. Thêm bác sĩ");
            System.out.println("4. Thoát");

            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhập ID khoa: ");
                    String idKhoa = scanner.nextLine();
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa = scanner.nextLine();
                    danhSachKhoa.add(new Khoa(idKhoa, tenKhoa));
                    break;
                case 2:
                    System.out.print("Nhập ID phòng: ");
                    String idPhong = scanner.nextLine();
                    System.out.print("Nhập tên phòng: ");
                    String tenPhong = scanner.nextLine();
                    System.out.print("Nhập số giường: ");
                    int soGiuong = scanner.nextInt();
                    danhSachPhong.add(new Phong(idPhong, tenPhong, soGiuong));
                    break;
                case 3:
                    System.out.print("Nhập ID bác sĩ: ");
                    String idBacSi = scanner.nextLine();
                    System.out.print("Nhập tên bác sĩ: ");
                    String tenBacSi = scanner.nextLine();
                    danhSachBacSi.add(new BacSi(idBacSi, tenBacSi));
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
