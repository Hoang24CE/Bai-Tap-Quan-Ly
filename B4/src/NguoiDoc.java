import java.util.*;

class NguoiDoc {
    String hoTen, soDienThoai, email, maSinhVien;
    Date ngayMuon, ngayTra;

    public NguoiDoc(String hoTen, String soDienThoai, String email, String maSinhVien, Date ngayMuon, Date ngayTra) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.maSinhVien = maSinhVien;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public void print() {
        System.out.println("Nguoi doc: " + hoTen + ", SDT: " + soDienThoai + ", Email: " + email + ", Ma SV: " + maSinhVien);
    }
}