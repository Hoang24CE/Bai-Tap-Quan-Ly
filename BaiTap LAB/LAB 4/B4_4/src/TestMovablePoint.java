public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(2.0f, 3.0f, 1.0f, 1.5f);
        System.out.println("Before move: " + mp);

        mp.move();
        System.out.println("After move: " + mp);
    }
}
