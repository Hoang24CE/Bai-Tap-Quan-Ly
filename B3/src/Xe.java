import java.util.Date;

public class Xe implements Printable {
    String tenXe, maSoThue, trangThai;
    double giaTien;

    public Xe(String tenXe, String maSoThue, double giaTien, String trangThai, Date date) {
        this.tenXe = tenXe;
        this.maSoThue = maSoThue;
        this.giaTien = giaTien;
        this.trangThai = trangThai;
    }

    @Override
    public void print() {
        System.out.println("Xe: " + tenXe + ", MST: " + maSoThue + ", Giá: " + giaTien + ", Trạng thái: " + trangThai);
    }
}
