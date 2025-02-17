import java.util.*;

class BacSi {
    private String id;
    private String ten;

    public BacSi(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public String getId() { return id; }
    public String getTen() { return ten; }

    @Override
    public String toString() {
        return "Bác sĩ: " + ten + " (ID: " + id + ")";
    }
}