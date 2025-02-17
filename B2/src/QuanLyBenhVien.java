import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyBenhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BenhNhan> danhSachBenhNhan = new ArrayList<>();
        List<BacSi> danhSachBacSi = new ArrayList<>();

        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Hiển thị danh sách bệnh nhân");
            System.out.println("4. Hiển thị danh sách bác sĩ");
            System.out.println("5. Thoát");
            int chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhập tên bệnh nhân: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập năm sinh: ");
                    int namSinh = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String diaChi = scanner.nextLine();
                    System.out.print("Nhập ID bệnh nhân: ");
                    String idBN = scanner.nextLine();
                    danhSachBenhNhan.add(new BenhNhan(ten, namSinh, diaChi, idBN, "B001", "P001", "01/01/2025"));
                    break;
                case 2:
                    System.out.print("Nhập tên bác sĩ: ");
                    String tenBS = scanner.nextLine();
                    System.out.print("Nhập năm sinh: ");
                    int namSinhBS = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String diaChiBS = scanner.nextLine();
                    System.out.print("Nhập ID bác sĩ: ");
                    String idBS = scanner.nextLine();
                    danhSachBacSi.add(new BacSi(tenBS, namSinhBS, diaChiBS, idBS, "K001"));
                    break;
                case 3:
                    for (BenhNhan bn : danhSachBenhNhan) {
                        System.out.println(bn);
                    }
                    break;
                case 4:
                    for (BacSi bs : danhSachBacSi) {
                        System.out.println(bs);
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
