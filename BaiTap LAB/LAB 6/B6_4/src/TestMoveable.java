public class TestMoveable {
    public static void main(String[] args) {
        MoveablePoint point = new MoveablePoint(0, 0, 2, 3);
        System.out.println("Initial Point: " + point);

        point.moveUp();
        System.out.println("After moveUp: " + point);

        MoveableCircle circle = new MoveableCircle(5, 5, 1, 1, 10);
        System.out.println("Initial Circle: " + circle);

        circle.moveRight();
        System.out.println("After moveRight: " + circle);
    }
}
