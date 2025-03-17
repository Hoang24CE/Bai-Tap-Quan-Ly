import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileProcessor {
    static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    static class ReaderThread extends Thread {
        private String fileName;

        public ReaderThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    queue.put(line);
                    System.out.println("[ReaderThread] Đọc: " + line);
                }
                queue.put("END"); // Đánh dấu kết thúc
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class ProcessorThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String line = queue.take(); // Lấy dòng từ hàng đợi
                    if (line.equals("END")) break;

                    // Xử lý: đếm số từ
                    int wordCount = line.trim().isEmpty() ? 0 : line.split("\\s+").length;
                    System.out.println("[ProcessorThread] Số từ trong dòng: " + wordCount);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B4\\src\\input.txt"; // Đảm bảo file này tồn tại

        // Khởi tạo và chạy các thread
        ReaderThread reader = new ReaderThread(filePath);
        ProcessorThread processor = new ProcessorThread();

        reader.start();
        processor.start();

        // Đợi cả hai thread hoàn thành
        try {
            reader.join();
            processor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hoàn thành xử lý file!");
    }
}
