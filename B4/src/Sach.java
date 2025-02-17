public class Sach {
    String tenSach, maSach;
    boolean daDuocMuon;

    public Sach(String tenSach, String maSach, boolean daDuocMuon) {
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.daDuocMuon = daDuocMuon;
    }

    public void print() {
        System.out.println("Sach: " + tenSach + " (Ma: " + maSach + ") - Trang thai: " + (daDuocMuon ? "Da muon" : "Con trong"));
    }
}
