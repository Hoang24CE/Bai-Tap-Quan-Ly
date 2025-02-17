public class QuanLy implements Printable {
    String hoTen, soDienThoai, soCCCD;

    public QuanLy(String hoTen, String soDienThoai, String soCCCD) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soCCCD = soCCCD;
    }

    @Override
    public void print() {
        System.out.println("Quản lý: " + hoTen + ", SDT: " + soDienThoai + ", CCCD: " + soCCCD);
    }
}
