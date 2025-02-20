public class TestMovable {
    public static void main(String[] args) {
        MovableRectangle rect = new MovableRectangle(0, 10, 10, 0, 2, 2);
        System.out.println(rect);  // Initial state
        rect.moveRight();
        rect.moveDown();
        System.out.println(rect);  // After movement
    }
}
