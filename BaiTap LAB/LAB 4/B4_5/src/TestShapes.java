public class TestShapes {
    public static void main(String[] args) {
        Shape shape = new Shape("blue", false);
        System.out.println(shape);

        Circle circle = new Circle(5.5, "green", true);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(2.0, 3.0, "yellow", false);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        Square square = new Square(4.0, "purple", true);
        System.out.println(square);
        System.out.println("Side: " + square.getSide());
    }
}
