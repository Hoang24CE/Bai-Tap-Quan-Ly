import java.io.*;

class CopyFileThread extends Thread {
    private String source;
    private String destination;

    public CopyFileThread(String source, String destination) { // Nhận file nguồn và file đích
        this.source = source;
        this.destination = destination;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Sao chép hoàn tất!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyFileThread thread = new CopyFileThread("C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B3\\src\\input", "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B3\\src\\copy");
        thread.start();
    }
}
