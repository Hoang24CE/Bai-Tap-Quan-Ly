public class TestMoveable {
    public static void main(String[] args) {
        MoveablePoint point = new MoveablePoint(0, 0, 2, 3);
        System.out.println(point);  // In vị trí ban đầu

        point.moveUp();
        System.out.println("After moveUp: " + point);

        point.moveDown();
        System.out.println("After moveDown: " + point);

        point.moveLeft();
        System.out.println("After moveLeft: " + point);

        point.moveRight();
        System.out.println("After moveRight: " + point);
    }
}
