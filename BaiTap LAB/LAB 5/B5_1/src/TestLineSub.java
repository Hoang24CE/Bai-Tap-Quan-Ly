public class TestLineSub {
    public static void main(String[] args) {
        LineSub line1 = new LineSub();
        System.out.println(line1);
        System.out.println("Length: " + line1.getLength());

        LineSub line2 = new LineSub(2, 3, 5, 7);
        System.out.println(line2);
        System.out.println("Length: " + line2.getLength());
    }
}
