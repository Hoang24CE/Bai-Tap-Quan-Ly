public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;
//
    public Ball(float x, float y, int radius, float xDelta, float yDelta) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }
//
    public float getX() {
        return x;
    }
//
    public void setX(float x) {
        this.x = x;
    }
//
    public float getY() {
        return y;
    }
//
    public void setY(float y) {
        this.y = y;
    }
//
    public int getRadius() {
        return radius;
    }
//
    public void setRadius(int radius) {
        this.radius = radius;
    }
//
    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }
//
    public float getXDelta() {
        return xDelta;
    }
//
    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }
//
    public float getYDelta() {
        return yDelta;
    }
//
    public void move() {
        x += x * xDelta;
        y += y * yDelta;
    }
//
    //Đảo ngược giá trị x qua trục y
    public void reflectHorizontal() {
        this.xDelta = -xDelta;
    }
//
    //Đảo ngược giá trị y qua trục x
    public void reflectVertical() {
        this.yDelta = -yDelta;
    }
//
    public String toString() {
        return "Ball[(" + x + "," + y + ")" + "," + "speed=(" + xDelta + "," + yDelta + ")]";
    }
}
