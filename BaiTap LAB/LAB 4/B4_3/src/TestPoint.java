public class TestPoint {
    public static void main(String[] args) {
        Point2D p2d = new Point2D(3.5f, 4.5f);
        System.out.println("Point2D: " + p2d);
        System.out.println("Coordinates: " + java.util.Arrays.toString(p2d.getXY()));

        Point3D p3d = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Point3D: " + p3d);
        System.out.println("Coordinates: " + java.util.Arrays.toString(p3d.getXY()));
    }
}
