import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CuaHang {
    List<NguoiMua> danhSachNguoiMua = new ArrayList<>();
    List<Xe> danhSachXe = new ArrayList<>();

    public void themXe(Xe xe) {
        danhSachXe.add(xe);
    }

    public void themNguoiMua(NguoiMua nguoiMua) {
        danhSachNguoiMua.add(nguoiMua);
    }

    public void tinhTien(NguoiMua nguoiMua, Xe xe) {
        double tien = ((xe.giaTien - (nguoiMua.soTichDiem * 10)) * xe.giaTien / 100);
        System.out.println("Số tiền phải trả: " + tien);
        nguoiMua.soTichDiem += 1;
    }

    public void sapXepTheoNgayMua() {
        danhSachNguoiMua.sort(Comparator.comparing(nm -> nm.ngayMua));
    }

    public void inDanhSach() {
        for (NguoiMua nm : danhSachNguoiMua) {
            nm.print();
        }
    }

    public boolean kiemTraXeTonTai(String tenXe) {
        return danhSachXe.stream().anyMatch(x -> x.tenXe.equals(tenXe));
    }
}
