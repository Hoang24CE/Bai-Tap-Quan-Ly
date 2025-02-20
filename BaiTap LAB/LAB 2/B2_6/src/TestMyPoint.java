public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(3, 4);
        System.out.println("Point p1: " + p1);
        System.out.println("Distance from p1 to origin: " + p1.distance());

        MyPoint p2 = new MyPoint(6, 8);
        System.out.println("Point p2: " + p2);
        System.out.println("Distance from p1 to p2: " + p1.distance(p2));
        System.out.println("Distance from p1 to (10, 10): " + p1.distance(10, 10));

        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new MyPoint(i + 1, i + 1);
        }

        System.out.println("Array of MyPoint objects:");
        for (MyPoint point : points) {
            System.out.println(point);
        }
    }
}
