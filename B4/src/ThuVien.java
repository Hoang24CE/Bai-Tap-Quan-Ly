import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThuVien {
    List<Sach> danhSachSach = new ArrayList<>();
    List<NguoiDoc> danhSachNguoiDoc = new ArrayList<>();

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public void themNguoiDoc(NguoiDoc nguoiDoc) {
        danhSachNguoiDoc.add(nguoiDoc);
    }

    public void hienThiDanhSachSach() {
        for (Sach sach : danhSachSach) {
            sach.print();
        }
    }

    public void timNguoiDocTheoNgay(Date ngay) {
        for (NguoiDoc nd : danhSachNguoiDoc) {
            if (nd.ngayMuon.equals(ngay) || nd.ngayTra.equals(ngay)) {
                nd.print();
            }
        }
    }

    public void kiemTraSach() {
        for (Sach sach : danhSachSach) {
            System.out.println(sach.tenSach + " - " + (sach.daDuocMuon ? "Da muon" : "Con trong"));
        }
    }
}
