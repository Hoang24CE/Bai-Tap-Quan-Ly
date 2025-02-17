import java.util.*;

interface Printable {
    void print();
}

class NguoiMua implements Printable {
    String hoTen, soDienThoai, soCCCD;
    int soTichDiem;
    Date ngayMua;
    String tenXe;

    public NguoiMua(String hoTen, String soDienThoai, String soCCCD, String tenXe, Date ngayMua) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soCCCD = soCCCD;
        this.tenXe = tenXe;
        this.ngayMua = ngayMua;
        this.soTichDiem = 0;
    }

    @Override
    public void print() {
        System.out.println("Người mua: " + hoTen + ", SDT: " + soDienThoai + ", CCCD: " + soCCCD + ", Xe: " + tenXe + ", Ngày mua: " + ngayMua + ", Điểm: " + soTichDiem);
    }
}