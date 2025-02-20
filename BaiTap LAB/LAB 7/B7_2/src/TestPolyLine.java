import java.util.Arrays;

public class TestPolyLine {
    public static void main(String[] args) {
        PolyLine polyline = new PolyLine();
        polyline.appendPoint(1, 2);
        polyline.appendPoint(4, 6);
        polyline.appendPoint(new Point(7, 10));

        System.out.println(polyline); // Expected output: {(1,2)(4,6)(7,10)}
        System.out.println("Length: " + polyline.getLength());
    }
}
