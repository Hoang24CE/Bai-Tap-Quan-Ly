import java.util.ArrayList;
import java.util.List;

public class BacSi extends Person {
    private String idBacSi;
    private String idKhoaDamNhiem;
    private List<String> danhSachBenhNhan;

    public BacSi(String ten, int namSinh, String diaChi, String idBacSi, String idKhoaDamNhiem) {
        super(ten, namSinh, diaChi);
        this.idBacSi = idBacSi;
        this.idKhoaDamNhiem = idKhoaDamNhiem;
        this.danhSachBenhNhan = new ArrayList<>();
    }

    public void themBenhNhan(String idBenhNhan) {
        danhSachBenhNhan.add(idBenhNhan);
    }

    public void xoaBenhNhan(String idBenhNhan) {
        danhSachBenhNhan.remove(idBenhNhan);
    }

    public void doiKhoaDamNhiem(String idKhoaMoi) {
        this.idKhoaDamNhiem = idKhoaMoi;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID Bác sĩ: " + idBacSi + ", Khoa đảm nhiệm: " + idKhoaDamNhiem + ", Bệnh nhân: " + danhSachBenhNhan;
    }
}
