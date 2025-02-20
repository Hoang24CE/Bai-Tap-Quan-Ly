public class BallTest {
    public static void main(String[] args) {
        // Tạo container 100x100
        Container box = new Container(0, 0, 100, 100);
        System.out.println(box); // In thông tin container

        // Tạo bóng ở vị trí (50,50), bán kính 5, tốc độ 5, góc 45 độ
        Ball ball = new Ball(50, 50, 5, 5, 45);
        System.out.println(ball); // In thông tin bóng ban đầu

        // Di chuyển bóng và kiểm tra va chạm
        for (int step = 0; step < 100; step++) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball); // Kiểm tra thủ công vị trí quả bóng
        }
    }
}
