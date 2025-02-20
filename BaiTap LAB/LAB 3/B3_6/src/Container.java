public class Container {
    private int x1, y1, x2, y2;

    // Constructor
    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    // Getters
    public int getX() { return x1; }
    public int getY() { return y1; }
    public int getWidth() { return x2 - x1; }
    public int getHeight() { return y2 - y1; }

    // Phương thức kiểm tra va chạm với quả bóng
    public boolean collidesWith(Ball ball) {
        boolean collided = false;

        // Kiểm tra va chạm với biên ngang (trái/phải)
        if (ball.getX() - ball.getRadius() <= this.x1 ||
                ball.getX() + ball.getRadius() >= this.x2) {
            ball.reflectHorizontal();
            collided = true;
        }

        // Kiểm tra va chạm với biên dọc (trên/dưới)
        if (ball.getY() - ball.getRadius() <= this.y1 ||
                ball.getY() + ball.getRadius() >= this.y2) {
            ball.reflectVertical();
            collided = true;
        }

        return collided;
    }

    // toString method
    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }
}
