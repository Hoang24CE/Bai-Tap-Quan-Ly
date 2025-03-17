public class KeyboardToFile {
    public static void main(String[] args) {
        KeyboardWriterThread writerThread = new KeyboardWriterThread();
        writerThread.start();

        try {
            writerThread.join(); // Chờ thread kết thúc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chương trình đã kết thúc.");
    }
}