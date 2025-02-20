public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle resizableCircle = new ResizableCircle(10.0);
        System.out.println("Initial: " + resizableCircle);

        resizableCircle.resize(50);
        System.out.println("After resize(50%): " + resizableCircle);

        resizableCircle.resize(200);
        System.out.println("After resize(200%): " + resizableCircle);
    }
}
