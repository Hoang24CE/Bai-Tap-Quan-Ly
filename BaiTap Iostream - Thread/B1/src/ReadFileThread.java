import java.io.*;
class ReadFileThread extends Thread {
    private String filePath;
    public ReadFileThread(String filePath) {
        this.filePath = filePath;
    }
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ReadFileThread thread = new ReadFileThread("C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B1\\src\\in.txt");
        thread.start();
    }
}
