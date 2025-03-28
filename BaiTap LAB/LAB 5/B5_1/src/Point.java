class Point {
    private int x, y;

    // Constructor mặc định
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor có tham số
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter và Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
