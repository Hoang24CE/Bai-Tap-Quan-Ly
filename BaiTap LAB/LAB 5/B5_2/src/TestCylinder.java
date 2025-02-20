public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println(c1);
        System.out.println("Volume: " + c1.getVolume());

        Cylinder c2 = new Cylinder(2.5, "blue", 5.0);
        System.out.println(c2);
        System.out.println("Volume: " + c2.getVolume());
    }
}
