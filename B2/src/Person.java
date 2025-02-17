import java.util.*;

class Person {
    protected String ten;
    protected int namSinh;
    protected String diaChi;

    public Person(String ten, int namSinh, String diaChi) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    public String getTen() { return ten; }
    public int getNamSinh() { return namSinh; }
    public String getDiaChi() { return diaChi; }

    @Override
    public String toString() {
        return "Tên: " + ten + ", Năm sinh: " + namSinh + ", Địa chỉ: " + diaChi;
    }
}