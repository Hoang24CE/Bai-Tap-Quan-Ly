public class SoccerGame {
    public static void main(String[] args) {
        Ball ball = new Ball(10, 10, 0);
        Player player1 = new Player(7, 12, 12);

        System.out.println("Initial Ball Position: " + ball);
        System.out.println("Player 1 Position: (" + player1.x + ", " + player1.y + ")");

        if (player1.near(ball)) {
            System.out.println("Player 1 is near the ball.");
        } else {
            System.out.println("Player 1 is too far from the ball.");
        }

        player1.kick(ball);
        System.out.println("Ball Position after kick: " + ball);
    }
}
