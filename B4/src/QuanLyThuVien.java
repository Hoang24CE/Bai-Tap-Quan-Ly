public class QuanLyThuVien {
    public static void main(String[] args) {
        ThuVien thuVien = new ThuVien();

        thuVien.themSach(new Sach("Lap trinh Java", "S001", false));
        thuVien.themSach(new Sach("Cau truc du lieu", "S002", true));
        thuVien.themSach(new Sach("Thiet ke Web", "S003", false));
        thuVien.themSach(new Sach("Tri tue nhan tao", "S004", true));
        thuVien.themSach(new Sach("Hoc may", "S005", false));

        System.out.println("Danh sach sach trong thu vien:");
        thuVien.hienThiDanhSachSach();
    }
}
