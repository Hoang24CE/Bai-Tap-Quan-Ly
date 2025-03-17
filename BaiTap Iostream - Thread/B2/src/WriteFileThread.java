import java.io.*;
class WriteFileThread extends Thread {
    private String filePath;
    private String content;
    public WriteFileThread(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }
    public void run() {
        synchronized (WriteFileThread.class) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(content);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String filePath = "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B2\\src\\output.txt";
        WriteFileThread thread1 = new WriteFileThread(filePath, "Thread 1: ghi dữ liệu 1");
        WriteFileThread thread2 = new WriteFileThread(filePath, "Thread 2: ghi dữ liệu 2");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ghi dữ liệu hoàn tất vào output.txt");
    }
}
