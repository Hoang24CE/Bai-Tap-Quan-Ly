public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle(3, 4, 5);
        MyCircle c2 = new MyCircle(new MyPoint(6, 8), 10);

        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Circumference: " + c1.getCircumference());

        System.out.println(c2);
        System.out.println("Distance between c1 and c2: " + c1.distance(c2));

        c1.setCenterXY(0, 0);
        c1.setRadius(7);
        System.out.println("Updated c1: " + c1);
    }
}