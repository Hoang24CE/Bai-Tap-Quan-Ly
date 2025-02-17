import java.util.ArrayList;
import java.util.List;

public class Khoa {
    private String id;
    private String ten;
    private List<BacSi> bacSiList;

    public Khoa(String id, String ten) {
        this.id = id;
        this.ten = ten;
        this.bacSiList = new ArrayList<>();
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void themBacSi(BacSi bacSi) {
        bacSiList.add(bacSi);
    }

    @Override
    public String toString() {
        return "Khoa: " + ten + " (ID: " + id + ")";
    }
}
