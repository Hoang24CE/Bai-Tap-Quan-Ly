public class BenhNhan extends Person {
    private String idBenhNhan;
    private String idBenh;
    private String idPhong;
    private String ngayNhapVien;
    private String ngayXuatVien;
    private boolean daXuatVien;
    private String idBacSiDamNhiem;

    public BenhNhan(String ten, int namSinh, String diaChi, String idBenhNhan, String idBenh, String idPhong, String ngayNhapVien) {
        super(ten, namSinh, diaChi);
        this.idBenhNhan = idBenhNhan;
        this.idBenh = idBenh;
        this.idPhong = idPhong;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayXuatVien = "";
        this.daXuatVien = false;
    }

    public void xuatVien(String ngayXuatVien) {
        if (ngayXuatVien.compareTo(ngayNhapVien) >= 0) {
            this.ngayXuatVien = ngayXuatVien;
            this.daXuatVien = true;
        } else {
            System.out.println("Lỗi: Ngày xuất viện không hợp lệ.");
        }
    }

    public void doiBacSiDamNhiem(String idBacSi) {
        this.idBacSiDamNhiem = idBacSi;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID Bệnh nhân: " + idBenhNhan + ", ID bệnh: " + idBenh + ", ID phòng: " + idPhong +
                ", Ngày nhập viện: " + ngayNhapVien + ", Ngày xuất viện: " + (daXuatVien ? ngayXuatVien : "Chưa xuất viện");
    }
}
