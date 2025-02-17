public class Phong {
    private String id;
    private String ten;
    private int soLuongGiuong;
    private int soLuongBenhNhan;

    public Phong(String id, String ten, int soLuongGiuong) {
        this.id = id;
        this.ten = ten;
        this.soLuongGiuong = soLuongGiuong;
        this.soLuongBenhNhan = 0;
    }

    public boolean themBenhNhan() {
        if (soLuongBenhNhan < soLuongGiuong) {
            soLuongBenhNhan++;
            return true;
        } else {
            System.out.println("Phòng quá tải!");
            return false;
        }
    }

    public void xoaBenhNhan() {
        if (soLuongBenhNhan > 0) {
            soLuongBenhNhan--;
        }
    }

    @Override
    public String toString() {
        return "Phòng: " + ten + " (ID: " + id + ") - Giường: " + soLuongGiuong + " - Bệnh nhân: " + soLuongBenhNhan;
    }
}
