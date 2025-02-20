class Player {
    private int number;
    float x;
    float y;
    private float z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
    }

    public boolean near(Ball ball) {
        float distance = (float) Math.sqrt(Math.pow(ball.getX() - x, 2) + Math.pow(ball.getY() - y, 2));
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, 0); // Giả định đá bóng đi xa 5 đơn vị mỗi chiều
            System.out.println("Player " + number + " kicked the ball!");
        } else {
            System.out.println("Ball is too far to kick.");
        }
    }
}
