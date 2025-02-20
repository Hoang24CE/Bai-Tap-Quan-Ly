public class Ball {
    private float x, y;
    private int radius;
    private float xDelta, yDelta;

    // Constructor
    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
        this.yDelta = (float) (speed * Math.sin(Math.toRadians(direction)));
    }

    // Getters and Setters
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }

    public float getXDelta() { return xDelta; }
    public void setXDelta(float xDelta) { this.xDelta = xDelta; }

    public float getYDelta() { return yDelta; }
    public void setYDelta(float yDelta) { this.yDelta = yDelta; }

    // Move the ball
    public void move() {
        x += xDelta;
        y += yDelta;
    }

    // Reflect if colliding with a horizontal wall
    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    // Reflect if colliding with a vertical wall
    public void reflectVertical() {
        yDelta = -yDelta;
    }

    // toString method
    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "), speed=(" + xDelta + "," + yDelta + ")]";
    }
}
