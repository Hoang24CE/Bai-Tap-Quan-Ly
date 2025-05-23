public class MyPoint {

    private int x = 0;
    private int y = 0;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public int[] getXY() {
        return new int[]{x, y};
    }

    public void  setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public  String toString() {
        return "(" + x + "," + y + ")";
    }

    //Khoảng cách từ x đến y
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    //Tính khoảng cách từ đối tượng MyPoint hiện tại đến một đối tượng MyPoint khác (another).
    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    //Tính khoảng cách từ điểm hiện tại đến gốc tọa độ (0,0).
    public double distance() {
        return distance(0, 0);
    }
}
