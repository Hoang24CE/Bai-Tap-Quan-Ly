
public class Circle {

    private double radius;
//
    public Circle() {  // 1st (default) constructor
        radius = 1.0;
    }
//
    public Circle(double r) {  // 2nd constructor
        radius = r;
    }
//
    public double getRadius() {
        return radius;
    }
//
    public double getArea() {
        return radius*radius*Math.PI;
    }
//
    public double getCircumference() {
        return 2*radius*Math.PI;
    }
//
    public void setRadius(double radius) {
        this.radius = radius;
    }
}