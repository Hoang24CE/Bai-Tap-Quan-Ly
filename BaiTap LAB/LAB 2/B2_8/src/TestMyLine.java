public class TestMyLine {
    public static void main(String[] args) {
        MyLine line = new MyLine(1, 2, 4, 6);
        System.out.println(line);
        System.out.println("Length: " + line.getLength());
        System.out.println("Gradient: " + line.getGradient());

        line.setBeginXY(0, 0);
        line.setEndXY(3, 4);
        System.out.println("Updated line: " + line);
        System.out.println("Updated Length: " + line.getLength());
    }
}