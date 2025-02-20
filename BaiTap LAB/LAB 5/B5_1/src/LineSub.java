class LineSub extends Point {
    private Point end; // Điểm kết thúc

    // Constructor mặc định
    public LineSub() {
        super(); // Gọi constructor của Point (mặc định là (0,0))
        this.end = new Point(1, 1);
    }

    // Constructor có tham số
    public LineSub(int x1, int y1, int x2, int y2) {
        super(x1, y1); // Gọi constructor của Point để thiết lập điểm đầu
        this.end = new Point(x2, y2);
    }

    // Getter và Setter cho điểm kết thúc
    public Point getEnd() {
        return end;
    }

    public void setEnd(int x, int y) {
        this.end.setX(x);
        this.end.setY(y);
    }

    // Tính độ dài đoạn thẳng
    public double getLength() {
        int dx = end.getX() - getX();
        int dy = end.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "LineSub[start=" + super.toString() + ", end=" + end + "]";
    }
}
