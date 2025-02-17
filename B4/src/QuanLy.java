public class QuanLy {
    String hoTen, soDienThoai, email, soCCCD;

    public QuanLy(String hoTen, String soDienThoai, String email, String soCCCD) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.soCCCD = soCCCD;
    }

    public void print() {
        System.out.println("Quan ly: " + hoTen + ", SDT: " + soDienThoai + ", Email: " + email);
    }
}

