public class Countdown {
    public static void main(String[] args) {
        CountdownThread thread = new CountdownThread();
        thread.start();
    }
}
