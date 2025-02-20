
public class Circle {

    private double radius;
    private String color;
//
    public Circle() {  // 1st (default) constructor
        radius = 1.0;
        color = "red";
    }
//
    public Circle(double r) {  // 2nd constructor
        radius = r;
        color = "red";
    }
//
    public double getRadius() {
        return radius;
    }
//
    public double getArea() {
        return radius*radius*Math.PI;
    }
}