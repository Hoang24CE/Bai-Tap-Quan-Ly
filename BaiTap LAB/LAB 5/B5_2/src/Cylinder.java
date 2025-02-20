class Cylinder {
    private Circle base;  // Sử dụng composition thay vì kế thừa
    private double height;

    // Constructor mặc định
    public Cylinder() {
        this.base = new Circle(); // Mặc định Circle với bán kính 1.0, màu đỏ
        this.height = 1.0;
    }

    // Constructor có tham số
    public Cylinder(double radius, String color, double height) {
        this.base = new Circle(radius, color);
        this.height = height;
    }

    // Getter và Setter
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return base.getRadius();
    }

    public void setRadius(double radius) {
        base.setRadius(radius);
    }

    public String getColor() {
        return base.getColor();
    }

    public void setColor(String color) {
        base.setColor(color);
    }

    // Tính thể tích hình trụ
    public double getVolume() {
        return base.getArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder[base=" + base.toString() + ", height=" + height + "]";
    }
}
